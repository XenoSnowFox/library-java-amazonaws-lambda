package com.xenosnowfox.amazonaws.lambda.router;

/**
 * Implementation of the MutableRouteContext interface.
 */
public class MutableRouteContextImpl implements MutableRouteContext {

    /**
     * THe path of the RouteContext.
     */
    private String path;

    /**
     * Instantiates an empty RouteContext instance.
     */
    public MutableRouteContextImpl() { }

    /**
     * Instantiates a deep copy of a specified RouteContext.
     *
     * @param other
     *      {@link RouteContext} to copy.
     */
    public MutableRouteContextImpl(final RouteContext other) {
        this.setPath(other.getPath());
    }

    @Override
    public final void setPath(final String path) {
        this.path = path;
    }

    @Override
    public final String getPath() {
        return this.path;
    }
}
