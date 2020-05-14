package com.self.enumconn;

/**
 * @author YCKJ1409
 * 枚举的本质是个类
 */
public enum  BetterEnum{
    PLUS{
        @Override
        double oper(double x,double y){
            return x+y;
        }
    },
    ADD{
        @Override
        double oper(double x, double y) {
            return x + y;
        }
    };
    abstract double oper(double x, double y);
}
