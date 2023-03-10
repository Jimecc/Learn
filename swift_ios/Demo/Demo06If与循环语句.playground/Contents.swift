import UIKit


var aBool:Bool = true
if aBool == true{
    print("a is true")
}else{
    print("a is false")
}

var a:Int = 100
// a = nil // 报错！因为他不是隐式转换，定义的时候确定有值的，所以这时候不可以赋值为nil
var b:Int! = 100
b = nil
var c:Int? = 100
c = nil
