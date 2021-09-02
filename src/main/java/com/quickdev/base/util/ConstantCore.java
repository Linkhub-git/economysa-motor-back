package com.quickdev.base.util;

/**
 * @author QuickDev
 * @version 1.0
 */
public class ConstantCore {

	public static final String SWAGGER_BASE_PACKAGE = "com.quickdev.base";
	public static final String SWAGGER_TITLE = "QuickDev Api Documentation";
	public static final String SWAGGER_DESCRIPTION = "Documentation for QuickDev";
	public static final String SWAGGER_VERSION = "Api v1.0";
	public static final String SWAGGER_CONTACT_NAME = "Jeferson Cieza";
	public static final String SWAGGER_CONTACT_URL = "https://quickdev.pe";
	public static final String SWAGGER_CONTACT_EMAIL = "jcieza@quickdev.pe";

	public static final String CONFIG_LOCALE = "es";
	public static final String CONFIG_LOCAL_INTERCEPTOR_PARAM_NAME = "lang";

	public static final String CORS_HEADER_1 = "Access-Control-Allow-Origin";
	public static final String CORS_HEADER_2 = "Access-Control-Allow-Methods";
	public static final String CORS_HEADER_3 = "Access-Control-Max-Age";
	public static final String CORS_HEADER_4 = "Access-Control-Allow-Headers";

	public static final String ASTERISK = "*";
	public static final String MAX_AGE_VALUE = "3600";
	public static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type";
	public static final String ALLOWED_HTTP_METHODS = "POST, GET, OPTIONS, DELETE";

	public static final String HTTP_METHOD_GET = "GET";
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_DELETE = "DELETE";
	public static final String HTTP_METHOD_OPTIONS = "OPTIONS";

	public static final String WHITE_SPACE = " ";
	public static final int ZERO = 0;

	public static final String LOGOUT_URL = "/oauth/logout";
	public static final String AUTHORIZE_URL = "/oauth/authorize";
	public static final String PUBLIC_PATH = "/api/v1/public/**";
	public static final String SECURED_PATH = "/api/v1/secured/**";
}
