package com.cvnchina.xingwanban.utils;

import com.google.gson.Gson;

/**
 * Created by hecuncun on 2020-5-16
 */
public class BeanUtils {
    public static <B> B modelA2B(Object modelA, Class<B> bClass) {
        try {
            Gson gson = new Gson();
            String gsonA = gson.toJson(modelA);
            B instanceB = gson.fromJson(gsonA, bClass);


            return instanceB;
        } catch (Exception e) {

            return null;
        }
    }

}
