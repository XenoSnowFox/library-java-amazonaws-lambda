package com.xenosnowfox.amazonaws.lambda.router;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract implementation of a {@link Route}, that handles some basic request evaluation.
 */
public class MutableRouteImpl implements MutableRoute {

    /**
     * The route handler.
     */
    private RouteHandler routeHandler;

    /**
     * Route's path.
     */
    private String path;

    /**
     * Holds a collection of {@link RequestMethod}s this {@link Route} is capable of handling.
     */
    private Set<RequestMethod> requestMethods = new HashSet<>();

    @Override
    public final void clearRequestMethods() {
        this.requestMethods.clear();
    }

    @Override
    public final boolean containsRequestMethod(final RequestMethod requestMethod) {
        return this.requestMethods.contains(requestMethod);
    }

    @Override
    public final boolean addRequestMethod(final RequestMethod requestMethod) {
        return this.requestMethods.add(requestMethod);
    }

    @Override
    public final boolean removeRequestMethod(final RequestMethod requestMethod) {
        return this.requestMethods.remove(requestMethod);
    }

    @Override
    public final void setRouteHandler(final RouteHandler handler) {
        this.routeHandler = handler;
    }

    @Override
    public final RouteHandler getRouteHandler() {
        return this.routeHandler;
    }

    @Override
    public final void setPath(final String path) {
        this.path = path;
    }

    @Override
    public final String getPath() {
        return this.path;
    }

    @Override
    public final Set<RequestMethod> getRequestMethods() {
        return new HashSet<>(requestMethods);
    }
}
