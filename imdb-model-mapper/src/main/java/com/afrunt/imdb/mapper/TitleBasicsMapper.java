package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleBasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class TitleBasicsMapper extends ModelMapper<TitleBasics> {

    @Override
    public TitleBasics map(String[] strings) {
        return new TitleBasics()
                .setTitleId(stringToId(strings[0], "tt"))
                .setTitleType(strings[1].trim())
                .setPrimaryTitle(strings[2])
                .setOriginalTitle(strings[3])
                .setAdult(!"0".equals(strings[4].trim()))
                .setStartYear(stringToInteger(strings[5]))
                .setEndYear(stringToInteger(strings[6]))
                .setRuntimeMinutes(stringToInteger(strings[7]))
                .setGenres(whenAvailable(strings[8]).map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).orElse(Collections.emptyList()));
    }
}
