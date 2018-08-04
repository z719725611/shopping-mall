package com.zqb.dao;

import com.zqb.bean.Goods;
import com.zqb.common.BaseException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/7/25
 *
 * @author zengqb
 * @version 1.0
 */
@Mapper
@Repository
public interface GoodsDao {
    /**
     * 新增商品信息
     *
     * @param goods 商品信息
     * @return 操作结果
     * @throws BaseException 异常处理
     */
    int insertGoods(Goods goods) throws BaseException;

    /**
     * 删除商品信息
     *
     * @param goods 商品信息
     * @return 操作结果
     * @throws BaseException 异常处理
     */
    int delGoods(Goods goods) throws BaseException;

    /**
     * 修改商品信息
     *
     * @param goods 商品信息
     * @return 操作结果
     * @throws BaseException 异常处理
     */
    int updateGoods(Goods goods) throws BaseException;
}
