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

/**
 * @author Andrii Frunt
 */
public class TitleEpisode implements IMDbModel {
    private Long titleId;
    private Long parentTitleId;
    private Integer seasonNumber;
    private Integer episodeNumber;

    public Long getTitleId() {
        return titleId;
    }

    public TitleEpisode setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public Long getParentTitleId() {
        return parentTitleId;
    }

    public TitleEpisode setParentTitleId(Long parentTitleId) {
        this.parentTitleId = parentTitleId;
        return this;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public TitleEpisode setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
        return this;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public TitleEpisode setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
        return this;
    }

    @Override
    public String toString() {
        return "TitleEpisode{" +
                "titleId=" + titleId +
                ", parentTitleId=" + parentTitleId +
                ", seasonNumber=" + seasonNumber +
                ", episodeNumber=" + episodeNumber +
                '}';
    }
}
