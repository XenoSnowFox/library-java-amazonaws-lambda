package com.xenosnowfox.amazonaws.lambda.router;

/**
 * A Router is an object that maintains a collection of sub-routes, which it will attempt to pass a request on to.
 */
public interface Router extends Route, RouteHandler {
    /**
     * Adds a {@link Route} to the router.
     *
     * @param route
     *      {@link Route}.
     */
    void addRoute(final Route route);

    /**
     * Generates and adds a new route onto this router.
     *
     * @return
     *      {@link SimpleRoute}.
     */
    default Route route() {
        Route route = new SimpleRoute();
        this.addRoute(route);
        return route;
    }
}
