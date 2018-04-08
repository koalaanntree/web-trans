package com.wnlbs.webtrans.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: huangxin
 * @Date: Created in 下午3:15 2018/3/30
 * @Description:
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 7262053289555581704L;
    private String userName;
    private String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
