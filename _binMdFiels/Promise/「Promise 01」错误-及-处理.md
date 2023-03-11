**Promise**

[教学地址]（https://www.bilibili.com/video/BV1oz411B7Ng?p=6）

1. **实例对象** 与 **函数对象**

```javascript
// 例子1：函数对象
function Fn() //fn 是构造函数
console.log(Fn.prototype)

// 例子2：实例对象
function Person(){  ……  }
cont p = new Person();
```

<font color=#f890 size = 2>当一个【函数】 作为对象使用时<font color=#f123 size = 2>（操作他的属性或方法）</font>，就称为【函数对象】</font>

<font color=#f890 size = 2>当 使用 new 来创建对象时，则是【实例对象】，简称【对象】</font>

<font color=#f890 size = 2.5>补充1：bind 方法 ：f.bind(Obj) == obj.f()</font>

<font color=#f890 size = 2>补充2：call ： 调用 （方法/函数）Fn.call( ) Fn是 函数对象</font>

<font color=# size = 3>**1.2 **回调函数的两种类型</font>

```javascript
1.同步回调： <!>
  cont arr =[1,3,5]
  arr.forEach(item => {
    //遍历的回调函数
    console.log(item);
  })
	console.log('forEach()之后')
		// <输出内容 ： 1 3 5 forEach之后>

2.异步回调：
	setTimeout(() => {
    console.log('timeout callback()')
  },0)
	console.log('setTimeout之后')
		//输出内容：先后在前
```

[什么是回调函数](https://www.zhihu.com/question/19801131)

<font color=#f890 size = 2>补充：setTimeout( (  ) => { 函数 }  ,  时间 )</font>

<font color=#f890 size = 2>setTimeout() 方法用于在指定的毫秒数后调用函数或执行表达式。返回一个 ID（数字），可以将这个ID传递给 clearTimeout() 来取消执行。</font>

<font color=#f890 size = 2>同步异步判断方式：只要在之后写一个打印输出就好了。</font>

**1.3** Error

---

<font color=#696969>错误类型：Error</font> 【最高级父类】

| 形式           | 原因                       | 备注 |
| -------------- | -------------------------- | ---- |
| ReferenceError | 引用变量不存在             |      |
| TypeError      | 数据类型不正确             |      |
| RangeError     | 数据值不再其所允许的范围内 |      |
| SyntaxError    | 语法错误                   |      |

<font color=#f890 size = 2>报错 ：Uncaught + 错误方式 </font>

<font color=#f890 size = 2>			未处理    +    错误方式</font>

```javascript
// ReferenceError
  var a;
  console.log(b)
```

↑ <font color=#f123 size = 2>Uncaught ReferenceError: b is not defined</font>



```javascript
// TypeError
	let b = null；
  console.log(b.xxx)
	
	let c = undefined
  console.log(c.xxx)
```

↑ <font color=#f123 size = 2>Uncaught TypeError:Connot read property 'xxx' of null</font>

<font color=#f123 size = 2>Uncaught TypeError:不能在 null 上读取 xxx 属性</font>



↑ <font color=#f123 size = 2>Uncaught TypeError:Connot read property 'xxx' of undefined</font>

<font color=#f123 size = 2>Uncaught TypeError:不能在 未定义的对象上 上读取 xxx 属性</font>

```javascript
//RangeError 例子：递归调用
	function fn(){
    fn()
  }
```

↑ <font color=#f123 size = 2>Uncaught RangeError:Maximum call stack size exceeded</font>



```javascript
// SyntaxError 语法错误
	const c = """"
```

↑ <font color=#f123 size = 2>Uncaught SyntaxError:Unexcepted String</font>

**2. 错误处理**

1. 捕获错误：try……catch……
2. 抛出错误：throw error

```javascript
// 捕获错误：try……catch……
try{
  //尝试执行
	let b
  console.log(b.xxx)
}catch(error){
  //遇到错误 输出错误
  //其中 error 是一个对象，有两个属性 message 与 stack
  console.log(error)
  console.log(error.message)
  console.log(error.stack)
}
```

<font color=#f890 size = 2>调试方法： Debug</font>

<font color=#f890 size = 2>Error 对象的属性：message 、 stack</font>

```javascript
// 抛出错误：throw error
function something(){
  if(Data.now()%2===1){
    console.log('当前时间是奇数，可以执行任务')
  }else{
    //如果时间是偶数，则抛出异常 由调用者类处理
    throw new Error('当前时间为偶数，无法执行任务')
  }
}

try{
  something()
}catch(error){
  alert(error.message)
}
```

<font color=#f890 size = 2>简单理解就是自己【自定义】一个异常</font>

**3. 错误对象**

1. message属性：错误相关信息
2. stack      属性： 函数调用栈记录信息

