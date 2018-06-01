package main.java.io.taojintianxia.squirrel.demo.event;

import lombok.Getter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 13:47
 */

@Getter
public enum RuleSetEventEnum {

    EVALUATE,
    PASS_EVALUATE,
    REJECT_EVALUATE,
    DEPLOYED,
    LUNCHED,
    STOPPED

}
