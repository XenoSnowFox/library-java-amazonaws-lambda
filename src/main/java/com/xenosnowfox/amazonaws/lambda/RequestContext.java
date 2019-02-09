package com.xenosnowfox.amazonaws.lambda;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import org.json.JSONObject;

import java.time.Instant;

/**
 * Immutable object that holds meta-data about the current request.
 *
 * @since
 *      1.0.0
 */
public interface RequestContext extends Jsonable {

    /**
     * Obtains the HTTP Request Method used when making the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Http Request Method
     */
    RequestMethod getRequestMethod();

    /**
     * Obtains the protocol used to make the request (eg: HTTP/1.1).
     *
     * @since
     *      1.0.0
     * @return
     *      Protocol
     */
    String getProtocol();

    /**
     * Obtains the name of the current stage as defined by Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @return
     *      Stage's name
     */
    String getStage();

    /**
     * Obtains the identity of the resource from Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @return
     *      API Gateway Resource ID
     */
    String getResourceId();

    /**
     * Obtains the path of the resource from Amazon AWS's API Gateway.
     *
     * @since
     *      1.0.0
     * @return
     *      API Gateway Resource Path
     */
    String getResourcePath();

    /**
     * Obtains the identity information of the source making the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Source's identity
     */
    Identity getIdentity();

    /**
     * Obtains the domain name used when making the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Domain Name
     */
    String getDomainName();

    /**
     * Obtains the prefix portion of the domain name.
     *
     * @since
     *      1.0.0
     * @return
     *      Domain prefix
     */
    String getDomainPrefix();

    /**
     * Obtains the path of the URI used to make the request.
     *
     * @since
     *      1.0.0
     * @return
     *      URI path
     */
    String getPath();

    /**
     * Obtains the account id that's executing the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Account ID
     */
    String getAccountId();

    /**
     * Obtains the API identifier string.
     *
     * @since
     *      1.0.0
     * @return
     *      API identifier
     */
    String getApiId();

    /**
     * Obtains a unique identifier for the request.
     *
     * @since
     *      1.0.0
     * @return
     *      Request identifier
     */
    String getRequestId();

    /**
     * Obtains the extended request id.
     *
     * @since
     *      1.0.0
     * @return
     *      Extended Request Id
     */
    String getExtendedRequestId();

    /**
     * Obtain the timestamp of when the request was made.
     *
     * @since
     *      1.0.0
     * @return
     *      Timestamp when request was made
     */
    Instant getTimestampRequested();

    /**
     * Obtains a JSON Object representation of the instance.
     *
     * @since
     *      1.0.0
     * @return
     *      JSON Object
     */
    @Override
    default JSONObject toJsonObject() {
        return new JSONObject()
                .put("httpMethod", this.getRequestMethod().toString())
                .put("protocol", this.getProtocol())
                .put("stage", this.getStage())
                .put("resourceId", this.getResourceId())
                .put("resourcePath", this.getResourcePath())
                .put("domainName", this.getDomainName())
                .put("domainPrefix", this.getDomainPrefix())
                .put("path", this.getPath())
                .put("accountId", this.getAccountId())
                .put("apiId", this.getApiId())
                .put("requestId", this.getRequestId())
                .put("extendedRequestId", this.getExtendedRequestId())
                .put("requestTimeEpoch", this.getTimestampRequested().toEpochMilli())
                .put("identity", this.getIdentity().toJsonObject())
                ;
    }
}
