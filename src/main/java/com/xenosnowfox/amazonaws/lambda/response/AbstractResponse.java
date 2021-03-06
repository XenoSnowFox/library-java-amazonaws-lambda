package com.xenosnowfox.amazonaws.lambda.response;

import com.xenosnowfox.amazonaws.lambda.Response;
import com.xenosnowfox.amazonaws.lambda.http.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * An Abstract implementation of the Response interface that implement all the common functionality (or functionality that doesn't normally alter between implementations).
 *
 * @since
 *      1.0.0
 * @param <T>
 *     The data type of the response content
 */
public abstract class AbstractResponse<T> implements Response<T> {

    private boolean isBase64Encoded = false;
    private ResponseStatus responseStatus = null;
    private Map<String, List<String>> headers = new HashMap<>();

    @Override
    public final void setBase64Encoded(boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

    @Override
    public final boolean isBase64Encoded() {
        return this.isBase64Encoded;
    }

    @Override
    public final void setResponseStatus(ResponseStatus httpStatus) {
        this.responseStatus = httpStatus;
    }

    @Override
    public final ResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    @Override
    public void putHeader(final String header, final String value) {
        List<String> values = new Vector<>();
        values.add(value);
        headers.put(header, values);
    }

    @Override
    public void addHeader(final String header, final String value) {
        if (headers.containsKey(header)) {
            List<String> values = headers.get(header);
            values.add(value);
        } else {
            this.putHeader(header, value);
        }
    }

    @Override
    public void removeHeader(final String header) {
        headers.remove(header);
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

}
