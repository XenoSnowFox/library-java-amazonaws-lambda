package com.xenosnowfox.amazonaws.lambda.router;

/**
 * A Router is an object that maintains a collection of sub-routes, which it will attempt to pass a request on to.
 */
public interface Router extends RouteHandler {
    /**
     * Adds a {@link Route} to the router.
     *
     * @param route
     *      {@link Route} to add.
     */
    void addRoute(final Route route);

    /**
     * Removes the first occurrence of the specified {@link Route} from the router.
     *
     * @param route
     *      {@link Route} to remove.
     * @return
     *      {@code true} if the router contained the specified route.
     */
    boolean removeRoute(final Route route);

    /**
     * Generates and adds a new route onto this router.
     *
     * @return
     *      {@link MutableRouteImpl}.
     */
    default MutableRoute route() {
        MutableRoute route = new MutableRouteImpl();
        this.addRoute(route);
        return route;
    }

    /**
     * Generate and adds a new route on to this router, presetting it's path method.
     *
     * @param path
     *      URI path
     * @return
     *      {@link MutableRouteImpl}.
     */
    default MutableRoute route(final String path) {
        MutableRoute route = this.route();
        route.setPath(path);
        return route;
    }
}
