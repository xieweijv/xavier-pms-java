package com.xavier.pms.controller;

import com.xavier.pms.resp.UserInfoVo;
import com.xavier.pms.utils.ServletUtil;
import com.xavier.pms.utils.UserContainer;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
public class CommonController {

    public HttpServletRequest getRequest() {
        return ServletUtil.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletUtil.getResponse();
    }

    public HttpSession getSession() {
        return ServletUtil.getSession();
    }

    protected UserInfoVo getLoginUser() {
        return UserContainer.get();
    }

}
