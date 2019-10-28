package com.afrunt.imdb.mapper;

import com.afrunt.imdb.model.TitlePrincipals;

import java.util.ArrayList;
import java.util.List;

class TitlePrincipalsMapper extends ModelMapper<TitlePrincipals> {
    @Override
    public TitlePrincipals map(String[] strings) {
        return new TitlePrincipals()
                .setTitleId(stringToId(strings[0], "tt"))
                .setOrdering(stringToInteger(strings[1]))
                .setNameId(stringToId(strings[2], "nm"))
                .setCategory(whenAvailable(strings[3]).orElse(null))
                .setJob(whenAvailable(strings[4]).orElse(null))
                .setCharacters(parseCharacters(strings[5]));
    }

    private List<String> parseCharacters(String source) {

        if (!whenAvailable(source).isPresent()) {
            return new ArrayList<>();
        }

        List<String> characters = new ArrayList<>();

        String src = source.trim().substring(1, source.length() - 1).replace("\\s", " ");

        boolean stringOpened = false;
        int prevChar = -1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c == '"' && prevChar != '\\' && !stringOpened) {
                stringOpened = true;
            } else if (c == '"' && prevChar != '\\') {
                stringOpened = false;
                characters.add(sb.toString().replace("  ", " "));
                sb = new StringBuilder();
            }

            if (c == '"' && prevChar == '\\' && stringOpened) {
                sb.append(c);
            } else if (prevChar == '\\' && (c == ' ' || Character.isAlphabetic(c)) && stringOpened) {
                sb.append(" / ").append(c);
            } else if (prevChar == '\\' && stringOpened) {
                sb.append(" ").append(c);
            } else if (stringOpened && c != '\\' && c != '"') {
                sb.append(c);
            }


            prevChar = c;
        }

        return characters;
    }
}
