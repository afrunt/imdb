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
