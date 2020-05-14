package com;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YCKJ1409
 *
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String, File> fileConcurrentHashMap = new ConcurrentHashMap<>(2);
        File file = new File("");
        fileConcurrentHashMap.put("1",file);
        Iterator<String> iterator = fileConcurrentHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
