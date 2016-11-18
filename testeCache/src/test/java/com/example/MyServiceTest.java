package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ricardo on 31/10/16.
 */
public class MyServiceTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void execSlowMethod() throws Exception {
        MyService m = new MyService();
        boolean r = m.execSlowMethod();
        Assert.assertTrue(r);
    }

}