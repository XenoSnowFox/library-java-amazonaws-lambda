package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

import java.time.Instant;

/**
 * Represents a mutable RequestContext.
 */
public interface MutableRequestContext extends RequestContext {

    /**
     * Defines the HTTP Request Method used when making the request.
     *
     * @since
     *      1.0.0
     * @param requestMethod
     *      Http Request Method
     */
    void setRequestMethod(RequestMethod requestMethod);

    /**
     * Defines the protocol used to make the request (eg: HTTP/1.1).
     *
     * @since
     *      1.0.0
     * @param protocol
     *      Protocol
     */
    void setProtocol(String protocol);

    /**
     * Defines the name of the current stage as defined by Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @param stage
     *      Stage's name
     */
    void setStage(String stage);

    /**
     * Defines the identity of the resource from Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @param resourceId
     *      API Gateway Resource ID
     */
    void setResourceId(String resourceId);

    /**
     * Defines the path of the resource from Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @param resourcePath
     *      API Gateway Resource Path
     */
    void setResourcePath(String resourcePath);

    /**
     * Defines the identity information of the source making the request.
     *
     * @since
     *      1.0.0
     * @param identity
     *      Source's identity
     */
    void setIdentity(Identity identity);

    /**
     * Defines the domain name used when making the request.
     *
     * @since
     *      1.0.0
     * @param domainName
     *      Domain Name
     */
    void setDomainName(String domainName);

    /**
     * Defines the prefix portion of the domain name.
     *
     * @since
     *      1.0.0
     * @param domainPrefix
     *      Domain prefix
     */
    void setDomainPrefix(String domainPrefix);

    /**
     * Defines the path of the URI used to make the request.
     *
     * @since
     *      1.0.0
     * @param path
     *      URI path
     */
    void setPath(String path);

    /**
     * Defines the account id that's executing the request.
     *
     * @since
     *      1.0.0
     * @param accountId
     *      Account ID
     */
    void setAccountId(String accountId);

    /**
     * Defines the API identifier string.
     *
     * @since
     *      1.0.0
     * @param apiId
     *      API identifier
     */
    void setApiId(String apiId);

    /**
     * Defines a unique identifier for the request.
     *
     * @since
     *      1.0.0
     * @param requestId
     *      Request identifier
     */
    void setRequestId(String requestId);

    /**
     * Defines the extended request id.
     *
     * @since
     *      1.0.0
     * @param extendedRequestId
     *      Extended Request Id
     */
    void setExtendedRequestId(String extendedRequestId);

    /**
     * Defines the timestamp of when the request was made.
     *
     * @since
     *      1.0.0
     * @param timestamp
     *      Timestamp when request was made
     */
    void setTimestampRequested(Instant timestamp);
}
