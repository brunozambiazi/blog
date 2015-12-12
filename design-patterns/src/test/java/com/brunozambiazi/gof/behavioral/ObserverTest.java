package com.brunozambiazi.gof.behavioral;

import com.brunozambiazi.gof.behavioral.observer.AndroidFeedReader;
import com.brunozambiazi.gof.behavioral.observer.IosFeedReader;
import com.brunozambiazi.gof.behavioral.observer.RssFeedReader;
import com.brunozambiazi.gof.behavioral.observer.RssFeedServer;
import com.brunozambiazi.gof.behavioral.observer.SportsFeedServer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Define a one-to-many dependency between objects so that when one object
 * changes state, all its dependents are notified and updated automatically.
 *
 * @link https://dzone.com/articles/design-patterns-uncovered
 */
public class ObserverTest {

    private RssFeedServer server;
    private RssFeedReader androidReader;
    private RssFeedReader iosReader;

    @Before
    public void init() {
        server = new SportsFeedServer();
        androidReader = new AndroidFeedReader();
        iosReader = new IosFeedReader();
    }

    @Test
    public void publishWithNoReaders() {
        int delivery = server.publish("first message");
        assertEquals("There are no readers yet", 0, delivery);
    }

    @Test
    public void publishWithOneReader() {
        server.addReader(androidReader);
        int delivery = server.publish("first message");
        assertEquals("There is just one reader", 1, delivery);

        server.removeReader(androidReader);
        server.addReader(iosReader);
        delivery = server.publish("second message");
        assertEquals("There is just one reader", 1, delivery);

        assertEquals("Both readers must have the same number of messages", androidReader.getMessages().size(),
                iosReader.getMessages().size());
        assertEquals("Both readers must have just one message", 1, androidReader.getMessages().size());

        String androidMessage = androidReader.getMessages().iterator().next();
        String iosMessage = iosReader.getMessages().iterator().next();
        assertNotEquals("Messages must be different", androidMessage, iosMessage);
    }

    @Test
    public void publishWithManyReader() {
        server.addReader(androidReader);
        server.addReader(iosReader);

        int delivery = server.publish("first message");
        assertEquals("There are two readers", 2, delivery);

        delivery = server.publish("second message");
        assertEquals("There are two readers", 2, delivery);

        assertEquals("Both readers must have the same number of messages", androidReader.getMessages().size(),
                iosReader.getMessages().size());
        assertEquals("Both readers must have two messages", 2, iosReader.getMessages().size());

        for (String androidMessage : androidReader.getMessages()) {
            assertTrue("IOS reader must contain all Android reader messages",
                    iosReader.getMessages().contains(androidMessage));
        }

        for (String iosMessage : iosReader.getMessages()) {
            assertTrue("Android reader must contain all IOS reader messages",
                    androidReader.getMessages().contains(iosMessage));
        }
    }
}
