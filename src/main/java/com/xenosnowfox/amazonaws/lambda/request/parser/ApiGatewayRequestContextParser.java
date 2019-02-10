package com.xenosnowfox.amazonaws.lambda.request.parser;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.request.MutableRequestContext;
import com.xenosnowfox.amazonaws.lambda.request.identity.ApiGatewayIdentity;
import com.xenosnowfox.amazonaws.lambda.request.MutableRequestContextImpl;
import org.json.JSONObject;

import java.time.Instant;

/**
 * Helper method to convert an AWS API Gateway Request Context JSON Object into a new Request Context instance.
 */
public final class ApiGatewayRequestContextParser {

    /**
     * Hidden Constructor.
     */
    private ApiGatewayRequestContextParser() { }

    /**
     * Attempt to parse a JSON Object and extract a Request Context.
     *
     * @param jsonObject
     *      JSON Object containing context data.
     * @return
     *      Request Context.
     */
    public static MutableRequestContext parse(final JSONObject jsonObject) {

        // start a new RequestContext
        MutableRequestContext context = new MutableRequestContextImpl();

        // Http Method
        String s = jsonObject.optString("httpMethod");
        if (s != null) {
            context.setRequestMethod(RequestMethod.valueOf(s));
        }

        // parse the resource id
        context.setResourceId(jsonObject.optString("resourceId"));

        // parse the resource path
        context.setResourcePath(jsonObject.optString("resourcePath"));

        // parse the extended request id
        context.setExtendedRequestId(jsonObject.optString("extendedRequestId"));

        // parse the path
        context.setPath(jsonObject.optString("path"));

        // parse the account id
        context.setAccountId(jsonObject.optString("accountId"));

        // parse the protocol
        context.setProtocol(jsonObject.optString("protocol"));

        // parse the stage
        context.setStage(jsonObject.optString("stage"));

        // parse the domain prefix
        context.setDomainPrefix(jsonObject.optString("domainPrefix"));

        // parse the domain name
        context.setDomainName(jsonObject.optString("domainName"));

        // parse the api id
        context.setApiId(jsonObject.optString("apiId"));

        // parse the request id
        context.setRequestId(jsonObject.optString("requestId"));

        // parse the identity sub-object
        JSONObject j = jsonObject.optJSONObject("identity");
        if (j != null) {
            context.setIdentity(new ApiGatewayIdentity(j));
        }

        // parse the timestamp
        Long l = jsonObject.optLong("requestTimeEpoch");
        if (l != null) {
            context.setTimestampRequested(Instant.ofEpochMilli(l));
        }

        // return the context
        return context;
    }
}
