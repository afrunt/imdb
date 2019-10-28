package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleRatings;

import java.math.BigDecimal;

class TitleRatingsMapper extends ModelMapper<TitleRatings> {
    @Override
    public TitleRatings map(String[] strings) {
        return new TitleRatings()
                .setTitleId(stringToId(strings[0], "tt"))
                .setAverageRating(whenAvailable(strings[1]).map(BigDecimal::new).orElse(null))
                .setNumVotes(stringToInteger(strings[2]));
    }
}
