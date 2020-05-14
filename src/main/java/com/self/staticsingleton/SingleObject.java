package com.self.staticsingleton;
/**
 * 懒汉式单例
 */
public class SingleObject {

    private static volatile SingleObject instance;

    private SingleObject(){

    }

    public static SingleObject getInstance(){
        if(instance == null){
            synchronized (SingleObject.class){
                if(instance == null){
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingleObject singleObject1 = SingleObject.getInstance();

        SingleObject singleObject2 = SingleObject.getInstance();

        System.out.println(singleObject1.hashCode() + " ==== "+ singleObject2.hashCode());

        System.out.println(singleObject1.equals(singleObject2));

    }

}
