package com.hjl.demo.service.impl;

import com.hjl.demo.service.StringService;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2019/1/22 11:24
 */
@Service
public class StringServiceImpl implements StringService {

    /**
     *
     * str1 and str2 on the same address
     * str1 and str3 on the same address
     * str2 and str3 on the same address
     */
    @Override
    public void addressAndValue() {
        String str1 = "a";
        String str2 = new String("a");
        String str3 = new String("a");

        if(str1==str2){
            System.out.println("equal in value");
        }

        if(str1.equals(str2)){
            System.out.println("str1 and str2 on the same address");
        }

        if(str1.equals(str3)){
            System.out.println("str1 and str3 on the same address");
        }

        if(str2.equals(str3)){
            System.out.println("str2 and str3 on the same address");
        }

        if(str2==str3){
            System.out.println("str2 and str3 on the same value");
        }
    }
}
