package com.otp;

import org.apache.commons.validator.routines.InetAddressValidator;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class MessageControler {

    /**
     * Checks if ip has corrected format.
     *
     * @param ip - ip
     * @return - boolean
     */
    public boolean check(String ip) {
        InetAddressValidator validator = new InetAddressValidator();
        return validator.isValidInet4Address(ip);
    }
}
