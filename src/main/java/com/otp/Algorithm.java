package com.otp;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static com.otp.Constants.BAD_FORMAT;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Algorithm {
    MessageControler messageControler = new MessageControler();

    private List<String> result = new ArrayList<>();

    public Algorithm() {
    }

    /**
     * Parses ip (in long form) into String IP.
     *
     * @param ip - ip (in long form)
     * @return - IP - String
     */
    private static String intToIp(long ip) {
        long first = (ip >> 24) & 0xFF;
        long second = (ip >> 16) & 0xFF;
        long third = (ip >> 8) & 0xFF;
        long fourth = ip & 0xFF;
        return first + "." + second + "." + third + "." + fourth;
    }

    /**
     * Parses String IP into ip (in long form).
     *
     * @param ip - IP - String
     * @return - ip (in long form)
     * @throws UnknownHostException - UnknownHostException
     */
    private static long ipToInt(String ip) throws UnknownHostException {
        return new BigInteger(1, InetAddress.getByName(ip).getAddress()).longValue();
    }

    /**
     * Fills result.
     * 
     * @param firstIP - IP - String
     * @param secondIP - IP - String
     * @throws UnknownHostException - UnknownHostException
     */
    private void fillResult(String firstIP, String secondIP) throws UnknownHostException {
        long first = ipToInt(firstIP);
        long second = ipToInt(secondIP);
        for(long i = first; i <= second; i++) {
           result.add(intToIp(i));
        }
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(String firstIP, String secondIP) throws UnknownHostException {
        if (!messageControler.check(firstIP) || !messageControler.check(secondIP)) {
            throw new IllegalArgumentException(BAD_FORMAT);
        }
        fillResult(firstIP, secondIP);
    }
}
