package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.Request;
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
    boolean canHandle(final Request request);


    /**
     * Removes all {@link RequestMethod}s from the {@link Route}.
     */
    void clearRequestMethods();

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
     * Adds the given {@link RequestMethod} to the list of possible methods this route is capable of handling.
     *
     * @param requestMethod
     *      {@link RequestMethod}.
     * @return
     *      {@code true} if the {@link Route} didn't already have the {@link RequestMethod}
     */
    boolean addRequestMethod(final RequestMethod requestMethod);

    /**
     * Removes the specific {@link RequestMethod} from the list of possible methods this route is capable of handling.
     *
     * @param requestMethod
     *      {@link RequestMethod}.
     * @return
     *      {@code true} if the {@link Route} has contained the given {@link RequestMethod}
     */
    boolean removeRequestMethod(final RequestMethod requestMethod);

    /**
     * Defines the handler method for this route.
     *
     * @param handler
     *      {@link RouteHandler}.
     */
    void setRouteHandler(final RouteHandler handler);

    /**
     * Obtains the {@link RouteHandler} assigned to this instance.
     *
     * @return
     *      {@link RouteHandler}.
     */
    RouteHandler getRouteHandler();

    /**
     * Defines the partial URI path for this route.
     *
     * @param path
     *      Partial URI path.
     */
    void setPath(final String path);

    /**
     * Obtains the partial URI path for this route.
     *
     * @return
     *      Partial URI path.
     */
    String getPath();
}
