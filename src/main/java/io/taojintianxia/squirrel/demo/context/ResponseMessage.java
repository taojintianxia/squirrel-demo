package io.taojintianxia.squirrel.demo.context;

import lombok.Data;

/**
 * @author Nianjun Sun
 * @date 2018/6/3 19:00
 */

@Data
public class ResponseMessage<T> {

    private String code;

    private String message;

    private T data;

}
