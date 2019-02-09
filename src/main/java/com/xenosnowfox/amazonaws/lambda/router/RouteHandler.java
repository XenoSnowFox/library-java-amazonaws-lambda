package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.Request;
import com.xenosnowfox.amazonaws.lambda.Response;

/**
 * Represents an object that is capable of handling a {@link Request} and possibly returning a {@link Response}.
 */
@FunctionalInterface
public interface RouteHandler {
    /**
     * Calls on the route to attempt to handle a given request.
     * If no response is returned, then the request is passed on to the next route that is capable of handling it.
     *
     * @param route
     *      The {@link Route} calling the handler.
     * @param request
     *      Request to handle.
     * @return
     *      A {@link Response} object of {@code null} if the handle doesn't return a response.
     */
    Response handle(final Route route, final Request request);
}
