package com.zqb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/7/16
 *
 * @author zengqb
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:spring/dubbo.properties")
@ImportResource({"classpath:spring/spring-dubbo.xml"})
public class ProviderConfig {
}
