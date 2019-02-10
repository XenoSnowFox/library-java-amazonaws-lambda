package com.xenosnowfox.amazonaws.lambda.router;

/**
 * Represents the details of the currently resolved route.
 */
public interface RouteContext {
    /**
     * Obtains the path URI of the currently resolved route.
     *
     * @return
     *      Route URI path
     */
    String getPath();
}
