package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;
import com.xenosnowfox.amazonaws.lambda.request.Request;
import com.xenosnowfox.amazonaws.lambda.response.Response;

import java.util.List;
import java.util.Set;
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

    /**
     * Evaluates whether the given route matches the request path.
     *
     * @param request
     *      Request.
     * @param parentContext
     *      Route Context.
     * @param route
     *      Route.
     * @return
     *      {@code true} for a match, {@code false} otherwise.
     */
    private boolean routeMatchesPath(final Request request, final RouteContext parentContext, final Route route) {
        String routePath = route.getPath();

        String regexSuffix = "/?";
        if (route.getRouteHandler() instanceof Router) {
            regexSuffix = "(/.*)?";
        }

        return routePath == null
                || Pattern.matches(
                        parentContext.getPath() + routePath + regexSuffix
                        , request.getPath()
                );
    }

    /**
     * Evaluates whether the given route matches the request's request method.
     *
     * @param request
     *      Request.
     * @param route
     *      Route.
     * @return
     *      {@code true} for a match, {@code false} otherwise.
     */
    private boolean routeMatchesRequestMethod(final Request request, final Route route) {
        Set<RequestMethod> routeRequestMethods = route.getRequestMethods();
        return routeRequestMethods == null
                || routeRequestMethods.size() == 0
                || routeRequestMethods.contains(request.getRequestMethod());
    }

    @Override
    public final Response handle(final RouteContext parentContext, final Request request) {

        for (Route route : this.routes) {

            // check if path matches
            if (routeMatchesPath(request, parentContext, route)
                    && routeMatchesRequestMethod(request, route)
            ) {

                MutableRouteContext context = new MutableRouteContextImpl(parentContext);
                if (route.getPath() != null) {
                    context.setPath(parentContext.getPath() + route.getPath());
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
