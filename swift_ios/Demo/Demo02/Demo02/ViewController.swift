//
//  ViewController.swift
//  Demo02
//
//  Created by 和树坤 on 2023/3/10.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        typealias dog = Int
        var a:dog = 1
        var b:dog = 2
        print(a+b)
        
        var aInt = 10;
        print("aInt:\(aInt)")
        print("aInt:"+String(aInt))
        var aStringInt:String = "10"
        print(Int(aStringInt)) // Optional(10)
        print(Int("Hello world")); // nil
        print(Int("Hello world") ?? 100); // 100 有点类似三目运算法则
        
        print(Double(1))
        print(Int(1.1))
        print(Bool(1))
    }


}

