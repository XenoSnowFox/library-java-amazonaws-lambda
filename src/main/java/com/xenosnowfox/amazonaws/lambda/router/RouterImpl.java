package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.response.Response;

import java.util.List;
import java.util.Vector;

/**
 * Basic implementation of a Router.
 */
public class RouterImpl implements Router {

    /**
     * Collection of routes for this router.
     */
    private List<Route> routes = new Vector<>();

    @Override
    public final boolean removeRoute(final Route route) {
        return this.routes.remove(route);
    }

    @Override
    public final void addRoute(final Route route) {
        if (route == null) {
            throw new NullPointerException("Route cannot be null");
        }

        this.routes.add(route);
    }

    @Override
    public final Response handle(final Route route, final Request request) {





        return null;
    }
}
