package com.wnlbs.webtrans.controller;

import com.wnlbs.webtrans.websocket.sender.WebSocketTestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangxin
 * @Date: Created in 下午1:34 2018/3/30
 * @Description:
 */
@RestController
public class DispatcherController {

    @Autowired
    WebSocketTestSender webSocketTestSender;

    @GetMapping("/test")
    public void get() throws Exception{
        webSocketTestSender.sendMessage();

    }
}
