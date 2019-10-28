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
public class TitleAkas implements IMDbModel {
    private Long titleId;
    private Integer ordering;
    private String title;
    private String region;
    private String language;
    private List<String> types;
    private String attributes;
    private boolean isOriginalTitle;

    public Long getTitleId() {
        return titleId;
    }

    public TitleAkas setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public TitleAkas setOrdering(Integer ordering) {
        this.ordering = ordering;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TitleAkas setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public TitleAkas setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public TitleAkas setLanguage(String language) {
        this.language = language;
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public TitleAkas setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public String getAttributes() {
        return attributes;
    }

    public TitleAkas setAttributes(String attributes) {
        this.attributes = attributes;
        return this;
    }

    public boolean isOriginalTitle() {
        return isOriginalTitle;
    }

    public TitleAkas setOriginalTitle(boolean originalTitle) {
        isOriginalTitle = originalTitle;
        return this;
    }

    @Override
    public String toString() {
        return "TitleAkas{" +
                "titleId=" + titleId +
                ", ordering=" + ordering +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", language='" + language + '\'' +
                ", types='" + types + '\'' +
                ", attributes='" + attributes + '\'' +
                ", isOriginalTitle=" + isOriginalTitle +
                '}';
    }
}
