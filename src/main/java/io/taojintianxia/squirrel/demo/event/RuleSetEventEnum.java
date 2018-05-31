package main.java.io.taojintianxia.squirrel.demo.event;

import lombok.Getter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 13:47
 */

@Getter
public enum RuleSetEventEnum {

    PENDING,
    EVALUATION_SUCCESS,
    EVALUATION_FAILED,
    DEPLOYED,
    LUNCHED,
    STOPPED

}
