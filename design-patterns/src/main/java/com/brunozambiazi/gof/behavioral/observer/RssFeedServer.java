package com.brunozambiazi.gof.behavioral.observer;

/**
 * Subject interface
 */
public interface RssFeedServer {

    void addReader(RssFeedReader reader);

    void removeReader(RssFeedReader reader);

    int publish(String feed);
}
