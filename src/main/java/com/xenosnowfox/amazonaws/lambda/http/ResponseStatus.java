package com.xenosnowfox.amazonaws.lambda.http;

import java.util.HashSet;
import java.util.Set;

/**
 * Enumeration of possible Http Status response codes.
 *
 * @since
 *      1.0.0
 */
public enum ResponseStatus {

    /**
     * 200 - OK Response.
     */
    OK(200, "Ok")

    /**
     * 201 - Created Response.
     */
    , CREATED(201, "Created")

    /**
     * 202 - Accepted Response.
     */
    , ACCEPTED(202, "Accepted")

    /**
     * 204 - No Content Response.
     */
    , NO_CONTENT(204, "No Content")

    /**
     * 205 - Reset Content Response.
     */
    , RESET_CONTENT(205, "Reset Content")

    /**
     * 206 - Partial Content Response.
     */
    , PARTIAL_CONTENT(206, "Partial Content")

    /**
     * 207 - Multi-Status Response.
     */
    , MULTI_STATUS(207, "Multi-Status")

    /**
     * 208 - Already Reported Response.
     */
    , ALREADY_REPORTED(208, "Already Reported")

    /**
     * 226 - IM Used Response.
     */
    , IM_USED(226, "IM Used")

    /**
     * 300 - Multiple Choices Response.
     */
    , MULTIPLE_CHOICES(300, "Multiple Choices")

    /**
     * 301 - Moved Permanently Response.
     */
    , MOVED_PERMANENTLY(301, "Moved Permanently")

    /**
     * 302 - Found Response.
     */
    , FOUND(302, "Found")

    /**
     * 303 - See Other Response.
     */
    , SEE_OTHER(303, "See Other")

    /**
     * 304 - Not Modified Response.
     */
    , NOT_MODIFIED(304, "Not Modified")

    /**
     * 305 - Use Proxy Response.
     */
    , USE_PROXY(305, "Use Proxy")

    /**
     * 307 - Temporary Redirect Response.
     */
    , TEMPORARY_REDIRECT(307, "Temporary Redirect")

    /**
     * 400 - Bad Request Response.
     */
    , BAD_REQUEST(400, "Bad Request")

    /**
     * 401 - Unauthorized Response.
     */
    , UNAUTHORIZED(401, "Unauthorized")

    /**
     * 402 - Payment Required Response.
     */
    , PAYMENT_REQUIRED(402, "Payment Required")

    /**
     * 403 - Forbidden Response.
     */
    , FORBIDDEN(403, "Forbidden")

    /**
     * 404 - Not Found Response.
     */
    , NOT_FOUND(404, "Not Found")

    /**
     * 405 - Method Not Allowed Response.
     */
    , METHOD_NOT_ALLOWED(405, "Method Not Allowed")

    /**
     * 406 - Not Acceptable Response.
     */
    , NOT_ACCEPTABLE(406, "Not Acceptable")

    /**
     * 407 - Proxy Authentication Required Response.
     */
    , PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required")

    /**
     * 408 - Request Timeout Response.
     */
    , REQUEST_TIMEOUT(408, "Request Timeout")

    /**
     * 409 - Conflict Response.
     */
    , CONFLICT(409, "Conflict")

    /**
     * 410 - Gone Response.
     */
    , GONE(410, "Gone")

    /**
     * 411 - Length Required Response.
     */
    , LENGTH_REQUIRED(411, "Length Required")

    /**
     * 412 - Precondition Failed Response.
     */
    , PRECONDITION_FAILED(412, "Precondition Failed")

    /**
     * 413 - Request Entity Too Large Response.
     */
    , REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large")

    /**
     * 414 - Request URI Too Long Response.
     */
    , REQUEST_URI_TOO_LONG(414, "Request-URI Too Long")

    /**
     * 415 - Unsupported Media Type Response.
     */
    , UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type")

    /**
     * 416 - Request Range Not Satisfiable Response.
     */
    , REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable")

    /**
     * 417 - Expectation Failed Response.
     */
    , EXPECTATION_FAILED(417, "Expectation Failed")

