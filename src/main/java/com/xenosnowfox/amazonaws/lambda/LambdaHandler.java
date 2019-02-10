package com.xenosnowfox.amazonaws.lambda;

import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.response.Response;

/**
 * Denotes a class that can process Lambda requests.
 */
public interface LambdaHandler {
    /**
     * Handles the given request and returns the response to send back to the sender.
     *
     * @param request
     *      Incoming request details
     * @return
     *      Response object
     */
    Response handle(final Request request);

}
