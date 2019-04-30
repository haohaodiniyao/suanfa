package com.suanfa.example;

import java.util.Stack;

/**
 * 计算字符串算数表达式的值（包含左右括号/运算符/数字）使用空格分割
 */
public class Evaluate {
    public static void main(String[] args){
        String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] strs = str.split(" ");
        System.out.println(calculate(strs));
    }
    private static double calculate(String[] strs){
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            if("(".equals(str)){

            }else if("+".equals(str)){
                ops.push(str);
            }else if("-".equals(str)){
                ops.push(str);
            }else if("*".equals(str)){
                ops.push(str);
            }else if("/".equals(str)){
                ops.push(str);
            }else if(")".equals(str)){
                Double v = vals.pop();
                String op = ops.pop();
                if("+".equals(op)){
                    v = vals.pop() + v;
                }else if("-".equals(op)){
                    v = vals.pop() - v;
                }else if("*".equals(op)){
                    v = vals.pop() * v;
                }else if("/".equals(op)){
                    v = vals.pop() / v;
                }
                vals.push(v);
            }else{
                vals.push(Double.parseDouble(str));
            }
        }
        return vals.pop();
    }
}
