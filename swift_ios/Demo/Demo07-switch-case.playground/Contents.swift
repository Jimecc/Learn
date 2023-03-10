import UIKit

var a = 10

switch a
{
    case 10:
        print(10)
        fallthrough
    case 20:
        print(20)
    case 30:
        print(30)
    default: // default是一定要有的，否则就会报错
        print("未知")
}

var b = 10;
switch b
{
    case 10,40,50: // 可以匹配多个值
        print(10)
    case 20:
        print(20)
    case 30:
        print(30)
    default:
        print("未知")
}

var c = ("hello",10)
switch c
{
    case ("hello",10):
        print("\"hello\",10")
    case ("hello",11):
        print("\"hello\",11")
    case ("hello",12):
        print("\"hello\",12")
    default: // default是一定要有的，否则就会报错
        print("未知")
}

var d = 3
switch d
{
    case 1..<5: // 1~4
        print("1~4")
    case 5..<10: // 5~9
        print("5~9")
    default:
        print("未知")
    
}

// 元组的拆分匹配
var value = (10,20)
switch value
{
    case let(10,name) where name < 10: // 记得加 let
        print("10,\(name)") // 运行这个，并且不会再向下继续执行
    case (10,20):
        print("Case 2")
    default:
        print("case default")
}



var value = (10,20)
switch value
{
    case let(10,name): // 记得加 let
        print("10,\(name)") // 运行这个，并且不会再向下继续执行
    case (10,20):
        print("Case 2")
    default:
        print("case default")
}
