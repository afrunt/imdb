package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleEpisode;

class TitleEpisodeMapper extends ModelMapper<TitleEpisode> {
    @Override
    public TitleEpisode map(String[] strings) {
        return new TitleEpisode()
                .setTitleId(stringToId(strings[0], "tt"))
                .setParentTitleId(stringToId(strings[1], "tt"))
                .setSeasonNumber(stringToInteger(strings[2]))
                .setEpisodeNumber(stringToInteger(strings[3]));
    }
}
