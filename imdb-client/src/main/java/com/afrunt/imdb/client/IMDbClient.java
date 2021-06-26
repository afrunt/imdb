package com.afrunt.imdb.client;

import com.afrunt.imdb.iterator.IMDBbTsvIterator;
import com.afrunt.imdb.mapper.ModelMapper;
import com.afrunt.imdb.model.IMDbModel;
import com.afrunt.imdb.model.InputStreamsProvider;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IMDbClient {
    private final InputStreamsProvider inputStreamsProvider;

    public IMDbClient() {
        this(new InputStreamsProvider());
    }

    public IMDbClient(InputStreamsProvider inputStreamsProvider) {
        this.inputStreamsProvider = inputStreamsProvider;
    }

    public <T extends IMDbModel> Stream<T> streamOf(Class<T> type) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iteratorOf(type), Spliterator.ORDERED),
                false);
    }

    public <T extends IMDbModel> IMDbIterator<T> iteratorOf(Class<T> type) {
        Supplier<InputStream> inputStreamSupplier = inputStreamsProvider.inputStreamSupplierFor(type);

        return new IMDbIterator<>(ModelMapper.forType(type), new IMDBbTsvIterator(inputStreamSupplier));
    }

    public static class IMDbIterator<T extends IMDbModel> implements Iterator<T>, Iterable<T>, AutoCloseable {
        private final ModelMapper<T> mapper;
        private final IMDBbTsvIterator tsvIterator;
        private volatile boolean headerSkipped = false;
        private volatile boolean closed = false;

        private IMDbIterator(ModelMapper<T> mapper, IMDBbTsvIterator tsvIterator) {
            this.mapper = mapper;
            this.tsvIterator = tsvIterator;
        }

        @Override
        public synchronized boolean hasNext() {
            skipHeaderIfNeeded();
            boolean hasNext = tsvIterator.hasNext();
            if (!hasNext) {
                close();
            }
            return hasNext;
        }

        @Override
        public synchronized T next() {
            skipHeaderIfNeeded();
            String[] next = tsvIterator.next();
            return mapper.map(next);
        }

        private void skipHeaderIfNeeded() {
            if (!headerSkipped && tsvIterator.hasNext()) {
                tsvIterator.next();
                headerSkipped = true;
            }
        }

        @Override
        public void close() {
            if (!closed) {
                tsvIterator.close();
                closed = true;
            }
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }
    }
}
