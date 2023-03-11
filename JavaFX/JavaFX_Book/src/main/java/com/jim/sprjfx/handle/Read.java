package com.jim.sprjfx.handle;

/**
 * @author zzy
 * @Description 读取数字
 * @createTime 2022年12月11日
 */
public class Read {

    public static int Int(String s){
        int result = 0;
        if("".equals(s)){
            return -1;
        }
        try{
            result = Integer.parseInt(s);
            return result;
        }catch (Exception e){
            return -2;
        }

    }
}
