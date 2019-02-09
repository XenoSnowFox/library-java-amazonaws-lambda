package com.xenosnowfox.amazonaws.lambda;

import com.xenosnowfox.amazonaws.lambda.http.ResponseStatus;
import org.json.JSONObject;

import java.util.Map;
import java.util.List;

/**
 * Response object that has been designed to be returned from an AWS Lambda function.
 *
 * @since
 *      1.0.0
 * @param <T>
 *     The data type of the response content
 */
public interface Response<T> {

    /**
     * Sets whether the returning body content is Base 64 encoded or not.
     *
     * @since
     *      1.0.0
     * @param isBase64Encoded
     *      {@code true} if the body content is Base 64 encoded, {@code false} otherwise
     */
    void setBase64Encoded(final boolean isBase64Encoded);

    /**
     * Returns whether the body content has been marked as being Base 64 encoded.
     *
     * @since
     *      1.0.0
     * @return
     *      {@code true} if the body content is Base 64 encoded, {@code false} otherwise
     */
    boolean isBase64Encoded();

    /**
     * Sets the HTTP Status Code to be used with the response.
     *
     * @since
     *      1.0.0
     * @param responseStatus
     *      HTTP Status Code
     */
    void setResponseStatus(final ResponseStatus responseStatus);

    /**
     * Sets a header value, overriding any existing values for the defined header.
     *
     * @since
     *      1.0.0
     * @param header
     *      Name of the header to set
     * @param value
     *      Value to set against the header
     */
    void putHeader(final String header, final String value);

    /**
     * Adds the given value against the specified header.
     * This is used for Multi-value header items, in which a header may have multiple values against it.
     *
     * @since
     *      1.0.0
     * @param header
     *      Name of the header to add a value against
     * @param value
     *      Value to add to the header
     */
    void addHeader(final String header, final String value);

    /**
     * Removes the given header.
     *
     * @since
     *      1.0.0
     * @param header
     *      Name of the header to remove
     */
    void removeHeader(final String header);

    /**
     * Returns a map of all the header values defined for this response.
     *
     * @since
     *      1.0.0
     * @return
     *      Map of header values
     */
    Map<String, List<String>> getHeaders();


    /**
     * Obtains the current HTTP Status Code of this response instance.
     *
     * @since
     *      1.0.0
     * @return
     *      HTTP Status Code
     */
    ResponseStatus getResponseStatus();

    /**
     * Sets the content of the response body.
     *
     * @since
     *      1.0.0
     * @param content
     *      Body content
     */
    void setBody(final T content);

    /**
     * Obtains the current content of the response body.
     *
     * @since
     *      1.0.0
     * @return
     *      Body content
     */
    T getBody();

    /**
     * Returns the Body content as a String.
     *
     * @since
     *      1.0.0
     * @return
     *      Body content as a string
     */
    String getBodyAsString();

    /**
     * Compiles the response into a JSON String that can be sent to the Lambda Handler's OutputStream.
     *
     * @since
     *      1.0.0
     * @return
     *      JSON String representation of this response
     */
    default String toJsonString() {
        JSONObject jsonObject = new JSONObject();

        // Base64 Encoding
        jsonObject.put("isBase64Encoded", this.isBase64Encoded());

        // Response Body
        jsonObject.put("body", this.getBodyAsString());

        // Status code
        ResponseStatus responseStatus = this.getResponseStatus();
        if (responseStatus == null) {
            throw new NullPointerException("Status Code has not been defined");
        }
        jsonObject.put("statusCode", responseStatus.getCode());

        // Headers
        jsonObject.put("multiValueHeaders", this.getHeaders());

        // return as a JSON string
        return jsonObject.toString();
    }
}
