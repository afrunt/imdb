package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitleCrew;

class TitleCrewMapper extends ModelMapper<TitleCrew> {
    @Override
    public TitleCrew map(String[] strings) {
        return new TitleCrew()
                .setTitleId(stringToId(strings[0], "tt"))
                .setDirectors(stringToIds(strings[1], "nm"))
                .setWriters(stringToIds(strings[2], "nm"));
    }
}
