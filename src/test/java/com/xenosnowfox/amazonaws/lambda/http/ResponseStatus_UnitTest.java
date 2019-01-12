package com.xenosnowfox.amazonaws.lambda.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Suite of unit tests to ensure the HTTP status codes match the <a href="https://tools.ietf.org/html/rfc7231">RFC 7231</a> standards
 */
public class ResponseStatus_UnitTest {

    @Test
    void test_OK() {
        assertEquals(200, ResponseStatus.OK.getCode());
    }

    @Test
    void test_CREATED() {
        assertEquals(201, ResponseStatus.CREATED.getCode());
    }

    @Test
    void test_ACCEPTED() {
        assertEquals(202, ResponseStatus.ACCEPTED.getCode());
    }

    @Test
    void test_NO_CONTENT() {
        assertEquals(204, ResponseStatus.NO_CONTENT.getCode());
    }

    @Test
    void test_RESET_CONTENT() {
        assertEquals(205, ResponseStatus.RESET_CONTENT.getCode());
    }

    @Test
    void test_PARTIAL_CONTENT() {
        assertEquals(206, ResponseStatus.PARTIAL_CONTENT.getCode());
    }

    @Test
    void test_MULTI_STATUS() {
        assertEquals(207, ResponseStatus.MULTI_STATUS.getCode());
    }

    @Test
    void test_ALREADY_REPORTED() {
        assertEquals(208, ResponseStatus.ALREADY_REPORTED.getCode());
    }

    @Test
    void test_IM_USED() {
        assertEquals(226, ResponseStatus.IM_USED.getCode());
    }

    @Test
    void test_MULTIPLE_CHOICES() {
        assertEquals(300, ResponseStatus.MULTIPLE_CHOICES.getCode());
    }

    @Test
    void test_MOVED_PERMANENTLY() {
        assertEquals(301, ResponseStatus.MOVED_PERMANENTLY.getCode());
    }

    @Test
    void test_FOUND() {
        assertEquals(302, ResponseStatus.FOUND.getCode());
    }

    @Test
    void test_SEE_OTHER() {
        assertEquals(303, ResponseStatus.SEE_OTHER.getCode());
    }

    @Test
    void test_NOT_MODIFIED() {
        assertEquals(304, ResponseStatus.NOT_MODIFIED.getCode());
    }

    @Test
    void test_USE_PROXY() {
        assertEquals(305, ResponseStatus.USE_PROXY.getCode());
    }

    @Test
    void test_TEMPORARY_REDIRECT() {
        assertEquals(307, ResponseStatus.TEMPORARY_REDIRECT.getCode());
    }

    @Test
    void test_BAD_REQUEST() {
        assertEquals(400, ResponseStatus.BAD_REQUEST.getCode());
    }

    @Test
    void test_UNAUTHORIZED() {
        assertEquals(401, ResponseStatus.UNAUTHORIZED.getCode());
    }

    @Test
    void test_PAYMENT_REQUIRED() {
        assertEquals(402, ResponseStatus.PAYMENT_REQUIRED.getCode());
    }

    @Test
    void test_FORBIDDEN() {
        assertEquals(403, ResponseStatus.FORBIDDEN.getCode());
    }

    @Test
    void test_NOT_FOUND() {
        assertEquals(404, ResponseStatus.NOT_FOUND.getCode());
    }

    @Test
    void test_METHOD_NOT_ALLOWED() {
        assertEquals(405, ResponseStatus.METHOD_NOT_ALLOWED.getCode());
    }

    @Test
    void test_NOT_ACCEPTABLE() {
        assertEquals(406, ResponseStatus.NOT_ACCEPTABLE.getCode());
    }

    @Test
    void test_PROXY_AUTHENTICATION_REQUIRED() {
        assertEquals(407, ResponseStatus.PROXY_AUTHENTICATION_REQUIRED.getCode());
    }

    @Test
    void test_REQUEST_TIMEOUT() {
        assertEquals(408, ResponseStatus.REQUEST_TIMEOUT.getCode());
    }

    @Test
    void test_CONFLICT() {
        assertEquals(409, ResponseStatus.CONFLICT.getCode());
    }

    @Test
    void test_GONE() {
        assertEquals(410, ResponseStatus.GONE.getCode());
    }

    @Test
    void test_LENGTH_REQUIRED() {
        assertEquals(411, ResponseStatus.LENGTH_REQUIRED.getCode());
    }

    @Test
    void test_PRECONDITION_FAILED() {
        assertEquals(412, ResponseStatus.PRECONDITION_FAILED.getCode());
    }

