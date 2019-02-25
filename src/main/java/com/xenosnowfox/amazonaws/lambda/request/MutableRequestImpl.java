package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Implementation of a MutableRequest.
 */
public class MutableRequestImpl implements MutableRequest {

    /**
     * Request Method.
     */
    private RequestMethod requestMethod = null;

    /**
     * URI path.
     */
    private String path = null;

    /**
     * Indicates if the body content is Base64 encoded.
     */
    private boolean isBase64Encoded = false;

    /**
     * Request body content.
     */
    private String bodyContent = null;

    /**
     * Query String Parameters.
     */
    private Map<String, List<String>> queryStringParameters = new HashMap<>();

    /**
     * Headers.
     */
    private Map<String, List<String>> headers = new HashMap<>();

    /**
     * Stage Variables.
     */
    private Map<String, String> stageVariables = new HashMap<>();

    /**
     * Path Parameters.
     */
    private Map<String, String> pathParameters = new HashMap<>();

    /**
     * Request Context.
     */
    private RequestContext requestContext = null;

    /**
     * Instantiates a new empty request.
     */
    public MutableRequestImpl() { }

    /**
     * Instantiates a deep copy of another request.
     *
     * @param other
     *      Request to copy.
     */
    public MutableRequestImpl(final Request other) {
        this.setRequestMethod(other.getRequestMethod());
        this.setPath(other.getPath());
        this.setBase64Encoded(other.isBase64Encoded());
        this.setBody(other.getBody());
        this.setRequestContext(new MutableRequestContextImpl(other.getRequestContext()));

        // query string params
        for (Map.Entry<String, String[]> entry : other.getQueryStringParameters().entrySet()) {
            for (String value : entry.getValue()) {
                this.putQueryStringParameter(entry.getKey(), value);
            }
        }

        // headers
        for (Map.Entry<String, String[]> entry : other.getHeaders().entrySet()) {
            for (String value : entry.getValue()) {
                this.putHeader(entry.getKey(), value);
            }
        }

        // stage variables
        for (Map.Entry<String, String> entry : other.getStageVariables().entrySet()) {
            this.putStageVariable(entry.getKey(), entry.getValue());
        }

        // path parameters
        for (Map.Entry<String, String> entry : other.getPathParameters().entrySet()) {
            this.putPathParameter(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final void setRequestMethod(final RequestMethod requestMethod) {
        if (requestMethod == null) {
            throw new NullPointerException("Request Method cannot be null.");
        }

        this.requestMethod = requestMethod;
    }

    @Override
    public final void setPath(final String path) {
        if (path == null) {
            throw new NullPointerException("Path cannot be null.");
        }

        this.path = path;
    }

    @Override
    public final void putHeader(final String name, final String value) {
        List<String> headerValues;
        if (this.headers.containsKey(name)) {
            headerValues = this.headers.get(name);
        } else {
            headerValues = new Vector<>();
            this.headers.put(name, headerValues);
        }
        headerValues.add(value);
    }

    @Override
    public final void setHeader(final String name, final String value) {
        this.clearHeader(name);
        this.putHeader(name, value);
    }

    @Override
    public final void removeHeader(final String name, final String value) {
        if (this.headers.containsKey(name)) {
            List<String> headerValues = this.headers.get(name);
            headerValues.remove(value);
        }
    }

    @Override
    public final void clearHeader(final String name) {
        this.headers.remove(name);
    }

    @Override
    public final void clearHeaders() {
        this.headers.clear();
    }

    @Override
    public final void putQueryStringParameter(final String name, final String value) {
        List<String> values;
        if (this.queryStringParameters.containsKey(name)) {
            values = this.queryStringParameters.get(name);
        } else {
            values = new Vector<>();
            this.queryStringParameters.put(name, values);
        }
        values.add(value);
    }

    @Override
    public final void setQueryStringParameter(final String name, final String value) {
        this.clearQueryStringParameter(name);
        this.putQueryStringParameter(name, value);
    }

    @Override
    public final void removeQueryStringParameter(final String name, final String value) {
        if (this.queryStringParameters.containsKey(name)) {
            List<String> l = this.queryStringParameters.get(name);
            l.remove(value);
        }
    }

    @Override
    public final void clearQueryStringParameter(final String name) {
        this.queryStringParameters.remove(name);
    }

    @Override
    public final void clearQueryStringParameters() {
        this.queryStringParameters.clear();
    }

    @Override
    public final void putPathParameter(final String name, final String value) {
        this.pathParameters.put(name, value);
    }


    @Override
    public final void removePathParameter(final String name) {
        this.pathParameters.remove(name);
    }

    @Override
    public final void clearPathParameters() {
        this.pathParameters.clear();
    }

    @Override
    public final void putStageVariable(final String name, final String value) {
        this.stageVariables.put(name, value);
    }

    @Override
    public final void removeStageVariable(final String name) {
        this.stageVariables.remove(name);
    }

    @Override
    public final void clearStageVariables() {
        this.stageVariables.clear();
    }

    @Override
    public final void setBase64Encoded(final boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

    @Override
    public final void setBody(final String body) {
        this.bodyContent = body;
    }

    @Override
    public final void setRequestContext(final RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public final RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public final String getPath() {
        return this.path;
    }

    @Override
    public final Map<String, String[]> getHeaders() {
        Map<String, String[]> map = new HashMap<>();
        for (String header : this.headers.keySet()) {
            map.put(header, this.getHeader(header));
        }
        return map;
    }

    @Override
    public final String[] getHeader(final String header) {
        if (!this.headers.containsKey(header)) {
            return null;
        }

        List<String> values = this.headers.get(header);

        String[] s = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            s[i] = values.get(i);
        }
        return s;
    }

    @Override
    public final Map<String, String[]> getQueryStringParameters() {
        Map<String, String[]> map = new HashMap<>();
        for (String parameter : this.queryStringParameters.keySet()) {
            map.put(parameter, this.getQueryStringParameter(parameter));
        }
        return map;
    }

    @Override
    public final String[] getQueryStringParameter(final String parameter) {
        if (!this.queryStringParameters.containsKey(parameter)) {
            return null;
        }

        List<String> values = this.queryStringParameters.get(parameter);

        String[] s = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            s[i] = values.get(i);
        }
        return s;
    }

    @Override
    public final Map<String, String> getPathParameters() {
        return new HashMap<>(this.pathParameters);
    }

    @Override
    public final String getPathParameter(final String parameter) {
        return this.pathParameters.get(parameter);
    }

    @Override
    public final Map<String, String> getStageVariables() {
        return new HashMap<>(this.stageVariables);
    }

    @Override
    public final String getStageVariable(final String variable) {
        return this.stageVariables.get(variable);
    }

    @Override
    public final boolean isBase64Encoded() {
        return this.isBase64Encoded;
    }

    @Override
    public final String getBody() {
        return this.bodyContent;
    }

    @Override
    public final RequestContext getRequestContext() {
        return this.requestContext;
    }
}
