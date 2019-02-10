package com.xenosnowfox.amazonaws.lambda.request;

/**
 * Represents a Mutable Identity instance.
 */
public interface MutableIdentity extends Identity {

    /**
     * Defines the source IP address.
     *
     * @param ip
     *      IP Address.
     */
    void setSourceIp(String ip);

    /**
     * Defines the source's User Agent.
     *
     * @param userAgent
     *      User Agent String.
     */
    void setUserAgent(String userAgent);
}
