### Vue 4

**界面元素**：![vue界面元素](/Users/hsk/Downloads/vue界面元素.png)



**目录层级**：

-- node_modules:依赖文件

​	<font color=#890>*配置热启动的方法*：</font>

-- public： 入口 index.html

-- src  	：资源（各个版本之间可以共享）

-- router :

----- index.js

​    <font color=#890>有两种加载方式</font>

```javascript
    // route level code-splitting  -- 是否拆分（路由级别代码）
    // this generates a separate chunk (about.[hash].js) for this route （是否将路由拆分成单独块文件）
    // which is lazy-loaded when the route is visited.（懒加载的方式）
```



----- main.js

​	<font size=2>`Vue.config.productionTip = false` </font><font color=#890>//阻止生产环境的模式</font>

```javascript
new Vue({
  router,
  render: h => h(App) // 将当前元素挂载到 app ， ES6 的写法，h 是超脚本
  // render:function(create){  ----- ES 5 写法
  //   return createElement(App) ----- 创建这个组件 （APP中全市组件）
  // }
}).$mount('#app')   //手动挂载
```



babel.js

package.json：十分重要的配置文件

```json
// .json 文件
{
  "name": "vuelearn",
  //项目名称
  "version": "0.1.0",
  //项目版本
  "private": true,
  "scripts": {
    //启动命令
    "serve": "vue-cli-service serve",
    //打包命令
    "build": "vue-cli-service build"
  },
  //需要一起打包的文件
  "dependencies": {
    "core-js": "^3.6.5",
    "vue": "^2.6.11",
    "vue-router": "^3.2.0"
  },
  //丢弃的内容
  "devDependencies": {
    "@vue/cli-plugin-babel": "~4.5.0",
    "@vue/cli-plugin-router": "~4.5.0",
    "@vue/cli-service": "~4.5.0",
    "vue-template-compiler": "^2.6.11"
  },
  "browserslist": [
    "> 1%",
    "last 2 versions",
    "not dead"
  ]
}
```

<font color=#890>从 vue 3 开始 越来越接近 react 的脚手架</font>

### 与之前版本的区别：

| 位置        | 旧版本           | 新版本 |
| ----------- | ---------------- | ------ |
| import 导入 | 不需要(.vue)类型 | 需要   |
|             |                  |        |
|             |                  |        |

**使用Element-UI**

1. <font color=#f12>在VS code 中 </font>使用 `npm i element-ui -S`下载Element-UI

2. <font color=#g789>使用</font>`import ElementUI from ‘element-ui’导入`
3. Vue.use(ElementUI)
4. <font color=#f12>报错</font>`To install them,you can run:npm install --save element-ui element-ui/lib/theme-chalk/index.css`
5. 在 cmd 中<font color=#f234>终止</font> 并 <font color=#g789>运行</font> `cnpm install --save element-ui` 

### 配置端口号等：

1. 新建 vue.config.js 文件

2. 写入内容

   ```javascript
   // JavaScript
   module.export={
   	devServer:{
       port:8080,	//对应的端口号
       host:'localhost',
       open:true 	//配置浏览器自动打开
     }
   }
   ```

   



- 杂记：
  1. 接收参数

```vue
<!--Vue 接收参数-->
<script>
export default {
  name: 'HelloWorld',
  props: { // 接收参数
    msg: String // 形参 + 参数类型
  }
}
</script>
```





### axiod.get**

axiod.get(地址).then(function(response){请求成功时触发},function(err){请求失败时触发})

axiod.get(地址？查询键值对).then(function(response){请求成功时触发},function(err){请求失败时触发})

axiod.get(地址？key=value & key2=value2).then(function(response){请求成功时触发},function(err){请求失败时触发})![截屏2020-10-28上午10.17.26](/Users/hsk/Library/Application Support/typora-user-images/截屏2020-10-28上午10.17.26.png) 

