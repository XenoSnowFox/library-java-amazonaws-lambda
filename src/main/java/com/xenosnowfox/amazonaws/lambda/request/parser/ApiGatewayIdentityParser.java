package com.xenosnowfox.amazonaws.lambda.request.parser;

import com.xenosnowfox.amazonaws.lambda.request.MutableIdentity;
import com.xenosnowfox.amazonaws.lambda.request.MutableIdentityImpl;
import org.json.JSONObject;

/**
 * Helper method to convert an AWS API Gateway Identity JSON Object into a new Identity instance.
 */
public final class ApiGatewayIdentityParser {

    /**
     * Hidden Constructor.
     */
    private ApiGatewayIdentityParser() { }

    /**
     * Attempt to parse a JSON Object and extract an Identity Context.
     *
     * @param jsonObject
     *      JSON Object containing identity data.
     * @return
     *      Identity.
     */
    public static MutableIdentity parse(final JSONObject jsonObject) {

        // new Identity instance
        MutableIdentity identity = new MutableIdentityImpl();

        // parse the source ip
        identity.setSourceIp(jsonObject.optString("sourceIp"));

        // parse the user agent
        identity.setUserAgent(jsonObject.optString("userAgent"));

        // return the new instance
        return identity;
    }
}