    @Test
    void test_REQUEST_ENTITY_TOO_LARGE() {
        assertEquals(413, ResponseStatus.REQUEST_ENTITY_TOO_LARGE.getCode());
    }

    @Test
    void test_REQUEST_URI_TOO_LONG() {
        assertEquals(414, ResponseStatus.REQUEST_URI_TOO_LONG.getCode());
    }

    @Test
    void test_UNSUPPORTED_MEDIA_TYPE() {
        assertEquals(415, ResponseStatus.UNSUPPORTED_MEDIA_TYPE.getCode());
    }

    @Test
    void test_REQUESTED_RANGE_NOT_SATISFIABLE() {
        assertEquals(416, ResponseStatus.REQUESTED_RANGE_NOT_SATISFIABLE.getCode());
    }

    @Test
    void test_EXPECTATION_FAILED() {
        assertEquals(417, ResponseStatus.EXPECTATION_FAILED.getCode());
    }

    @Test
    void test_IM_A_TEAPOT() {
        assertEquals(418, ResponseStatus.IM_A_TEAPOT.getCode());
    }

    @Test
    void test_ENHANCE_YOUR_CALM() {
        assertEquals(420, ResponseStatus.ENHANCE_YOUR_CALM.getCode());
    }

    @Test
    void test_UNPROCESSABLE_ENTITY() {
        assertEquals(422, ResponseStatus.UNPROCESSABLE_ENTITY.getCode());
    }

    @Test
    void test_LOCKED() {
        assertEquals(423, ResponseStatus.LOCKED.getCode());
    }

    @Test
    void test_FAILED_DEPENDENCY() {
        assertEquals(424, ResponseStatus.FAILED_DEPENDENCY.getCode());
    }

    @Test
    void test_UPGRADE_REQUIRED() {
        assertEquals(426, ResponseStatus.UPGRADE_REQUIRED.getCode());
    }

    @Test
    void test_PRECONDITION_REQUIRED() {
        assertEquals(428, ResponseStatus.PRECONDITION_REQUIRED.getCode());
    }

    @Test
    void test_TOO_MANY_REQUESTS() {
        assertEquals(429, ResponseStatus.TOO_MANY_REQUESTS.getCode());
    }

    @Test
    void test_REQUEST_HEADER_FIELDS_TOO_LARGE() {
        assertEquals(431, ResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.getCode());
    }

    @Test
    void test_UNAVAILABLE_FOR_LEGAL_REASONS() {
        assertEquals(451, ResponseStatus.UNAVAILABLE_FOR_LEGAL_REASONS.getCode());
    }

    @Test
    void test_INTERNAL_SERVER_ERROR() {
        assertEquals(500, ResponseStatus.INTERNAL_SERVER_ERROR.getCode());
    }

    @Test
    void test_NOT_IMPLEMENTED() {
        assertEquals(501, ResponseStatus.NOT_IMPLEMENTED.getCode());
    }

    @Test
    void test_BAD_GATEWAY() {
        assertEquals(502, ResponseStatus.BAD_GATEWAY.getCode());
    }

    @Test
    void test_SERVICE_UNAVAILABLE() {
        assertEquals(503, ResponseStatus.SERVICE_UNAVAILABLE.getCode());
    }

    @Test
    void test_GATEWAY_TIMEOUT() {
        assertEquals(504, ResponseStatus.GATEWAY_TIMEOUT.getCode());
    }

    @Test
    void test_HTTP_VERSION_NOT_SUPPORTED() {
        assertEquals(505, ResponseStatus.HTTP_VERSION_NOT_SUPPORTED.getCode());
    }

    @Test
    void test_INSUFFICIENT_STORAGE() {
        assertEquals(507, ResponseStatus.INSUFFICIENT_STORAGE.getCode());
    }

    @Test
    void test_LOOP_DETECTED() {
        assertEquals(508, ResponseStatus.LOOP_DETECTED.getCode());
    }

    @Test
    void test_NOT_EXTENDED() {
        assertEquals(510, ResponseStatus.NOT_EXTENDED.getCode());
    }

    @Test
    void test_NETWORK_READ_TIMEOUT_ERROR() {
        assertEquals(598, ResponseStatus.NETWORK_READ_TIMEOUT_ERROR.getCode());
    }

    @Test
    void test_NETWORK_CONNECT_TIMEOUT_ERROR() {
        assertEquals(599, ResponseStatus.NETWORK_CONNECT_TIMEOUT_ERROR.getCode());
    }
}