package com.wnlbs.webtrans.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: huangxin
 * @Date: Created in 下午5:08 2018/3/27
 * @Description:
 */
@Slf4j
public class WebSocketTemplate {

    /**
     * 单次会话
     */
    protected Session session;

    /**
     * 保存结果集
     */
    protected static CopyOnWriteArraySet<WebSocketTemplate> webSocketTemplateSet = new CopyOnWriteArraySet<>();

    /**
     * 建立连接  需要声明为Public否则无法加载进入spring模板引擎
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketTemplateSet.add(this);
        log.info("[webSocket消息]有新的连接，总数:" + webSocketTemplateSet.size());
    }

    /**
     * 接收消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("[webSocket消息]收到客户端发来的消息:" + message);
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose() {
        webSocketTemplateSet.remove(this);
        log.info("[webSocket消息]连接断开，总数:" + webSocketTemplateSet.size());
    }


    /**
     * 错误处理
     */
    @OnError
    public void OnError(Throwable t) {
        onClose();
    }

}
