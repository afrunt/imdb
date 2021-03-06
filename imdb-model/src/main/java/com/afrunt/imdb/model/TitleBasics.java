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
import java.util.List;

/**
 * @author Andrii Frunt
 */
public class TitleBasics implements IMDbModel {
    private Long titleId;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private boolean adult;

    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;

    private List<String> genres = new ArrayList<>();

    public Long getTitleId() {
        return titleId;
    }

    public TitleBasics setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public String getTitleType() {
        return titleType;
    }

    public TitleBasics setTitleType(String titleType) {
        this.titleType = titleType;
        return this;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public TitleBasics setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public TitleBasics setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public boolean isAdult() {
        return adult;
    }

    public TitleBasics setAdult(boolean adult) {
        this.adult = adult;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public TitleBasics setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public TitleBasics setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public TitleBasics setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
        return this;
    }

    public List<String> getGenres() {
        return genres;
    }

    public TitleBasics setGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    @Override
    public String toString() {
        return "TitleBasics{" +
                "titleId=" + titleId +
                ", titleType='" + titleType + '\'' +
                ", primaryTitle='" + primaryTitle + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", adult=" + adult +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", runtimeMinutes=" + runtimeMinutes +
                ", genres=" + genres +
                '}';
    }
}
