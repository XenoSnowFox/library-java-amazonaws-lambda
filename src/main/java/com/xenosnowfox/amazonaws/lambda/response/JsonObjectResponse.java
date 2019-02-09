package com.xenosnowfox.amazonaws.lambda.response;

import org.json.JSONObject;

/**
 * Implementation of a JSON Response object.
 *
 * This implementation pre-defines the `Content-Type` header as {@code application/json}
 *
 * @since
 *      1.0.0
 */
public class JsonObjectResponse extends AbstractResponse<JSONObject> {

    /**
     * JSON body content.
     */
    private JSONObject bodyContent;

    /**
     * instantiates a new response where the body content is a JSON Object.
     *
     * @since
     *      1.0.0
     */
    public JsonObjectResponse() {
        this.putHeader("Content-Type", "application/json");
    }

    @Override
    public final void setBody(final JSONObject content) {
        this.bodyContent = content;
    }

    @Override
    public final JSONObject getBody() {
        return this.bodyContent;
    }

    @Override
    public final String getBodyAsString() {
        return this.bodyContent.toString();
    }
}
