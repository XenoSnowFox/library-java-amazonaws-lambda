package com.xenosnowfox.amazonaws.lambda.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Suite of unit tests to ensure the HTTP methods match the <a href="https://tools.ietf.org/html/rfc7231">RFC 7231</a> standards
 */
public class RequestMethod_UnitTest {

    @Test
    void test_GET() {
        assertEquals("GET", RequestMethod.GET.toString());
    }

    @Test
    void test_POST() {
        assertEquals("POST", RequestMethod.POST.toString());
    }

    @Test
    void test_PATCH() {
        assertEquals("PATCH", RequestMethod.PATCH.toString());
    }

    @Test
    void test_PUT() {
        assertEquals("PUT", RequestMethod.PUT.toString());
    }

    @Test
    void test_DELETE() {
        assertEquals("DELETE", RequestMethod.DELETE.toString());
    }

    @Test
    void test_HEAD() {
        assertEquals("HEAD", RequestMethod.HEAD.toString());
    }

    @Test
    void test_OPTIONS() {
        assertEquals("OPTIONS", RequestMethod.OPTIONS.toString());
    }
}
