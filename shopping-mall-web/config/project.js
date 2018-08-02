"use strict";

let name = 'shopping-mall-web';
let publishWebServiceName = 'shopping-mall-consumer';
let publishWebServiceResourcePath = '../../' + publishWebServiceName + '/target/ROOT/WEB-INF/classes/';

module.exports = {
    name: name, // 项目名：multi
    static_root: name,//静态资源路径(线上的assets,html,js文件夹所在路径)
    publishWebServiceResourcePath: publishWebServiceResourcePath, // 发布目录
    project: {
        // 项目列表
        // 组织格式 ： 项目名 => 以项目根目录为基准的index.vue路径
        // 其在webpack中的对应格式为：[name](生成的js名) => [main.js所在路径]
      sm: './src/view/sm'
    }
};
