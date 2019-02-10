package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

/**
 * Represents an editable route/endpoint.
 */
public interface MutableRoute extends Route {

    /**
     * Removes all {@link RequestMethod}s from the {@link Route}.
     */
    void clearRequestMethods();

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
     * Defines the partial URI path for this route.
     *
     * @param path
     *      Partial URI path.
     */
    void setPath(final String path);
}
