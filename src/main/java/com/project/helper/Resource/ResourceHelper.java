package com.project.helper.Resource;

/**
 * Created by Asit.Singh on 06-05-2019.
 */
public class ResourceHelper {
    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        return basePath +"/"+ path;
    }
}
