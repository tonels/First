package com.aust.first.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String SUCCESS = "SUCCESS";
    
    /**
     * 历史不全删
     */
    public static final Integer DELETE_FLAG_NOT_ALL = 1;
    /**
     * 历史清空
     */
    public static final Integer DELETE_FLAG_CLEAN = 2;
    
    private Constants() {
    }
}
