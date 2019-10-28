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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Andrii Frunt
 */
public class Name implements IMDbModel {
    private Long nameId;

    private String primaryName;

    private Integer birthYear;
    private Integer deathYear;

    private List<String> primaryProfessions = new ArrayList<>();
    private Set<Long> knownForTitles = new HashSet<>();

    public Long getNameId() {
        return nameId;
    }

    public Name setNameId(Long nameId) {
        this.nameId = nameId;
        return this;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public Name setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
        return this;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Name setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public Name setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
        return this;
    }

    public List<String> getPrimaryProfessions() {
        return primaryProfessions;
    }

    public Name setPrimaryProfessions(List<String> primaryProfessions) {
        this.primaryProfessions = primaryProfessions;
        return this;
    }

    public Set<Long> getKnownForTitles() {
        return knownForTitles;
    }

    public Name setKnownForTitles(Set<Long> knownForTitles) {
        this.knownForTitles = knownForTitles;
        return this;
    }

    @Override
    public String toString() {
        return "Name{" +
                "nameId=" + nameId +
                ", primaryName='" + primaryName + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", primaryProfessions=" + primaryProfessions +
                ", knownForTitles=" + knownForTitles +
                '}';
    }
}
