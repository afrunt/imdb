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
