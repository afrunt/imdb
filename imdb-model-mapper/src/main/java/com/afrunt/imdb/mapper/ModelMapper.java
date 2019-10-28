package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public abstract class ModelMapper<T extends IMDbModel> {
    @SuppressWarnings("unchecked")
    public static <T extends IMDbModel> ModelMapper<T> forType(Class<T> type) {
        Map<Class<? extends IMDbModel>, ModelMapper<?>> convertersMap = Map.ofEntries(
                entry(Name.class, new NameMapper()),
                entry(TitleBasics.class, new TitleBasicsMapper()),
                entry(TitleAkas.class, new TitleAkasMapper()),
                entry(TitleRatings.class, new TitleRatingsMapper()),
                entry(TitleCrew.class, new TitleCrewMapper()),
                entry(TitleEpisode.class, new TitleEpisodeMapper()),
                entry(TitlePrincipals.class, new TitlePrincipalsMapper())
        );

        return Optional.ofNullable(convertersMap.get(type))
                .map(c -> (ModelMapper<T>) c)
                .orElseThrow(() -> new IllegalArgumentException("Type converter not found for type " + type.getSimpleName()));
    }

    public abstract T map(String[] strings);

    Integer stringToInteger(String str) {
        return whenAvailable(str).map(Integer::valueOf).orElse(null);
    }

    String whenAvailableString(String string) {
        return whenAvailable(string).orElse(null);
    }

    Optional<String> whenAvailable(String string) {
        if (string == null) {
            return Optional.empty();
        }

        String trim = string.trim();
        if ("".equals(trim) || "\\N".equals(trim) || "N".equals(trim)) {
            return Optional.empty();
        }

        return Optional.of(trim);
    }

    Long stringToId(String string, String prefix) {
        return whenAvailable(string)
                .map(s -> s.replace(prefix, ""))
                .map(Long::valueOf)
                .orElse(null);
    }

    Set<Long> stringToIds(String string, String prefix) {
        return whenAvailable(string)
                .map(s -> Arrays
                        .stream(s.split(","))
                        .map(spl -> stringToId(spl, prefix))
                        .collect(Collectors.toSet())
                )
                .orElse(new HashSet<>());
    }
}