package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.request.RequestContext;

/**
 * Represents a mutable version of a request.
 */
public interface MutableRequest extends Request {

    /**
     * Defines the HTTP request method used to make the request.
     *
     * @param requestMethod
     *      HTTP request Method
     * @since
     *      1.0.0
     */
    void setRequestMethod(final RequestMethod requestMethod);

    /**
     * Obtains the URI path of the request.
     *
     * @param path
     *      URI Path
     * @since
     *      1.0.0
     */
    void setPath(final String path);

    /**
     * Adds the given header value to the map of headers.
     *
     * @param name
     *      name of the header to add.
     * @param value
     *      value to add to the indicated header.
     * @since
     *      1.0.0
     */
    void putHeader(final String name, final String value);

    /**
     * Defines a value to be set against a header, removing any existing values that may have already been defined.
     *
     * @param name
     *      name of the header to add.
     * @param value
     *      value to add to the indicated header.
     * @since
     *      1.0.0
     */
    void setHeader(final String name, final String value);

    /**
     * Removes the given value from the indicated header.
     *
     * @param name
     *      name of the header to remove from.
     * @param value
     *      value to remove from the indicated header.
     * @since
     *      1.0.0
     */
    void removeHeader(final String name, final String value);

    /**
     * Removes any values set against the given header.
     *
     * @param name
     *      name of the header to remove.
     * @since
     *      1.0.0
     */
    void clearHeader(final String name);

    /**
     * Removes all headers.
     *
     * @since
     *      1.0.0
     */
    void clearHeaders();

    /**
     * Adds the given query string parameter value to the map of query string parameters.
     *
     * @param name
     *      name of the query string parameter to add.
     * @param value
     *      value to add the the indicated query string parameter.
     * @since
     *      1.0.0
     */
    void putQueryStringParameter(final String name, final String value);

    /**
     * Defines a value to be set against a query string parameter,
     * removing any existing values that may have already been defined.
     *
     * @param name
     *      name of the query string parameter to add.
     * @param value
     *      value to add the the indicated query string parameter.
     * @since
     *      1.0.0
     */
    void setQueryStringParameter(final String name, final String value);

    /**
     * Removes the given value set against the given query string parameter.
     *
     * @param name
     *      name of the query string parameter to remove from.
     * @param value
     *      value to remove from the indicated query string parameter.
     * @since
     *      1.0.0
     */
    void removeQueryStringParameter(final String name, final String value);

    /**
     * Removes any values set against the given query string parameter.
     *
     * @param name
     *      name of the query string parameter to remove.
     * @since
     *      1.0.0
     */
    void clearQueryStringParameter(final String name);

    /**
     * Removes all query string parameters.
     *
     * @since
     *      1.0.0
     */
    void clearQueryStringParameters();

    /**
     * Adds the given path parameter value to the map of path parameters.
     *
     * @param name
     *      name of the path parameter to add.
     * @param value
     *      value to add the the indicated path parameter.
     * @since
     *      1.0.0
     */
    void putPathParameter(final String name, final String value);

    /**
     * Removes any values set against the path parameter.
     *
     * @param name
     *      name of the path parameter to remove.
     * @since
     *      1.0.0
     */
    void removePathParameter(final String name);

    /**
     * Removes all path parameters.
     *
     * @since
     *      1.0.0
     */
    void clearPathParameters();

    /**
     * Adds the given stage variable value to the map of stage variables.
     *
     * @param name
     *      name of the stage variable to add.
     * @param value
     *      value to add the the indicated stage variable.
     * @since
     *      1.0.0
     */
    void putStageVariable(final String name, final String value);

    /**
     * Removes any values set against the stage variable.
     *
     * @param name
     *      name of the stage variable to remove.
     * @since
     *      1.0.0
     */
    void removeStageVariable(final String name);

    /**
     * Removes all stage variables.
     *
     * @since
     *      1.0.0
     */
    void clearStageVariables();

    /**
     * Indicates whether the content of the body is Base64 encoded.
     *
     * @param isBase64Encoded
     *      {@code true} if the body content is Base64 encoded, {@code false} otherwise.
     * @since
     *      1.0.0
     */
    void setBase64Encoded(final boolean isBase64Encoded);

    /**
     * Sets the contents of the request body as a String.
     *
     * @param body
     *      Request body as a string or {@code null} if no body content was provided.
     * @since
     *      1.0.0
     */
    void setBody(final String body);

    /**
     * Sets the request context, for this request, containing additional meta-data.
     *
     * @param requestContext
     *      Request Context
     * @since
     *      1.0.0
     */
    void setRequestContext(final RequestContext requestContext);
}
