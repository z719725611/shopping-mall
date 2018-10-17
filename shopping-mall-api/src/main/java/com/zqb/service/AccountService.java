package com.zqb.service;


import com.zqb.bean.Account;
import com.zqb.common.BaseException;

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
public interface AccountService {

    /**
     * 新增账号
     *
     * @param account 账号
     * @throws BaseException
     */
    void insertAccount(Account account) throws BaseException;

    /**
     * 查询账号
     *
     * @param account 账号
     * @return account
     * @throws BaseException
     */
    Account findAccount(Account account) throws BaseException;
}
