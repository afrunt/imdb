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

import java.math.BigDecimal;

/**
 * @author Andrii Frunt
 */
public class TitleRatings implements IMDbModel {
    private Long titleId;
    private BigDecimal averageRating;
    private Integer numVotes;

    public Long getTitleId() {
        return titleId;
    }

    public TitleRatings setTitleId(Long titleId) {
        this.titleId = titleId;
        return this;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public TitleRatings setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public Integer getNumVotes() {
        return numVotes;
    }

    public TitleRatings setNumVotes(Integer numVotes) {
        this.numVotes = numVotes;
        return this;
    }

    @Override
    public String toString() {
        return "TitleRatings{" +
                "titleId=" + titleId +
                ", averageRating=" + averageRating +
                ", numVotes=" + numVotes +
                '}';
    }
}
