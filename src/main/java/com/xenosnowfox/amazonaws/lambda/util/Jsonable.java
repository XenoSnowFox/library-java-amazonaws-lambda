package com.xenosnowfox.amazonaws.lambda.util;

import org.json.JSONObject;

/**
 * Defines an object that can be converted to a JSON Object or can generate a representation of itself in JSON format.
 *
 * @since
 *      1.0.0
 */
public interface Jsonable {
    /**
     * Obtains a JSON Object representation of the instance.
     *
     * @since
     *      1.0.0
     * @return
     *      JSON Object
     */
    JSONObject toJsonObject();
}
