package geeapp.gee.security;

import geeapp.gee.application.properties.SpringApplicationContext;
import org.apache.tomcat.util.http.parser.Authorization;

public class SecurityConstants {
    public static final long EXPIRATION_TIME=864000000;
    public static final String TOKEN_PREFIX="Bearer";
    public static final String HEADER_STRING= "Authorization";
    public static final String SIGN_UP_uRL="/User";
    public static final String TOKEN_SECRET="jf9i4jgu83nfl0jfu57ejf7";


    public static  String getTokenSecret(){
        AppProperties appProperties=(AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
