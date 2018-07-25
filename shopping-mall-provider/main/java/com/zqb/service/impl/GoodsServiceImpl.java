package com.zqb.service.impl;

import com.zqb.bean.Goods;
import com.zqb.common.BaseException;
import com.zqb.dao.GoodsDao;
import com.zqb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public int insertGoods(Goods goods) throws BaseException {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public int delGoods(Goods goods) throws BaseException {
        return 0;
    }

    @Override
    public int updateGoods(Goods goods) throws BaseException {
        return 0;
    }
}
