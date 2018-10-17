package com.zqb.controller;

import com.zqb.bean.Account;
import com.zqb.common.BaseException;
import com.zqb.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/10/17
 *
 * @author zengqb
 * @version 1.0
 */
@RequestMapping("/account")
@Controller
public class AccountController {

    private static Logger logger = Logger.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    @ResponseBody
    public ModelAndView register(@RequestBody Account account) throws BaseException {
        ModelAndView mv = new ModelAndView();
        accountService.insertAccount(account);
        return mv;
    }

    @PostMapping("/checkAccount")
    @ResponseBody
    public ModelAndView checkAccount(@RequestBody String userName) throws BaseException {
        ModelAndView mv = new ModelAndView();
        Account account = new Account(userName, null);
        Account account1 = accountService.findAccount(account);
        if (null == account1) {

        } else {

        }
        return mv;
    }

}
