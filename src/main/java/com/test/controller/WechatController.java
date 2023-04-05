package com.test.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.common.config.WeChatConfig;
import com.test.common.service.UserService;
import com.test.model.JsonData;

@Controller
@RequestMapping("wechat")
public class WechatController {
	@Autowired
	private UserService userService;
	@Autowired
	private WeChatConfig weChatConfig;
	
	@GetMapping("login_url")
	public JsonData loginUrl(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {

        //官方文档说明需要进行编码
        String callbackUrl = URLEncoder.encode(weChatConfig.getOpenRedirectUrl(), "GBK"); //进行编码

        //格式化，返回拼接后的url，去调微信的二维码
        String qrcodeUrl = String.format(WeChatConfig.OPEN_QRCODE_URL, weChatConfig.getOpenAppid(), callbackUrl, accessPage);
        //System.out.println(JsonData.buildSuccess(qrcodeUrl));
       
        return JsonData.buildSuccess(qrcodeUrl);

    }
	
	@GetMapping("/user/code")
    public void wechatUserCallback(@RequestParam(value = "code",required = true) String code, String state, HttpServletResponse response){

        System.out.println(code);

        userService.saveWeChatUser(code);
    }
}
