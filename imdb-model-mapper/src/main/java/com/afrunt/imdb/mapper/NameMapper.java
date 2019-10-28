package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.Name;

import java.util.Arrays;
import java.util.stream.Collectors;

class NameMapper extends ModelMapper<Name> {
    @Override
    public Name map(String[] strings) {
        Name nm = new Name()
                .setNameId(stringToId(strings[0], "nm"))
                .setPrimaryName(strings[1].trim())
                .setBirthYear(stringToInteger(strings[2]))
                .setDeathYear(stringToInteger(strings[3]));

        if (strings.length > 4 && strings[4] != null) {
            nm.setPrimaryProfessions(Arrays.stream(strings[4].split(",")).map(String::trim).collect(Collectors.toList()));
        }

        if (strings.length > 5 && strings[5] != null && !strings[5].trim().equals("\\N")) {
            nm.setKnownForTitles(stringToIds(strings[5], "tt"));
        }

        return nm;
    }
}