    /**
     * 418 - I'm A TeaPot Response.
     */
    , IM_A_TEAPOT(418, "I'm a Teapot")

    /**
     * 420 - Enhance Your Calm Response.
     */
    , ENHANCE_YOUR_CALM(420, "Enhance Your Calm")

    /**
     * 422 - Unprocessable Entity Response.
     */
    , UNPROCESSABLE_ENTITY(422, "Unprocessable Entity")

    /**
     * 423 - Locked Response.
     */
    , LOCKED(423, "Locked")

    /**
     * 424 - Failed Dependency Response.
     */
    , FAILED_DEPENDENCY(424, "Failed Dependency")

    /**
     * 426 - Upgrade Required Response.
     */
    , UPGRADE_REQUIRED(426, "Upgrade Required")

    /**
     * 428 - Precondition Required Response.
     */
    , PRECONDITION_REQUIRED(428, "Precondition Required")

    /**
     * 429 - Too Many Requests Response.
     */
    , TOO_MANY_REQUESTS(429, "Too Many Requests")

    /**
     * 431 - Request Header Field Too Large Response.
     */
    , REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Field Too Large")

    /**
     * 451 - Unavailable For Legal Reasons Response.
     */
    , UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons")

    /**
     * 500 - Internal Server Error Response.
     */
    , INTERNAL_SERVER_ERROR(500, "Internal Server Error")

    /**
     * 501 - Not Implemented Response.
     */
    , NOT_IMPLEMENTED(501, "Not Implemented")

    /**
     * 502 - Bad Gateway Response.
     */
    , BAD_GATEWAY(502, "Bad Gateway")

    /**
     * 503 - Service Unavailable Response.
     */
    , SERVICE_UNAVAILABLE(503, "Service Unavailable")

    /**
     * 504 - Gateway Timeout Response.
     */
    , GATEWAY_TIMEOUT(504, "Gateway Timeout")

    /**
     * 505 - HTTP Version Not Supported Response.
     */
    , HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported")

    /**
     * 507 - Insufficient Storage Response.
     */
    , INSUFFICIENT_STORAGE(507, "Insufficient Storage")

    /**
     * 508 - Loop Detected Response.
     */
    , LOOP_DETECTED(508, "Loop Detected")

    /**
     * 510 - Not Extended Response.
     */
    , NOT_EXTENDED(510, "Not Extended")

    /**
     * 598 - Network Read Timeout Error Response.
     */
    , NETWORK_READ_TIMEOUT_ERROR(598, "Network Read Timeout Error")

    /**
     * 599 - Network Connect Timeout Error Response.
     */
    , NETWORK_CONNECT_TIMEOUT_ERROR(599, "Network Connect Timeout Error")
    ;

    static {
        Set<Integer> vals = new HashSet<>();

        // check for duplicate status codes
        for (ResponseStatus responseStatus : values()) {
            if (!vals.add(responseStatus.getCode())) {
                throw new IllegalStateException("Status code `" + responseStatus.getCode() + "` has been defined multiple times.");
            }
        }
    }

    /**
     * The HTTP Status code.
     */
    private final int code;

    /**
     * Textual representation of the status code.
     */
    private final String description;

    /**
     * Construct a new HttpStatus.
     *
     * @param code
     *      HTTP Status code.
     * @param description
     *      Short description/label of the status code.
     */
    ResponseStatus(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Attempts to obtain a HTTPStatus from the given code value.
     *
     * @param code
     *      HTTP Status code.
     * @return
     *      HTTP Status.
     */
    public static ResponseStatus valueOf(final int code) {
        for (ResponseStatus responseStatus : values()) {
            if (responseStatus.getCode() == code) {
                return responseStatus;
            }
        }

        return null;
    }

    /**
     * Obtains the numeric code of the HTTP Status.
     *
     * @return
     *      HTTP Status code.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Obtains the short description/label of the HTTP Status code.
     *
     * @return
     *      Short description/label of the status code.
     */
    public String getDescription() {
        return this.description;
    }
}
