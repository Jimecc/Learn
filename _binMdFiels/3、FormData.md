### FormData

[B站--省、市、区](https://www.bilibili.com/video/BV11E411e7yF?p=23)

| 方法     | 参数 | 作用                                                         |
| -------- | ---- | ------------------------------------------------------------ |
| FormData |      | 1、将html表单映射为**表单对象**<br>2、可以实现异步上传二进制文件 |

```html
<!--html表单-->
<form id="form">
	<input type="text" name = "username"/>
    <input type="password" name = "password"/>
    <input type="button"/>   
</form>
```

```javascript
//将html表单转换成一个表单对象
var form = document.getElementById('form');
var formData = new FormData(form);
```

```javascript
xhr.send(formData);
```

<font color=#f8080>可以直接放在Ajax下的send（）中</font>

<font color=#f8080>FormData不能用于get请求，因为它只能放在send（）中</font>

![image-20201019144534700](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019144534700.png)



![image-20201019144928720](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019144928720.png)

-----

### FormData.

<font color=#f890>方法一:</font>formdata.**get('key')** 

	1.  获取表单对象中的值

```javascript
console.log(formData.get('username'))
```

输出结果：<font color=#ff00>zhangsan</font>

-----

<font color=#f890>方法二:</font>formdata.**set('key','value')** 

	1. 改变表单对象中某一个属性的值
 	2. 如果存在则改变
 	3. 如果不存在则新建

----

<font color=#f890>方法三:</font>formdata.**delete('key')** 

	1. 删除表单中给的属性

<font color=#f890>方法四:</font>formdata.**append('key','value')** 

	1. 在表单对象中追加值
 	2. 与set的区别：<font size=4 color=#ff88>set有则改变无则追加，而append可以保留两个</font>

----

### FormData二进制文件上传

```javascript
var file = document.getElementById('file')
//当用户选择文件的时候
file.onchange = function(){
    //创建空表单对象
    var formData = new FormData();
    //将用户选择的二进制文件追加到表单对象中去
    //第一个参数是数据的属性名称，第二个参数是具体要追加的数据
    formData.append('attrName',this.files[0])
}
```

<font color=#f900>file[0]是一个集合，即使只选择一个对象也是一个集合</font>

![image-20201019152913743](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019152913743.png)

<font color=#900>form.uploadDir = path.join()</font>

![image-20201019155402665](C:\Users\18130\AppData\Roaming\Typora\typora-user-images\image-20201019155402665.png) 

<font color=#f988>在请求的过程中持续触发</font>

```javascript
xhr.upload.onprogress = function(ev){
	//console.log(ev);
    //没上传一点点文件，触发一次 onprogress
    //ev.loaded 文件已经上传了多少
    //ev.total  文件总共的大小
}
```

 

**删除表单对象中的值：**formData.delect('key');

**向表单对象中追加值**：formData.append('key','value');

```javascript
var f = new FormData();
f.append('sex','男');
// 与 set 不同的是，append方法可以追加数据，而且允许相同 key 的元素存在。
```

<font color=#f809>在服务器中要是不经过特殊设置，若有相同的键值对，它每次只会保留最后一对儿。</font>

```html
<!-- html 的代码-->
<input type="file" id="file"/>
```

```javascript
<!--javaScript代码-->
var file = document.getElementbyId('file');
//当用户选择文件的时候
file.onchange = function(){
  //创建一个空的表单对象
  var formData = new FormData();
  //将用户选择的二进制文件追加到 表单对象 中去
  formData.append(this.files[0]);
  //配置 Ajax 对象，请求方式必须为 Post （GET 的请求方式不能提交二进制文件）
  xhr.open('post','www.example.com');
  xhr.send(formData);
}
```

Http状态码：

xhr.status == 200 时请求时成功的。

<font color = #f890>在</font>

