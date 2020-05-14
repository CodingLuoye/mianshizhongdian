package com.self.jvm;

import java.util.ArrayList;
import java.util.List;

/**
*VM Args：-XX:PermSize=10M-XX:MaxPermSize=10M jdk1.8无效
 * 改为-XX:MetaspaceSize=1M-XX:MaxMetaspaceSize=1M
*@author YCKJ1409
*/
public class RuntimeConstantPoolOOM{
    public static void main(String[] args){
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list=new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
