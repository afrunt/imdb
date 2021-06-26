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

import com.afrunt.imdb.model.IMDbModel;
import com.afrunt.imdb.model.InputStreamsProvider;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class IMDbClient {
    private final com.afrunt.imdb.client.IMDbClient simpleClient;

    public IMDbClient() {
        this(new InputStreamsProvider());
    }

    public IMDbClient(InputStreamsProvider inputStreamsProvider) {
        this.simpleClient = new com.afrunt.imdb.client.IMDbClient(inputStreamsProvider);
    }

    public <T extends IMDbModel> Publisher<T> publisherOf(Class<T> type) {
        return fluxOf(type);
    }

    public <T extends IMDbModel> Flux<T> fluxOf(Class<T> type) {
        return modelFlux(type);
    }

    private <T extends IMDbModel> Flux<T> modelFlux(Class<T> type) {
        return Flux
                .using(
                        () -> simpleClient.iteratorOf(type),
                        Flux::fromIterable,
                        com.afrunt.imdb.client.IMDbClient.IMDbIterator::close
                );
    }
}
