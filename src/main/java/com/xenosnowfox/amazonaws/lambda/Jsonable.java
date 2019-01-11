package com.xenosnowfox.amazonaws.lambda;

import org.json.JSONObject;

/**
 * Defines an object that can be converted to a JSON Object or can generate a representation of itself in JSON format
 */
public interface Jsonable {
    /**
     * Obtains a JSON Object representation of the instance
     *
     * @return
     *      JSON Object
     */
    JSONObject toJsonObject();
}
