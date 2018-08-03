package com.self.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurableStrategyDemo {
	public static IService createService(){
		IService service = null;
		try {
			Properties prop = new Properties();
			System.out.println(ConfigurableStrategyDemo.class.getResource(""));
			System.out.println(ConfigurableStrategyDemo.class.getResource("/"));
			System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
			System.out.println(ConfigurableStrategyDemo.class.getClassLoader().getResource(""));
			System.out.println(ClassLoader.getSystemResource(""));
			System.out.println(System.getProperty("user.dir"));
			
			String fileName = "G:\\workplace_newsphere\\mianshizhongdian\\src\\main\\java\\com\\self\\classLoader\\config.properties";
			System.out.println(fileName);
			File file = new File(fileName);
			if(!file.exists()){
				throw new RuntimeException("要读取的文件不存在");
			}
			//创建文件字节读取流对象时，必须明确与之关联的数据源。
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			String className = prop.getProperty("service");
			Class<?> cls = Class.forName(className);
			service=  (IService)cls.newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return service;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IService service = createService();
		service.action();
	}

}
