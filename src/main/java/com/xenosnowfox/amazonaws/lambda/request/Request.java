package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.util.Jsonable;
import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import org.json.JSONObject;

import java.util.Map;

/**
 * Immutable Request object that is parsed from the Lambda input stream.
 *
 * @since
 *      1.0.0
 */
public interface Request extends Jsonable {

    /**
     * Obtains the HTTP request method used to make the request.
     *
     * @since
     *      1.0.0
     * @return
     *      HTTP request Method
     */
    RequestMethod getRequestMethod();

    /**
     * Obtains the URI path of the request.
     *
     * @since
     *      1.0.0
     * @return
     *      URI Path
     */
    String getPath();

    /**
     * Obtains a map of header values from the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Header values
     */
    Map<String, String[]> getHeaders();

    /**
     * Obtains the values for the given header name.
     *
     * @param header
     *      name of the header item to retrieve
     * @return
     *      an array of values or {@code null} if the header is not defined
     */
    String[] getHeader(final String header);

    /**
     * Obtains a map of query string parameters from the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Query String parameters
     */
    Map<String, String[]> getQueryStringParameters();

    /**
     * Obtains the values for the given query string parameter name.
     *
     * @param parameter
     *      name of the query string parameter to retrieve
     * @return
     *      an array of values or {@code null} if the query string parameter is not defined
     */
    String[] getQueryStringParameter(final String parameter);

    /**
     * Obtains a map of path parameters.
     *
     * @since
     *      1.0.0
     * @return
     *      Path parameters
     */
    Map<String, String> getPathParameters();

    /**
     * Obtains the value for the given path parameter name.
     *
     * @param parameter
     *      name of the path parameter to retrieve
     * @return
     *      value or {@code null} if the query string parameter is not defined
     */
    String getPathParameter(final String parameter);

    /**
     * Obtains a map of stage variables (usually generated from API Gateway) which can be used as an alternative
     * to Environment variables.
     *
     * @since
     *      1.0.0
     * @return
     *      Stage Variables
     */
    Map<String, String> getStageVariables();

    /**
     * Obtains the value for the given stage variable name.
     *
     * @param variable
     *      name of the stage variable to retrieve
     * @return
     *      value or {@code null} if the query string parameter is not defined
     */
    String getStageVariable(final String variable);

    /**
     * Indicates whether the content of the body is Base64 encoded.
     *
     * @since
     *      1.0.0
     * @return
     *      {@code true} if the body content is Base64 encoded, {@code false} otherwise.
     */
    boolean isBase64Encoded();

    /**
     * Obtains the contents of the request body as a String.
     *
     * @since
     *      1.0.0
     * @return
     *      Request body as a string or {@code null} if no body content was provided.
     */
    String getBody();

    /**
     * Obtains the request context, for this request, containing additional meta-data.
     *
     * @since
     *      1.0.0
     * @return
     *      Request Context
     */
    RequestContext getRequestContext();

    /**
     * Obtains a JSON Object representation of the instance.
     *
     * @since
     *      1.0.0
     * @return
     *      JSON Object
     */
    default JSONObject toJsonObject() {
        return new JSONObject()
                .put("httpMethod", this.getRequestMethod().toString())
                .put("path", this.getPath())
                .put("isBase64Encoded", this.isBase64Encoded())
                .put("body", this.getBody())
                .put("requestContext", this.getRequestContext().toJsonObject())
                .put("headers", this.getHeaders())
                .put("queryStringParameters", this.getQueryStringParameters())
                .put("stageVariables", this.getStageVariables())
                .put("pathParameters", this.getPathParameters())
                ;
    }
}
