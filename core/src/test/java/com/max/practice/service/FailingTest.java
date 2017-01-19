package com.max.practice.service;

import org.junit.Assert;
import org.junit.Test;

public class FailingTest {

    @Test
    public void shouldFail() throws Exception {
        Assert.fail();

    }
}
