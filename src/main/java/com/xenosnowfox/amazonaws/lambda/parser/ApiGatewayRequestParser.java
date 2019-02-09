package com.xenosnowfox.amazonaws.lambda.parser;

import com.xenosnowfox.amazonaws.lambda.MutableRequest;
import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.request.MutableRequestImpl;
import com.xenosnowfox.amazonaws.lambda.requestcontext.ApiGatewayRequestContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

/**
 * Helper method to convert an AWS API Gateway Request JSON Object into a new Request instance.
 */
public final class ApiGatewayRequestParser {

    /**
     * Hidden Constructor.
     */
    private ApiGatewayRequestParser() { }

    /**
     * Attempts to extract and parse and API Gateway Request JSON Object out of an input stream.
     *
     * @param inputStream
     *      Input stream.
     * @return
     *      A new {@link MutableRequest} instance.
     */
    public static MutableRequest parse(final InputStream inputStream) {
        return parse((JSONObject) new JSONTokener(inputStream).nextValue());
    }

    /**
     * Attempts to parse and API Gateway Request JSON Object into a new Request instance.
     *
     * @param jsonObject
     *      JSON Object containing data.
     * @return
     *      A new {@link MutableRequest} instance.
     */
    public static MutableRequest parse(final JSONObject jsonObject) {

        // start a new request
        MutableRequest request = new MutableRequestImpl();

        // parse the HTTP Method
        String s = jsonObject.optString("httpMethod");
        if (s != null) {
            request.setRequestMethod(RequestMethod.valueOf(s.trim().toUpperCase()));
        }

        // parse the path
        request.setPath(jsonObject.getString("path"));

        // base 64 encoding
        request.setBase64Encoded(jsonObject.optBoolean("isBase64Encoded"));

        // query string params
        JSONObject jsonQueryString = jsonObject.optJSONObject("multiValueQueryStringParameters");
        if (jsonQueryString != null) {
            for (String key : jsonQueryString.keySet()) {
                JSONArray jsonArray = jsonQueryString.optJSONArray(key);
                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        request.putQueryStringParameter(key, jsonArray.getString(i));
                    }
                }
            }
        }

        // headers
        JSONObject jsonHeaders = jsonObject.optJSONObject("multiValueHeaders");
        if (jsonHeaders != null) {
            for (String key : jsonHeaders.keySet()) {
                JSONArray jsonArray = jsonHeaders.optJSONArray(key);
                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        request.putHeader(key, jsonArray.getString(i));
                    }
                }
            }
        }

        // stage variables
        JSONObject jsonStageVariables = jsonObject.optJSONObject("stageVariables");
        if (jsonStageVariables != null) {
            for (String key : jsonStageVariables.keySet()) {
                request.putStageVariable(key, jsonStageVariables.optString(key));
            }
        }

        // path parameters
        JSONObject jsonPathParameters = jsonObject.optJSONObject("pathParameters");
        if (jsonPathParameters != null) {
            for (String key : jsonPathParameters.keySet()) {
                request.putPathParameter(key, jsonPathParameters.optString(key));
            }
        }

        // parse the body content
        request.setBody(jsonObject.optString("body"));

        // parse the request context object
        JSONObject j = jsonObject.optJSONObject("requestContext");
        if (j != null) {
            request.setRequestContext(new ApiGatewayRequestContext(j));
        }

        // return the newly parse request
        return request;
    }
}
