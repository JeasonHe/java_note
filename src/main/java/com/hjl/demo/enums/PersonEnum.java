package com.hjl.demo.enums;

import lombok.Getter;

/**
 * Description :   .
 *
 * @author : hejiale
 * @date : Created in 2018/10/25 15:20
 */
public enum PersonEnum {
    PERSON("hjl", "hjl", 1);

    @Getter
    private String name;
    @Getter
    private String desc;
    @Getter
    private Integer code;

    PersonEnum(String name, String desc, Integer code) {
        this.name = name;
        this.desc = desc;
        this.code = code;
    }
}
