package com.afrunt.imdb.iterator;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class IMDBbTsvIterator implements Iterator<String[]>, Iterable<String[]>, Closeable {
    private Supplier<InputStream> inputStreamSupplier;
    private String[] next = null;
    private TsvParser tsvParser = null;
    private boolean finished = false;

    public IMDBbTsvIterator(Supplier<InputStream> inputStreamSupplier) {
        this.inputStreamSupplier = inputStreamSupplier;
    }

    @Override
    public boolean hasNext() {
        if (finished) {
            return false;
        } else {
            checkInitialization();
            next = tsvParser.parseNext();
            if (next == null) {
                finished = true;
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public String[] next() {
        if (finished) {
            throw new NoSuchElementException();
        }

        checkInitialization();

        if (next != null) {
            String[] toReturn = next;
            next = null;
            return toReturn;
        } else {
            String[] strings = tsvParser.parseNext();
            if (strings == null) {
                finished = true;
                throw new NoSuchElementException();
            } else {
                return strings;
            }
        }
    }

    private void checkInitialization() {
        if (tsvParser == null) {
            tsvParser = new TsvParser(tsvParserSettings());
            tsvParser.beginParsing(inputStreamSupplier.get(), "UTF-8");
        }
    }

    private TsvParserSettings tsvParserSettings() {
        TsvParserSettings settings = new TsvParserSettings();
        settings.setMaxCharsPerColumn(4096 * 100);
        return settings;
    }

    @Override
    public void close() {
        if (tsvParser != null) {
            tsvParser.stopParsing();
        }
    }

    @Override
    public Iterator<String[]> iterator() {
        return this;
    }
}
