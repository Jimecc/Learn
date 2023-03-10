import UIKit

var a = 10;
var b = 20;
print(a+b)

// 这玩意儿太简单了，不高兴写了


var aInt:Int? = 10;
var bInt:Int? = nil;
var cInt = aInt ?? 0;
var dInt = bInt ?? 0;
print(cInt) // 10
print(dInt) // 0
