package io.taojintianxia.squirrel.demo.context;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:54
 */

@Getter
@Setter
public class FsmContext<T> {

    private T data;

}
