package com.max.practice.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FailingTest {

    @Test
    public void shouldFail() throws Exception {
        Assert.assertEquals("1", "1");

    }

    @Ignore
    @Test
    public void testIgnore() throws Exception {


    }
}
