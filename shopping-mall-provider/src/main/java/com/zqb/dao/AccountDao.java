package com.zqb.dao;

import com.zqb.bean.Account;
import com.zqb.common.BaseException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
@Mapper
@Repository
public interface AccountDao {

    /**
     * 新增账号
     * @param account 账号
     * @throws BaseException
     */
    @Insert("insert into account(userName, password, createTime, updateTime) values(#{userName}, #{password}," +
            " #{createTime, jdbcType=TIMESTAMP} , #{updateTime, jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true, keyProperty = "accountID")
    void insertAccount(Account account) throws BaseException;

    /**
     * 查询账号
     * @param account 账号
     * @throws BaseException
     */
    @Select("select * from account where userName=#{userName}")
    Account findAccount(Account account) throws BaseException;
}
