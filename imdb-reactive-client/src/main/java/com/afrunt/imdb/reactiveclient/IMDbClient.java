/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.afrunt.imdb.reactiveclient;

import com.afrunt.imdb.iterator.IMDBbTsvIterator;
import com.afrunt.imdb.mapper.ModelMapper;
import com.afrunt.imdb.model.IMDbModel;
import com.afrunt.imdb.model.InputStreamsProvider;
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
