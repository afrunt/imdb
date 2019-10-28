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
