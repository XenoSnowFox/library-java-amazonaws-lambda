package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

import java.util.Set;

/**
 * Represents an endpoint/route.
 */
public interface Route {

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
     * Obtains a Set of Request methods defined on the route.
     *
     * @return
     *      Set of {@link RequestMethod}.
     */
    Set<RequestMethod> getRequestMethods();

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
