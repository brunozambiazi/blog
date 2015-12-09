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
