package com.zqb.service.impl;

import com.zqb.bean.Account;
import com.zqb.common.BaseException;
import com.zqb.dao.AccountDao;
import com.zqb.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/7/17
 *
 * @author zengqb
 * @version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private static Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;


    @Override
    public void insertAccount(Account account) throws BaseException {
        if (null != account) {
            account.setCreateTime(new Timestamp(System.currentTimeMillis()));
            accountDao.insertAccount(account);
        } else {
            logger.error("Account为空,新增账号失败!");
        }
    }

    @Override
    public Account findAccount(Account account) throws BaseException {
        return accountDao.findAccount(account);
    }
}
