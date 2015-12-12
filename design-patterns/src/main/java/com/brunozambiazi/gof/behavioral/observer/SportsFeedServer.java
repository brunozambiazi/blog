package com.brunozambiazi.gof.behavioral.observer;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Concrete Subject implementation
 */
public class SportsFeedServer implements RssFeedServer {

    private final Collection<RssFeedReader> readers = new LinkedHashSet<>();

    @Override
    public void addReader(RssFeedReader reader) {
        readers.add(reader);
    }

    @Override
    public void removeReader(RssFeedReader reader) {
        readers.remove(reader);
    }

    @Override
    public int publish(String feed) {
        int destinations = 0;

        for (RssFeedReader reader : readers) {
            reader.receive(feed);
            destinations += 1;
        }

        return destinations;
    }
}
