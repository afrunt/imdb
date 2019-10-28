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
