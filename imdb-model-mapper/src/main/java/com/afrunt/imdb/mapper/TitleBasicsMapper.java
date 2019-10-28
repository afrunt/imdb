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
package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleBasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class TitleBasicsMapper extends ModelMapper<TitleBasics> {

    @Override
    public TitleBasics map(String[] strings) {
        return new TitleBasics()
                .setTitleId(stringToId(strings[0], "tt"))
                .setTitleType(strings[1].trim())
                .setPrimaryTitle(strings[2])
                .setOriginalTitle(strings[3])
                .setAdult(!"0".equals(strings[4].trim()))
                .setStartYear(stringToInteger(strings[5]))
                .setEndYear(stringToInteger(strings[6]))
                .setRuntimeMinutes(stringToInteger(strings[7]))
                .setGenres(whenAvailable(strings[8]).map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).orElse(Collections.emptyList()));
    }
}
