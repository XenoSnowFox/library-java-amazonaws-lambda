package com.xenosnowfox.amazonaws.lambda.http;

import java.util.HashSet;
import java.util.Set;

/**
 * Enumeration of possible Http Status response codes
 */
public enum ResponseStatus {

    // 2xx SUCCESS
    OK(200, "Ok")
    , CREATED(201, "Created")
    , ACCEPTED(202, "Accepted")
    , NO_CONTENT(204, "No Content")
    , RESET_CONTENT(205, "Reset Content")
    , PARTIAL_CONTENT(206,"Partial Content")
    , MULTI_STATUS(207, "Multi-Status")
    , ALREADY_REPORTED(208, "Already Reported")
    , IM_USED(226, "IM Used")

    // 3xx REDIRECTION
    , MULTIPLE_CHOICES(300, "Multiple Choices")
    , MOVED_PERMANENTLY(301, "Moved Permanently")
    , FOUND(302, "Found")
    , SEE_OTHER(303, "See Other")
    , NOT_MODIFIED(304, "Not Modified")
    , USE_PROXY(305, "Use Proxy")
    , TEMPORARY_REDIRECT(307, "Temporary Redirect")

    // 4xx CLIENT ERROR
    , BAD_REQUEST(400, "Bad Request")
    , UNAUTHORIZED(401, "Unauthorized")
    , PAYMENT_REQUIRED(402, "Payment Required")
    , FORBIDDEN(403, "Forbidden")
    , NOT_FOUND(404, "Not Found")
    , METHOD_NOT_ALLOWED(405, "Method Not Allowed")
    , NOT_ACCEPTABLE(406, "Not Acceptable")
    , PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required")
    , REQUEST_TIMEOUT(408, "Request Timeout")
    , CONFLICT(409, "Conflict")
    , GONE(410, "Gone")
    , LENGTH_REQUIRED(411, "Length Required")
    , PRECONDITION_FAILED(412, "Precondition Failed")
    , REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large")
    , REQUEST_URI_TOO_LONG(414, "Request-URI Too Long")
    , UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type")
    , REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable")
    , EXPECTATION_FAILED(417, "Expectation Failed")
    , IM_A_TEAPOT(418, "I'm a Teapot")
    , ENHANCE_YOUR_CALM(420, "Enhance Your Calm")
    , UNPROCESSABLE_ENTITY(422, "Unprocessable Entity")
    , LOCKED(423, "Locked")
    , FAILED_DEPENDENCY(424, "Failed Dependency")
    , UPGRADE_REQUIRED(426, "Upgrade Required")
    , PRECONDITION_REQUIRED(428, "Precondition Required")
    , TOO_MANY_REQUESTS(429, "Too Many Requests")
    , REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Field Too Large")
    , UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons")

    // 5xx SERVER ERROR
    , INTERNAL_SERVER_ERROR(500, "Internal Server Error")
    , NOT_IMPLEMENTED(501, "Not Implemented")
    , BAD_GATEWAY(502, "Bad Gateway")
    , SERVICE_UNAVAILABLE(503, "Service Unavailable")
    , GATEWAY_TIMEOUT(504, "Gateway Timeout")
    , HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported")
    , INSUFFICIENT_STORAGE(507, "Insufficient Storage")
    , LOOP_DETECTED(508, "Loop Detected")
    , NOT_EXTENDED(510, "Not Extended")
    , NETWORK_READ_TIMEOUT_ERROR(598, "Network Read Timeout Error")
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

    private final int code;
    private final String description;

    /**
     * Construct a new HttpStatus
     *
     * @param code
     *      HTTP Status code
     * @param description
     *      Short description/label of the status code
     */
    ResponseStatus(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Attempts to obtain a HTTPStatus from the given code value.
     *
     * @param code
     *      HTTP Status code
     * @return
     *      HTTP Status
     */
    public static ResponseStatus valueOf(int code) {
        for (ResponseStatus responseStatus : values()) {
            if (responseStatus.getCode() == code) {
                return responseStatus;
            }
        }

        return null;
    }

    /**
     * Obtains the numeric code of the HTTP Status
     *
     * @return
     *      HTTP Status code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Obtains the short description/label of the HTTP Status code
     *
     * @return
     *      Short description/label of the status code
     */
    public String getDescription() {
        return this.description;
    }
}
