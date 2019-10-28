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
