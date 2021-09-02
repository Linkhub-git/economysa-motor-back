package com.quickdev.base.configuration.oauth;

/**
 * @author QuickDev
 * @version 1.0
 */
public class OAuthConstant {

  public static final String IOS_CLIENT_ID = "ios_client";
  public static final String IOS_CLIENT_SECRET = "{bcrypt}$2a$10$51VMRmGqcLqojqXkZFFwIufc7trvCmTp/dDVmeBSTUVZoQhrEB/YK";

  public static final String ANDROID_CLIENT_ID = "android_client";
  public static final String ANDROID_CLIENT_SECRET = "{bcrypt}$2a$10$51VMRmGqcLqojqXkZFFwIufc7trvCmTp/dDVmeBSTUVZoQhrEB/YK";

  public static final String ANGULAR_CLIENT_ID = "angular_client";
  public static final String ANGULAR_CLIENT_SECRET = "{bcrypt}$2a$10$51VMRmGqcLqojqXkZFFwIufc7trvCmTp/dDVmeBSTUVZoQhrEB/YK";

  public static final String SCOPE_READ = "read";
  public static final String SCOPE_WRITE = "write";
  public static final String ROLE_USER = "ROLE_USER";

  public static final String GRANT_TYPE_PASSWORD = "password";
  public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

  public static final int EXPIRES_IN = 3600;
  public static final int NEVER_EXPIRES = -1;
}
