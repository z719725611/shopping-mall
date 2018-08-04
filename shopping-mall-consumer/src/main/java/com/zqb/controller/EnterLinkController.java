package com.zqb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/8/2
 *
 * @author zengqb
 * @version 1.0
 */
@Controller
@RequestMapping("/sm/enterLink")
public class EnterLinkController {
    /**
     * 跳转页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/goToMdDesigner",method = RequestMethod.GET)
    public String goToMdDesigner() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("vue/index");
        return "index";
    }
}
