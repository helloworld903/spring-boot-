package com.test.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class WeChatConfig {

    @Value("${wxopen.appid}")
    private String openAppid;

    @Value("${wxopen.appsecret}")
    private String openAppsecret;

    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    public final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";
    public final static String OPEN_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    public final static String OPEN_USER_INFO_URL ="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";


}