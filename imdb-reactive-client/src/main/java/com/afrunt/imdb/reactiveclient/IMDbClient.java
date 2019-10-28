package com.afrunt.imdb.reactiveclient;

import com.afrunt.imdb.iterator.IMDBbTsvIterator;
import com.afrunt.imdb.mapper.ModelMapper;
import com.afrunt.imdb.model.IMDbModel;
import com.afrunt.imdb.model.InputStreamsProvider;
import com.afrunt.imdb.model.TitleBasics;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class IMDbClient {
    private InputStreamsProvider inputStreamsProvider = new InputStreamsProvider();

    public IMDbClient() {
    }

    public IMDbClient(InputStreamsProvider inputStreamsProvider) {
        this();
        this.inputStreamsProvider = inputStreamsProvider;
    }

    public static void main(String[] args) {
        new IMDbClient()
                .fluxFor(TitleBasics.class)
                .subscribe(System.out::println);

    }

    public <T extends IMDbModel> Publisher<T> publisherFor(Class<T> type) {
        return fluxFor(type);
    }

    public <T extends IMDbModel> Flux<T> fluxFor(Class<T> type) {
        return modelFlux(type);
    }

    private <T extends IMDbModel> Flux<T> modelFlux(Class<T> type) {
        return Flux
                .using(
                        () -> new IMDBbTsvIterator(() -> inputStreamsProvider.inputStreamSupplierFor(type).get()),
                        iterator -> Flux
                                .fromIterable(iterator)
                                .skip(1),
                        IMDBbTsvIterator::close
                )
                .map(strings -> ModelMapper.forType(type).map(strings));
    }
}
