package com.xenosnowfox.amazonaws.lambda.request;

/**
 * Implementation of the Identity interface that is generated from a JSON Object.
 *
 * @since
 *      1.0.0
 */
public class MutableIdentityImpl implements MutableIdentity {

    /**
     * Source IP.
     */
    private String sourceIp;

    /**
     * User Agent.
     */
    private String userAgent;

    /**
     * Default constructor.
     */
    public MutableIdentityImpl() { }

    /**
     * Instantiate a deep copy of the another Identity instance.
     *
     * @since
     *      1.0.0
     * @param other
     *      Identity instance to copy.
     */
    public MutableIdentityImpl(final Identity other) {
        this.setSourceIp(other.getSourceIp());
        this.setUserAgent(other.getUserAgent());
    }

    @Override
    public final String getSourceIp() {
        return this.sourceIp;
    }

    @Override
    public final String getUserAgent() {
        return this.userAgent;
    }

    @Override
    public final void setSourceIp(final String ip) {
        this.sourceIp = ip;
    }

    @Override
    public final void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }
}
