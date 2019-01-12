package com.xenosnowfox.amazonaws.lambda.requestcontext;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.Identity;
import com.xenosnowfox.amazonaws.lambda.RequestContext;
import com.xenosnowfox.amazonaws.lambda.identity.ApiGatewayIdentity;
import org.json.JSONObject;

import java.time.Instant;

/**
 * Implementation of a RequestContext that parses it's data from a JSON object
 *
 * @since
 *      1.0.0
 */
public class ApiGatewayRequestContext implements RequestContext {

    // API Gateway variables
    private final String stage;
    private final String accountId;
    private final String apiId;
    private final String resourceId;
    private final String resourcePath;

    // Request variables
    private final RequestMethod requestMethod;
    private final String protocol;
    private final String requestId;
    private final String extendedRequestId;

    // source identity
    private final Identity identity;

    // domain name / uri
    private final String domainName;
    private final String domainPrefix;
    private final String path;

    // timestamp
    private final Instant timestampRequested;

    /**
     * Attempts to construct a new RequestContext from the given JSON Obect
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
    public String getResourceId() {
        return this.resourceId;
    }

    @Override
    public String getResourcePath() {
        return this.resourcePath;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public String getExtendedRequestId() {
        return this.extendedRequestId;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getAccountId() {
        return this.accountId;
    }

    @Override
    public String getProtocol() {
        return this.protocol;
    }

    @Override
    public String getStage() {
        return this.stage;
    }

    @Override
    public String getDomainPrefix() {
        return this.domainPrefix;
    }

    @Override
    public String getRequestId() {
        return this.requestId;
    }

    @Override
    public Identity getIdentity() {
        return this.identity;
    }

    @Override
    public String getDomainName() {
        return this.domainName;
    }

    @Override
    public String getApiId() {
        return this.apiId;
    }

    @Override
    public Instant getTimestampRequested() {
        return this.timestampRequested;
    }
}
