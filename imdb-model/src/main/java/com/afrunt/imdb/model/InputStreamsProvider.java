/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
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
    public static final String URL_NAME_BASICS = "https://datasets.imdbws.com/name.basics.tsv.gz";
    public static final String URL_TITLE_AKAS = "https://datasets.imdbws.com/title.akas.tsv.gz";
    public static final String URL_TITLE_BASICS = "https://datasets.imdbws.com/title.basics.tsv.gz";
    public static final String URL_TITLE_CREW = "https://datasets.imdbws.com/title.crew.tsv.gz";
    public static final String URL_TITLE_EPISODE = "https://datasets.imdbws.com/title.episode.tsv.gz";
    public static final String URL_TITLE_PRINCIPALS = "https://datasets.imdbws.com/title.principals.tsv.gz";
    public static final String URL_TITLE_RATINGS = "https://datasets.imdbws.com/title.ratings.tsv.gz";

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
        return gzipStreamFromUrl(URL_NAME_BASICS);
    }

    public InputStream titleAkasInputStream() {
        return gzipStreamFromUrl(URL_TITLE_AKAS);
    }

    public InputStream titleBasicInputStream() {
        return gzipStreamFromUrl(URL_TITLE_BASICS);
    }

    public InputStream titleCrewInputStream() {
        return gzipStreamFromUrl(URL_TITLE_CREW);
    }

    public InputStream titleEpisodeInputStream() {
        return gzipStreamFromUrl(URL_TITLE_EPISODE);
    }

    public InputStream titlePrincipalsInputStream() {
        return gzipStreamFromUrl(URL_TITLE_PRINCIPALS);
    }

    public InputStream titleRatingsInputStream() {
        return gzipStreamFromUrl(URL_TITLE_RATINGS);
    }

    private InputStream gzipStreamFromUrl(String url) {
        try {
            return new GZIPInputStream(new URL(url).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
