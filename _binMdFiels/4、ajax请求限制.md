#### ajax请求限制

- ajax只能向自己的服务器发送请求，**不能向其他服务器发送请求**



#### 同源政策

如果两个页面拥有相同的协议、域名和端口，那么两个页面就同源，其中只要有一个不同，就是不同源。

##### 出现的原因：

​	为了保护用户隐私。

​	ajax是不能向非同源地址发送请求的，但是实际上是可以发送的，但是服务器会拒绝。

##### 解决方案：

​	**JSONP**（json with padding）：不属于ajax请求，但是可以模拟ajax请求。

 1. 将不同源的服务器端请求地址写在script标签的src中（script 中的 <font color=#f840>src</font> **不受 同源政策限制**）

    <font color=#f840>src</font> ：地址不管长成什么样子，但是必须返回 java script 代码。

 2. 服务器响应数据必须是一个**函数的调用**，真正要发送给客户端的数据需要**作为函数调用的参数**。

 3. 要在客户端提前准备好函数定义fn，如果客户端没有定义，<font color=#f840>如果函数执行的时候没有找到函数的定一部分，代码将会报错。</font>

    函数必须定义在全局作用域下，而且函数定义代码必须要写在script的上面，这样才能找到

    ![函数](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019170633598.png)

    函数必须要<font color=#f840>先执行</font>，然后<font color=#f840>再被调用</font>，否则会报错。

 4. 在 fn 函数内部对服务器端返回的数据进行处理。

    ![image-20201019170935860](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019170935860.png)

```html

```

