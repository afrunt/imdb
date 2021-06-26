package com.afrunt.imdb.reactiveclient.test;

import com.afrunt.imdb.model.*;
import com.afrunt.imdb.reactiveclient.IMDbClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IMDbClientTest {
    private IMDbClient client;

    @BeforeClass
    public void init() {
        client = new IMDbClient(new InputStreamsProvider() {
            @Override
            public InputStream namesInputStream() {
                return resourceInputStream("name.basics.tsv");
            }

            @Override
            public InputStream titleAkasInputStream() {
                return resourceInputStream("title.akas.tsv");
            }

            @Override
            public InputStream titleBasicInputStream() {
                return resourceInputStream("title.basics.tsv");
            }

            @Override
            public InputStream titleCrewInputStream() {
                return resourceInputStream("title.crew.tsv");
            }

            @Override
            public InputStream titleEpisodeInputStream() {
                return resourceInputStream("title.episode.tsv");
            }

            @Override
            public InputStream titlePrincipalsInputStream() {
                return resourceInputStream("title.principals.tsv");
            }

            @Override
            public InputStream titleRatingsInputStream() {
                return resourceInputStream("title.ratings.tsv");
            }

            private InputStream resourceInputStream(String path) {
                return getClass().getClassLoader().getResourceAsStream(path);
            }
        });
    }

    @Test
    public void testNameBasics() {
        List<Name> names = client.fluxOf(Name.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(names.size(), 3);

        Name name1 = names.get(0);
        Assert.assertEquals(name1.getPrimaryName(), "Fred Astaire");
        Assert.assertEquals(name1.getBirthYear(), Integer.valueOf(1899));
        Assert.assertEquals(name1.getDeathYear(), Integer.valueOf(1987));
        Assert.assertEquals(name1.getPrimaryProfessions(), Arrays.asList("soundtrack", "actor", "miscellaneous"));
        Assert.assertEquals(name1.getKnownForTitles(), Arrays.asList(53137L, 50419L, 43044L, 72308L));

        Name name2 = names.get(1);
        Assert.assertEquals(name2.getPrimaryName(), "Lauren Bacall");
        Assert.assertEquals(name2.getBirthYear(), Integer.valueOf(1924));
        Assert.assertEquals(name2.getDeathYear(), Integer.valueOf(2014));
        Assert.assertEquals(name2.getPrimaryProfessions(), Arrays.asList("actress", "soundtrack"));
        Assert.assertEquals(name2.getKnownForTitles(), Arrays.asList(117057L, 38355L, 37382L, 40506L));

        Name name3 = names.get(2);
        Assert.assertEquals(name3.getPrimaryName(), "Brigitte Bardot");
        Assert.assertEquals(name3.getBirthYear(), Integer.valueOf(1934));
        Assert.assertNull(name3.getDeathYear());
        Assert.assertEquals(name3.getPrimaryProfessions(), Arrays.asList("actress", "soundtrack", "producer"));
        Assert.assertEquals(name3.getKnownForTitles(), Arrays.asList(57345L, 63715L, 59956L, 49189L));
    }

    @Test
    public void testTitleAkas() {
        List<TitleAkas> akas = client
                .fluxOf(TitleAkas.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(akas.size(), 2);

        TitleAkas akas1 = akas.get(0);

        Assert.assertEquals(akas1.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(akas1.getOrdering(), Integer.valueOf(1));
        Assert.assertEquals(akas1.getTitle(), "Carmencita - spanyol tánc");
        Assert.assertEquals(akas1.getRegion(), "HU");
        Assert.assertNull(akas1.getLanguage());
        Assert.assertEquals(akas1.getTypes(), Collections.singletonList("imdbDisplay"));
        Assert.assertNull(akas1.getAttributes());
        Assert.assertFalse(akas1.isOriginalTitle());

        TitleAkas akas2 = akas.get(1);

        Assert.assertEquals(akas2.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(akas2.getOrdering(), Integer.valueOf(3));
        Assert.assertEquals(akas2.getTitle(), "Carmencita");
        Assert.assertEquals(akas2.getRegion(), "US");
        Assert.assertNull(akas2.getLanguage());
        Assert.assertEquals(akas2.getTypes(), Collections.emptyList());
        Assert.assertNull(akas2.getAttributes());
        Assert.assertFalse(akas2.isOriginalTitle());
    }

    @Test
    public void testTitleBasics() {
        List<TitleBasics> basics = client
                .fluxOf(TitleBasics.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(basics.size(), 2);

        TitleBasics basics1 = basics.get(0);

        Assert.assertEquals(basics1.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(basics1.getTitleType(), "short");
        Assert.assertEquals(basics1.getPrimaryTitle(), "Carmencita");
        Assert.assertEquals(basics1.getOriginalTitle(), "Carmencita");
        Assert.assertFalse(basics1.isAdult());
        Assert.assertEquals(basics1.getStartYear(), Integer.valueOf(1894));
        Assert.assertNull(basics1.getEndYear());
        Assert.assertEquals(basics1.getRuntimeMinutes(), Integer.valueOf(1));
        Assert.assertEquals(basics1.getGenres(), Arrays.asList("Documentary", "Short"));
    }

    @Test
    public void testTitleCrew() {
        List<TitleCrew> crews = client
                .fluxOf(TitleCrew.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(crews.size(), 2);

        TitleCrew crew1 = crews.get(0);

        Assert.assertEquals(crew1.getTitleId(), Long.valueOf(1));
        Assert.assertEquals(crew1.getDirectors(), Collections.singletonList(5690L));
        Assert.assertEquals(crew1.getWriters(), Collections.emptyList());

        TitleCrew crew2 = crews.get(1);

        Assert.assertEquals(crew2.getTitleId(), Long.valueOf(2));
        Assert.assertEquals(crew2.getDirectors(), Collections.singletonList(721526L));
        Assert.assertEquals(crew2.getWriters(), Collections.emptyList());
    }


    @Test
    public void testTitleEpisode() {
        List<TitleEpisode> episodes = client
                .fluxOf(TitleEpisode.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(episodes.size(), 2);

        TitleEpisode episode1 = episodes.get(0);
        Assert.assertEquals(episode1.getTitleId(), Long.valueOf(41951L));
        Assert.assertEquals(episode1.getParentTitleId(), Long.valueOf(41038L));
        Assert.assertEquals(episode1.getSeasonNumber(), Integer.valueOf(1));
        Assert.assertEquals(episode1.getEpisodeNumber(), Integer.valueOf(9));

        TitleEpisode episode2 = episodes.get(1);
        Assert.assertEquals(episode2.getTitleId(), Long.valueOf(42816L));
        Assert.assertEquals(episode2.getParentTitleId(), Long.valueOf(989125L));
        Assert.assertEquals(episode2.getSeasonNumber(), Integer.valueOf(1));
        Assert.assertEquals(episode2.getEpisodeNumber(), Integer.valueOf(17));
    }

    @Test
    public void testTitlePrincipals() {
        List<TitlePrincipals> principals = client
                .fluxOf(TitlePrincipals.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(principals.size(), 2);

        TitlePrincipals principals1 = principals.get(0);

        Assert.assertEquals(principals1.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(principals1.getOrdering(), Integer.valueOf(1));
        Assert.assertEquals(principals1.getNameId(), Long.valueOf(1588970L));
        Assert.assertEquals(principals1.getCategory(), "self");
        Assert.assertNull(principals1.getJob());

        Assert.assertEquals(principals1.getCharacters(), Collections.singletonList("Herself"));

        TitlePrincipals principals2 = principals.get(1);

        Assert.assertEquals(principals2.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(principals2.getOrdering(), Integer.valueOf(2));
        Assert.assertEquals(principals2.getNameId(), Long.valueOf(5690L));
        Assert.assertEquals(principals2.getCategory(), "director");
        Assert.assertNull(principals2.getJob());

        Assert.assertTrue(principals2.getCharacters().isEmpty());
    }

    @Test
    public void testTitleRatings() {
        List<TitleRatings> ratings = client
                .fluxOf(TitleRatings.class)
                .toStream()
                .collect(Collectors.toList());

        Assert.assertEquals(ratings.size(), 2);

        TitleRatings ratings1 = ratings.get(0);

        Assert.assertEquals(ratings1.getTitleId(), Long.valueOf(1L));
        Assert.assertEquals(ratings1.getAverageRating(), BigDecimal.valueOf(5.8));
        Assert.assertEquals(ratings1.getNumVotes(), Integer.valueOf(1350));

        TitleRatings ratings2 = ratings.get(1);

        Assert.assertEquals(ratings2.getTitleId(), Long.valueOf(2L));
        Assert.assertEquals(ratings2.getAverageRating(), BigDecimal.valueOf(6.5));
        Assert.assertEquals(ratings2.getNumVotes(), Integer.valueOf(157));
    }


}
