package com.xenosnowfox.amazonaws.lambda.identity;

import com.xenosnowfox.amazonaws.lambda.Identity;
import org.json.JSONObject;

/**
 * Implementation of the Identity interface that is generated from a JSON Object
 *
 * @since
 *      1.0.0
 */
public class ApiGatewayIdentity implements Identity {

    private final String sourceIp;
    private final String userAgent;

    /**
     * Instantiate a new instance from the data within the given JSON Object
     *
     * @since
     *      1.0.0
     * @param jsonObject
     *      JSON Object to parse
     */
    public ApiGatewayIdentity(final JSONObject jsonObject) {

        // parse the source ip
        this.sourceIp = jsonObject.optString("sourceIp");

        // parse the user agent
        this.userAgent = jsonObject.optString("userAgent");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSourceIp() {
        return this.sourceIp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserAgent() {
        return this.userAgent;
    }
}
