package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleAkas;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class TitleAkasMapper extends ModelMapper<TitleAkas> {
    @Override
    public TitleAkas map(String[] strings) {
        return new TitleAkas()
                .setTitleId(stringToId(strings[0], "tt"))
                .setOrdering(stringToInteger(strings[1]))
                .setTitle(strings[2].trim())
                .setRegion(whenAvailableString(strings[3]))
                .setLanguage(whenAvailableString(strings[4]))
                .setTypes(
                        whenAvailable(strings[5])
                                .map(s -> Arrays.stream(s.split(",")).map(String::trim).collect(Collectors.toList()))
                                .orElse(Collections.emptyList())
                )
                .setAttributes(whenAvailableString(strings[6]))
                .setOriginalTitle(whenAvailable(strings[7]).map(s -> !"0".equals(s)).orElse(false))
                ;
    }
}
