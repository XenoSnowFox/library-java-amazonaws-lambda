package com.xenosnowfox.amazonaws.lambda.request;

import com.xenosnowfox.amazonaws.lambda.http.RequestMethod;

import java.time.Instant;

/**
 * Implementation of a RequestContext that parses it's data from a JSON object.
 *
 * @since
 *      1.0.0
 */
public class MutableRequestContextImpl implements MutableRequestContext {

    /**
     * Stage name.
     */
    private String stage;

    /**
     * Account Id.
     */
    private String accountId;

    /**
     * API id.
     */
    private String apiId;

    /**
     * Resource Id.
     */
    private String resourceId;

    /**
     * Resporce Path.
     */
    private String resourcePath;

    /**
     * Request method.
     */
    private RequestMethod requestMethod;

    /**
     * Request protocol.
     */
    private String protocol;

    /**
     * Request Id.
     */
    private String requestId;

    /**
     * Extended Request Id.
     */
    private String extendedRequestId;

    /**
     * Source Identity.
     */
    private Identity identity;

    /**
     * Domain Name.
     */
    private String domainName;

    /**
     * Domain prefix.
     */
    private String domainPrefix;

    /**
     * Path.
     */
    private String path;

    /**
     * Timestamp requested.
     */
    private Instant timestampRequested;

    /**
     * Default Constructor.
     *
     * @since
     *      1.0.0
     */
    public MutableRequestContextImpl() { }

    /**
     * Instantiates a deep copy of another RequestContext.
     *
     * @since
     *      1.0.0
     * @param other
     *      RequestContext to copy.
     */
    public MutableRequestContextImpl(final RequestContext other) {
        this.setAccountId(other.getAccountId());
        this.setApiId(other.getApiId());
        this.setDomainName(other.getDomainName());
        this.setDomainPrefix(other.getDomainPrefix());
        this.setRequestId(other.getRequestId());
        this.setResourceId(other.getResourceId());
        this.setResourcePath(other.getResourcePath());
        this.setRequestMethod(other.getRequestMethod());
        this.setExtendedRequestId(other.getExtendedRequestId());
        this.setPath(other.getPath());
        this.setProtocol(other.getProtocol());
        this.setStage(other.getStage());
        this.setTimestampRequested(other.getTimestampRequested());
        this.setIdentity(other.getIdentity());
    }

    @Override
    public final String getResourceId() {
        return this.resourceId;
    }

    @Override
    public final String getResourcePath() {
        return this.resourcePath;
    }

    @Override
    public final RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public final String getExtendedRequestId() {
        return this.extendedRequestId;
    }

    @Override
    public final String getPath() {
        return this.path;
    }

    @Override
    public final String getAccountId() {
        return this.accountId;
    }

    @Override
    public final String getProtocol() {
        return this.protocol;
    }

    @Override
    public final String getStage() {
        return this.stage;
    }

    @Override
    public final String getDomainPrefix() {
        return this.domainPrefix;
    }

    @Override
    public final String getRequestId() {
        return this.requestId;
    }

    @Override
    public final Identity getIdentity() {
        return this.identity;
    }

    @Override
    public final String getDomainName() {
        return this.domainName;
    }

    @Override
    public final String getApiId() {
        return this.apiId;
    }

    @Override
    public final Instant getTimestampRequested() {
        return this.timestampRequested;
    }

    @Override
    public final void setRequestMethod(final RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public final void setProtocol(final String protocol) {
        this.protocol = protocol;
    }

    @Override
    public final void setStage(final String stage) {
        this.stage = stage;
    }

    @Override
    public final void setResourceId(final String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public final void setResourcePath(final String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public final void setIdentity(final Identity identity) {
        this.identity = identity;
    }

    @Override
    public final void setDomainName(final String domainName) {
        this.domainName = domainName;
    }

    @Override
    public final void setDomainPrefix(final String domainPrefix) {
        this.domainPrefix = domainPrefix;
    }

    @Override
    public final void setPath(final String path) {
        this.path = path;
    }

    @Override
    public final void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    @Override
    public final void setApiId(final String apiId) {
        this.apiId = apiId;
    }

    @Override
    public final void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    @Override
    public final void setExtendedRequestId(final String extendedRequestId) {
        this.extendedRequestId = extendedRequestId;
    }

    @Override
    public final void setTimestampRequested(final Instant timestamp) {
        this.timestampRequested = timestamp;
    }
}
