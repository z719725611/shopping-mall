package com.zqb.controller;

import com.zqb.bean.Goods;
import com.zqb.common.BaseException;
import com.zqb.common.ReturnObject;
import com.zqb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/sm/goods")
@Controller
public class SMGoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/insertGoods")
    @ResponseBody
    public ReturnObject insertGoods() throws BaseException {
        ReturnObject ro = new ReturnObject();
        Goods goods = new Goods();
        goodsService.insertGoods(goods);
        ro.setSuccess(true);
        return ro;

    }
}
