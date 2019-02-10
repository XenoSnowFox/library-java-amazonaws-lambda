package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.response.Response;

import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

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
    public final Response handle(final RouteContext parentContext, final Request request) {

        for (Route route : this.routes) {
            String routePath = route.getPath();

            String regexSuffix = "/?";
            if (route.getRouteHandler() instanceof Router) {
                regexSuffix = "(/.*)?";
            }

            // check if path matches
            if (
                    (routePath == null || Pattern.matches(parentContext.getPath() + routePath + regexSuffix, request.getPath()))
                    && route.matches(request)
            ) {

                MutableRouteContext context = new MutableRouteContextImpl(parentContext);
                if (routePath != null) {
                    context.setPath(parentContext.getPath() + routePath);
                }

                Response resp = route.getRouteHandler().handle(context, request);
                if (resp != null) {
                    return resp;
                }
            }
        }

        // no matching routes were found
        return null;
    }
}
