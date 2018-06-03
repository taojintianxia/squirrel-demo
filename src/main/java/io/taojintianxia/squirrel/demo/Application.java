package main.java.io.taojintianxia.squirrel.demo;

import main.java.io.taojintianxia.squirrel.demo.event.RuleSetEventEnum;
import main.java.io.taojintianxia.squirrel.demo.statemachine.factory.RuleSetStateMachineFactory;
import main.java.io.taojintianxia.squirrel.demo.status.RuleSetStatusEnum;
import org.squirrelframework.foundation.fsm.StateMachine;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 14:13
 */
public class Application {

    public static void main(String... args) {
        StateMachine ruleSetMachine = RuleSetStateMachineFactory.getRuleSetStateMachineByStatus
                (RuleSetStatusEnum.NEW.name());

        Object object = ruleSetMachine.test(RuleSetEventEnum.EVALUATE, "ID");
        System.out.println(object);

        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.DEPLOYED));
        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.EVALUATE));
        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.REJECT_EVALUATE));
        ruleSetMachine.fire(RuleSetEventEnum.EVALUATE,"");
        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.DEPLOYED));
        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.EVALUATE));
        System.out.println(ruleSetMachine.canAccept(RuleSetEventEnum.REJECT_EVALUATE));

    }

}
