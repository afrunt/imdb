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
