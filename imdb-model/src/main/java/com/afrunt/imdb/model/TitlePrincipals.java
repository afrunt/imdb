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

import java.util.List;

/**
 * @author Andrii Frunt
 */
public class TitlePrincipals implements IMDbModel {
    private Long titleId;
    private Integer ordering;
    private Long nameId;
    private String category;
    private String job;
    private List<String> characters;

    public Long getTitleId() {
        return titleId;
    }

    public TitlePrincipals setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public TitlePrincipals setOrdering(Integer ordering) {
        this.ordering = ordering;
        return this;
    }

    public Long getNameId() {
        return nameId;
    }

    public TitlePrincipals setNameId(Long nameId) {
        this.nameId = nameId;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public TitlePrincipals setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getJob() {
        return job;
    }

    public TitlePrincipals setJob(String job) {
        this.job = job;
        return this;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public TitlePrincipals setCharacters(List<String> characters) {
        this.characters = characters;
        return this;
    }

    @Override
    public String toString() {
        return "TitlePrincipals{" +
                "titleId=" + titleId +
                ", ordering=" + ordering +
                ", nameId=" + nameId +
                ", category='" + category + '\'' +
                ", job='" + job + '\'' +
                ", characters=" + characters +
                '}';
    }
}
