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

import com.afrunt.imdb.model.TitleAkas;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class TitleAkasMapper extends ModelMapper<TitleAkas> {
    @Override
    public TitleAkas map(String[] strings) {
        return new TitleAkas()
                .setTitleId(stringToId(strings[0], "tt"))
                .setOrdering(stringToInteger(strings[1]))
                .setTitle(strings[2].trim())
                .setRegion(whenAvailableString(strings[3]))
                .setLanguage(whenAvailableString(strings[4]))
                .setTypes(
                        whenAvailable(strings[5])
                                .map(s -> Arrays.stream(s.split(",")).map(String::trim).collect(Collectors.toList()))
                                .orElse(Collections.emptyList())
                )
                .setAttributes(whenAvailableString(strings[6]))
                .setOriginalTitle(whenAvailable(strings[7]).map(s -> !"0".equals(s)).orElse(false))
                ;
    }
}
