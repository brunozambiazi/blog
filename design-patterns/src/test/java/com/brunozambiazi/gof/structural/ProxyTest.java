package com.brunozambiazi.gof.structural;

import com.brunozambiazi.gof.structural.proxy.Product;
import com.brunozambiazi.gof.structural.proxy.ProductRepository;
import com.brunozambiazi.gof.structural.proxy.ProductRepositoryCache;
import com.brunozambiazi.gof.structural.proxy.ProductRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Allows for object level access control by acting as a pass through entity or
 * a placeholder object.
 *
 * As usual, when dealing with design patterns we code to interfaces. In this
 * case, the interface that the client knows about is the <b>Subject</b>. Both
 * the <b>Proxy</b> and <b>RealSubject</b> objects implement the <b>Subject</b>
 * interface, but the client may not be able to access the RealSubject without
 * going through the <b>Proxy</b>. It's quite common that the <b>Proxy</b> would
 * handle the creation of the <b>RealSubject</b> object, but it will at least
 * have a reference to it so that it can pass messages along.
 *
 * @link https://dzone.com/articles/design-patterns-proxy
 */
public class ProxyTest {

    @Test
    public void findWithoutCache() {
        ProductRepository repo = new ProductRepositoryImpl();

        Product firstFind = repo.findById(1L);
        Product secondFind = repo.findById(1L);
        assertEquals("Identifier must be the same", firstFind.getId(), secondFind.getId());
        assertNotEquals("Hash must be different", firstFind.getHash(), secondFind.getHash());
    }

    @Test
    public void findWithCache() {
        ProductRepository repo = new ProductRepositoryCache();

        Product firstFind = repo.findById(1L);
        Product secondFind = repo.findById(2L);
        assertNotEquals("Identifier must be different", firstFind.getId(), secondFind.getId());
        assertNotEquals("Hash must be different", firstFind.getHash(), secondFind.getHash());

        assertEquals("Hash must be the same", firstFind.getHash(), repo.findById(1L).getHash());
        assertEquals("Hash must be the same", secondFind.getHash(), repo.findById(2L).getHash());
    }
}
