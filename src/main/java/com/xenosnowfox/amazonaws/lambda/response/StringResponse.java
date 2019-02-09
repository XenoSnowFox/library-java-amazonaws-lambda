package com.xenosnowfox.amazonaws.lambda.response;

/**
 * Implementation of a String response.
 *
 * This implementation pre-defines the `Content-Type` header as {@code text/plain}
 *
 * @since
 *      1.0.0
 */
public class StringResponse extends AbstractResponse<String> {

    /**
     * String body content.
     */
    private String bodyContent;

    /**
     * Instantiates a new response where the body content is a plain text string.
     *
     * @since
     *      1.0.0
     */
    public StringResponse() {
        this.putHeader("Content-Type", "text/plain");
    }

    @Override
    public final void setBody(final String content) {
        this.bodyContent = content;
    }

    @Override
    public final String getBody() {
        return this.bodyContent;
    }

    @Override
    public final String getBodyAsString() {
        return this.bodyContent;
    }
}
