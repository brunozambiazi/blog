package com.brunozambiazi.gof.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Concrete Observer implementation
 */
public class AndroidFeedReader implements RssFeedReader {

    private final List<String> messages = new LinkedList<>();

    @Override
    public List<String> getMessages() {
        return messages;
    }

    @Override
    public void receive(String feed) {
        messages.add(feed);
    }
}
