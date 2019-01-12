package com.xenosnowfox.amazonaws.lambda.response;

import com.xenosnowfox.amazonaws.lambda.Jsonable;
/**
 * Implementation of a JSON Response object where the body content is a class that implements the {@code Jsonable} interface.
 *
 * This implementation pre-defines the `Content-Type` header as {@code application/json}
 *
 * @since
 *      1.0.0
 */
public class JsonableResponse extends AbstractResponse<Jsonable> {

    private Jsonable bodyContent;

    /**
     * instantiates a new response where the body content is Jsonable
     *
     * @since
     *      1.0.0
     */
    public JsonableResponse() {
        this.putHeader("Content-Type", "application/json");
    }

    @Override
    public void setBody(final Jsonable content) {
        this.bodyContent = content;
    }

    @Override
    public Jsonable getBody() {
        return this.bodyContent;
    }

    @Override
    public String getBodyAsString() {
        return this.bodyContent.toJsonObject().toString();
    }
}
