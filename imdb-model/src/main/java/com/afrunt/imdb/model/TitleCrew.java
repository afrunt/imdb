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
package com.afrunt.imdb.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrii Frunt
 */
public class TitleCrew implements IMDbModel {
    private Long titleId;

    private Set<Long> directors = new HashSet<>();

    private Set<Long> writers = new HashSet<>();

    public Long getTitleId() {
        return titleId;
    }

    public TitleCrew setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public Set<Long> getDirectors() {
        return directors;
    }

    public TitleCrew setDirectors(Set<Long> directors) {
        this.directors = directors;
        return this;
    }

    public Set<Long> getWriters() {
        return writers;
    }

    public TitleCrew setWriters(Set<Long> writers) {
        this.writers = writers;
        return this;
    }

    @Override
    public String toString() {
        return "TitleCrew{" +
                "titleId=" + titleId +
                ", directors=" + directors +
                ", writers=" + writers +
                '}';
    }
}
