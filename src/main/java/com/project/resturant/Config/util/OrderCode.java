package com.project.resturant.Config.util;

import java.util.UUID;

public class OrderCode {
    public static String genrateCode(){
        return UUID.randomUUID().toString();
    }
}
