package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.Request;

/**
 * Represents an endpoint/route.
 */
public interface Route {
    /**
     * Evaulates whether this route is capable of satisifyng the incoming request.
     *
     * @param request
     *      Incoming request.
     * @return
     *      {@code true} if the route can handle the request, {@code false} otherwise.
     */
    boolean canHandle(final Request request);
}
