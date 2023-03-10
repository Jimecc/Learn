//
//  ViewController.swift
//  Demo03可选类型
//
//  Created by 和树坤 on 2023/3/10.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        var aInt:Int? = nil; // aInt 可能有值，也可能没有值，如果没有值的话就是一个nil
        var bInt:Int? = 10;
        print(aInt)
        print(bInt)
        print(bInt!)
        print(aInt ?? 100)
        // print(aInt!) // 闪退
        var a:Int? = nil;
        if a != nil{
            print(a)
        }else{
            print("没有值")
        }
        
    }


}

