package com.brunozambiazi.gof.behavioral.observer;

import java.util.List;

/**
 * Observer interface
 */
public interface RssFeedReader {

    List<String> getMessages();

    void receive(String feed);
}
