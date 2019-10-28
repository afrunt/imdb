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

import com.afrunt.imdb.model.Name;

import java.util.Arrays;
import java.util.stream.Collectors;

class NameMapper extends ModelMapper<Name> {
    @Override
    public Name map(String[] strings) {
        Name nm = new Name()
                .setNameId(stringToId(strings[0], "nm"))
                .setPrimaryName(strings[1].trim())
                .setBirthYear(stringToInteger(strings[2]))
                .setDeathYear(stringToInteger(strings[3]));

        if (strings.length > 4 && strings[4] != null) {
            nm.setPrimaryProfessions(Arrays.stream(strings[4].split(",")).map(String::trim).collect(Collectors.toList()));
        }

        if (strings.length > 5 && strings[5] != null && !strings[5].trim().equals("\\N")) {
            nm.setKnownForTitles(stringToIds(strings[5], "tt"));
        }

        return nm;
    }
}
