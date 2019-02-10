package com.xenosnowfox.amazonaws.lambda.router;

/**
 * Represents a mutable RouteContext.
 */
public interface MutableRouteContext extends RouteContext {
    /**
     * Defines the path for the route context.
     *
     * @param path
     *      Route URI path
     */
    void setPath(String path);
}
