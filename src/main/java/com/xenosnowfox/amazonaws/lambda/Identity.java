package com.xenosnowfox.amazonaws.lambda;

import org.json.JSONObject;

/**
 * Immutable object that contains identity details of the source making the request
 */
public interface Identity extends Jsonable {

    /**
     * Obtains the source's IP address
     *
     * @since
     *      1.0.0
     * @return
     *      IP address
     */
    String getSourceIp();

    /**
     * Obtains the user agent string used by the source.
     *
     * @since
     *      1.0.0
     * @return
     *      User Agent string
     */
    String getUserAgent();

    /**
     * Obtains a JSON Object representation of the instance
     *
     * @since
     *      1.0.0
     * @return
     *      JSON Object
     */
    @Override
    default JSONObject toJsonObject() {
        return new JSONObject()
                .put("sourceIp", this.getSourceIp())
                .put("userAgent", this.getUserAgent())
                ;
    }

}