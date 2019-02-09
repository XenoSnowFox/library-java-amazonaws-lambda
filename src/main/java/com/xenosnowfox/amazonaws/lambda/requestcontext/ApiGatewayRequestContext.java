package com.xenosnowfox.amazonaws.lambda.requestcontext;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.Identity;
import com.xenosnowfox.amazonaws.lambda.RequestContext;
import com.xenosnowfox.amazonaws.lambda.identity.ApiGatewayIdentity;
import org.json.JSONObject;

import java.time.Instant;

/**
 * Implementation of a RequestContext that parses it's data from a JSON object.
 *
 * @since
 *      1.0.0
 */
public class ApiGatewayRequestContext implements RequestContext {

    /**
     * Stage name.
     */
    private final String stage;

    /**
     * Account Id.
     */
    private final String accountId;

    /**
     * API id.
     */
    private final String apiId;

    /**
     * Resource Id.
     */
    private final String resourceId;

    /**
     * Resporce Path.
     */
    private final String resourcePath;

    /**
     * Request method.
     */
    private final RequestMethod requestMethod;

    /**
     * Request protocol.
     */
    private final String protocol;

    /**
     * Request Id.
     */
    private final String requestId;

    /**
     * Extended Request Id.
     */
    private final String extendedRequestId;

    /**
     * Source Identity.
     */
    private final Identity identity;

    /**
     * Domain Name.
     */
    private final String domainName;

    /**
     * Domain prefix.
     */
    private final String domainPrefix;

    /**
     * Path.
     */
    private final String path;

    /**
     * Timestamp requested.
     */
    private final Instant timestampRequested;

    /**
     * Attempts to construct a new RequestContext from the given JSON Object.
     *
     * @since
     *      1.0.0
     * @param jsonObject
     *      JSON Object containing the request context information
     */
    public ApiGatewayRequestContext(final JSONObject jsonObject) {

        // Http Method
        String s = jsonObject.optString("httpMethod");
        if (s != null) {
            this.requestMethod = RequestMethod.valueOf(s);
        } else {
            this.requestMethod = null;
        }

        // parse the resource id
        this.resourceId = jsonObject.optString("resourceId");

        // parse the resource path
        this.resourcePath = jsonObject.optString("resourcePath");

        // parse the extended request id
        this.extendedRequestId = jsonObject.optString("extendedRequestId");

        // parse the path
        this.path = jsonObject.optString("path");

        // parse the account id
        this.accountId = jsonObject.optString("accountId");

        // parse the protocol
        this.protocol = jsonObject.optString("protocol");

        // parse the stage
        this.stage = jsonObject.optString("stage");

        // parse the domain prefix
        this.domainPrefix = jsonObject.optString("domainPrefix");

        // parse the domain name
        this.domainName = jsonObject.optString("domainName");

        // parse the api id
        this.apiId = jsonObject.optString("apiId");

        // parse the request id
        this.requestId = jsonObject.optString("requestId");

        // parse the identity sub-object
        JSONObject j = jsonObject.optJSONObject("identity");
        if (j != null) {
            this.identity = new ApiGatewayIdentity(j);
        } else {
            this.identity = null;
        }

        // parse the timestamp
        Long l = jsonObject.optLong("requestTimeEpoch");
        if (l != null) {
            this.timestampRequested = Instant.ofEpochMilli(l);
        } else {
            this.timestampRequested = null;
        }
    }

    @Override
    public final String getResourceId() {
        return this.resourceId;
    }

    @Override
    public final String getResourcePath() {
        return this.resourcePath;
    }

    @Override
    public final RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public final String getExtendedRequestId() {
        return this.extendedRequestId;
    }

    @Override
    public final String getPath() {
        return this.path;
    }

    @Override
    public final String getAccountId() {
        return this.accountId;
    }

    @Override
    public final String getProtocol() {
        return this.protocol;
    }

    @Override
    public final String getStage() {
        return this.stage;
    }

    @Override
    public final String getDomainPrefix() {
        return this.domainPrefix;
    }

    @Override
    public final String getRequestId() {
        return this.requestId;
    }

    @Override
    public final Identity getIdentity() {
        return this.identity;
    }

    @Override
    public final String getDomainName() {
        return this.domainName;
    }

    @Override
    public final String getApiId() {
        return this.apiId;
    }

    @Override
    public final Instant getTimestampRequested() {
        return this.timestampRequested;
    }
}
