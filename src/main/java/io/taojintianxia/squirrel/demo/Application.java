package main.java.io.taojintianxia.squirrel.demo;

import main.java.io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
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

        Object object = ruleSetMachine.test(ArticleEventEnum.EVALUATE, "ID");

    }

}
