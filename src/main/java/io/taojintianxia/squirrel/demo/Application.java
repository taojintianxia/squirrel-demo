package main.java.io.taojintianxia.squirrel.demo;

import main.java.io.taojintianxia.squirrel.demo.bo.RuleSetUpdateStatusInBO;
import main.java.io.taojintianxia.squirrel.demo.event.RuleSetEventEnum;
import main.java.io.taojintianxia.squirrel.demo.statemachine.factory.RuleSetStateMachineFactory;
import main.java.io.taojintianxia.squirrel.demo.status.RuleSetStatusEnum;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 14:13
 */
public class Application {

    public static void main(String... args) {
        UntypedStateMachine ruleSetMachine = RuleSetStateMachineFactory.getRuleSetStateMachine();
        StateMachineRequestContext<RuleSetUpdateStatusInBO> setUpdateStatusInBOStateMachineRequestContext = new
                StateMachineRequestContext<>();
        RuleSetUpdateStatusInBO ruleSetUpdateStatusInBO = new RuleSetUpdateStatusInBO();
        ruleSetUpdateStatusInBO.setId("aaaaa");
        ruleSetUpdateStatusInBO.setStatus(RuleSetStatusEnum.PENDING_EVALUATION.getCode());
        setUpdateStatusInBOStateMachineRequestContext.setData(ruleSetUpdateStatusInBO);

        ruleSetMachine.fire(RuleSetEventEnum.PENDING, setUpdateStatusInBOStateMachineRequestContext);
    }

}
