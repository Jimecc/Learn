//
//  ViewController.swift
//  Demo04元组类型
//
//  Created by 和树坤 on 2023/3/10.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        var a=(1,2,3,"Hello World") // 不明确指定
        print(a)
        print(a.0)
        print(a.3)
        
        var b:(Int,Bool,String) = (1,true,"Hello World")
        print(b.1)
        print(b.0 = 100)
        print(b.0)
        
        var c = () // 没什么大用
        
        var yza = (1,2,3,4)
        var yzb = yza
        yzb.1=100
        print(yza.1)
        print(yzb.1)
        
        var yzc:(name:String,age:Int) = ("张三",20)
        print(yzc.name)
        
        let (name1,_,age1) = ("张三",true,100)
        print(name1)
        print(age1)
    }


}

