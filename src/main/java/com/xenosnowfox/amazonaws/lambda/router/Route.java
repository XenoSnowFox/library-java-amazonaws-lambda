package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

/**
 * Represents an endpoint/route.
 */
public interface Route {
    /**
     * Evaluates whether this route is capable of satisfying the incoming request.
     *
     * @param request
     *      Request to handle.
     * @return
     *      {@code true} if the route can handle the request, {@code false} otherwise.
     */
    boolean matches(final Request request);


    /**
     * Returns {@code true} this the {@link Route} is capable of handling a request with the given {@link RequestMethod}.
     *
     * @param requestMethod
     *      {@link RequestMethod}.
     * @return
     *      {@code true} if the {@link Route} can handle requests of the indicated {@link RequestMethod},
     *      {@code false} otherwise
     */
    boolean containsRequestMethod(final RequestMethod requestMethod);

    /**
     * Obtains the {@link RouteHandler} assigned to this instance.
     *
     * @return
     *      {@link RouteHandler}.
     */
    RouteHandler getRouteHandler();

    /**
     * Obtains the partial URI path for this route.
     *
     * @return
     *      Partial URI path.
     */
    String getPath();
}
