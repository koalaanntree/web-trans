package com.wnlbs.webtrans.websocket.sender;

import com.wnlbs.webtrans.domain.User;
import com.wnlbs.webtrans.websocket.WebSocketTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

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
    public void sendMessage() throws IOException, EncodeException {

        log.info(("============>sendMsg"));

        for (WebSocketTemplate webSocketTemplate : webSocketTemplateSet) {

            webSocketTemplate.getSession().getBasicRemote()
                    .sendText("hello");


            Encoder.Text<User> encoder = new Encoder.Text<User>() {
                @Override
                public String encode(User user) throws EncodeException {

                    return user.toString();
                }

                @Override
                public void init(EndpointConfig endpointConfig) {

                }

                @Override
                public void destroy() {

                }
            };

            webSocketTemplate.getSession().getBasicRemote()
                    .sendObject(encoder.encode(new User("aaa","aaa")));

        }



    }


}
