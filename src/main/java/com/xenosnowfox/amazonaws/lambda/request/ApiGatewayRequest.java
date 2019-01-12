package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.Request;
import com.xenosnowfox.amazonaws.lambda.RequestContext;
import com.xenosnowfox.amazonaws.lambda.requestcontext.ApiGatewayRequestContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Implementation of a Request object that parses it's data from a given JSON object
 *
 * @since
 *      1.0.0
 */
public class ApiGatewayRequest implements Request {

    private final RequestMethod requestMethod;
    private final String path;
    private final boolean isBase64Encoded;
    private final String bodyContent;
    private final Map<String, String[]> queryStringParameters;
    private final Map<String, String[]> headers;
    private final Map<String, String> stageVariables;
    private final Map<String, String> pathParameters;
    private final ApiGatewayRequestContext requestContext;

    /**
     * Attempts to convert a JSON Object of key-value string arrays into a multi-map object
     *
     * @since
     *      1.0.0
     * @param jsonObject
     *      JSON object containing only key-value string arrays
     * @return
     *      Map of key-value string lists
     */
    private Map<String, String[]> parseIntoMultiMap(final JSONObject jsonObject) {
        Map<String, String[]> map = new HashMap<>();

        if (jsonObject != null) {
            for (String key : jsonObject.keySet()) {

                JSONArray jsonArray = jsonObject.optJSONArray(key);
                if (jsonArray != null) {
                    List<String> list = new Vector<>();

                    for(Object o : jsonArray) {
                        list.add((String) o);
                    }

                    if (list.size() > 0) {
                        map.put(key, (String[]) list.toArray());
                    }
                }
            }
        }

        return map;
    }

    /**
     * Attempts to convert a JSON object of key-value strings into a Map object.
     *
     * @since
     *      1.0.0
     * @param jsonObject
     *      JSON object containing only Key-Value strings
     * @return
     *      Map of key-value strings
     */
    private Map<String, String> parseIntoMap(final JSONObject jsonObject) {
        Map<String, String> map = new HashMap<>();

        if (jsonObject != null) {
            for (String key : jsonObject.keySet()) {
                map.put(key, jsonObject.optString(key));
            }
        }

        return map;
    }

    /**
     * Constructor that parses it's data from the given Json Object
     *
     * @since
     *      1.0.0
     * @param jsonObject
     *      JSON Object containing request data
     */
    public ApiGatewayRequest(final JSONObject jsonObject) {

        // parse the HTTP Method
        String s = jsonObject.optString("httpMethod");
        if (s != null) {
            this.requestMethod = RequestMethod.valueOf(s.trim().toUpperCase());
        } else {
            this.requestMethod = null;
        }

        // parse the path
        this.path = jsonObject.optString("path");

        // base 64 encoding
        this.isBase64Encoded = jsonObject.optBoolean("isBase64Encoded");

        // query string params
        this.queryStringParameters = parseIntoMultiMap(jsonObject.optJSONObject("multiValueQueryStringParameters"));

        // headers
        this.headers = parseIntoMultiMap(jsonObject.optJSONObject("multiValueHeaders"));

        // stage variables
        this.stageVariables = parseIntoMap(jsonObject.optJSONObject("stageVariables"));

        // path parameters
        this.pathParameters = parseIntoMap(jsonObject.optJSONObject("pathParameters"));

        // parse the body content
        this.bodyContent = jsonObject.optString("body");

        // parse the request context object
        JSONObject j = jsonObject.optJSONObject("requestContext");
        if (j != null) {
            this.requestContext = new ApiGatewayRequestContext(j);
        } else {
            this.requestContext = null;
        }
    }

    /**
     * Constructor that parses it's data from a JSON object contained within an input stream.
     *
     * @since
     *      1.0.0
     * @param inputStream
     *      Input stream holding a JSON object of request data
     */
    public ApiGatewayRequest(final InputStream inputStream) {
        this((JSONObject) new JSONTokener(inputStream).nextValue());
    }

    @Override
    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Map<String, String[]> getHeaders() {
        return this.headers;
    }

    @Override
    public String[] getHeader(String header) {
        return this.headers.get(header);
    }

    @Override
    public Map<String, String[]> getQueryStringParameters() {
        return this.queryStringParameters;
    }

    @Override
    public String[] getQueryStringParameter(String parameter) {
        return this.queryStringParameters.get(parameter);
    }

    @Override
    public Map<String, String> getPathParameters() {
        return this.pathParameters;
    }

    @Override
    public String getPathParameter(String parameter) {
        return this.pathParameters.get(parameter);
    }

    @Override
    public Map<String, String> getStageVariables() {
        return this.stageVariables;
    }

    @Override
    public String getStageVariable(String variable) {
        return this.stageVariables.get(variable);
    }

    @Override
    public boolean isBase64Encoded() {
        return this.isBase64Encoded;
    }

    @Override
    public String getBody() {
        return this.bodyContent;
    }

    @Override
    public RequestContext getRequestContext() {
        return this.requestContext;
    }
}
