package com.wnlbs.webtrans.websocket.sender;

import com.wnlbs.webtrans.websocket.WebSocketTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

/**
 * @Author: huangxin
 * @Date: Created in 下午5:10 2018/3/27
 * @Description:
 */
@ServerEndpoint("/test")
@Component
@Slf4j
public class WebSocketTestSender extends WebSocketTemplate {

    /**
     * 发送消息
     */
    @Override
    public void sendMessage() {

        log.info(("============>sendMsg"));

    }


}
