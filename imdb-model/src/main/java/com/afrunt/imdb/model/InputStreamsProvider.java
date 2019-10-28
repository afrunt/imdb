package com.afrunt.imdb.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.zip.GZIPInputStream;

import static java.util.Map.entry;

public class InputStreamsProvider {

    public Supplier<InputStream> inputStreamSupplierFor(Class<? extends IMDbModel> type) {
        Map<Class, Supplier<InputStream>> suppliersMap = Map.ofEntries(
                entry(Name.class, this::namesInputStream),
                entry(TitleBasics.class, this::titleBasicInputStream),
                entry(TitleAkas.class, this::titleAkasInputStream),
                entry(TitlePrincipals.class, this::titlePrincipalsInputStream),
                entry(TitleCrew.class, this::titleCrewInputStream),
                entry(TitleEpisode.class, this::titleEpisodeInputStream),
                entry(TitleRatings.class, this::titleRatingsInputStream)
        );
        return Optional.ofNullable(suppliersMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("InputStream supplier not found for type " + type.getSimpleName()));
    }

    public InputStream namesInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/name.basics.tsv.gz");
    }

    public InputStream titleAkasInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.akas.tsv.gz");
    }

    public InputStream titleBasicInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.basics.tsv.gz");
    }

    public InputStream titleCrewInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.crew.tsv.gz");
    }

    public InputStream titleEpisodeInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.episode.tsv.gz");
    }

    public InputStream titlePrincipalsInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.principals.tsv.gz");
    }

    public InputStream titleRatingsInputStream() {
        return gzipStreamFromUrl("https://datasets.imdbws.com/title.ratings.tsv.gz");
    }

    private InputStream gzipStreamFromUrl(String url) {
        try {
            return new GZIPInputStream(new URL(url).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
