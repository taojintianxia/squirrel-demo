package io.taojintianxia.squirrel.demo;

import io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
import io.taojintianxia.squirrel.demo.enums.status.RuleSetStatusEnum;
import io.taojintianxia.squirrel.demo.statemachine.factory.ArticleStateMachineFactory;
import org.squirrelframework.foundation.fsm.StateMachine;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 14:13
 */
public class Application {

    public static void main(String... args) {
        StateMachine ruleSetMachine = ArticleStateMachineFactory.getRuleSetStateMachineByStatus
                (RuleSetStatusEnum.NEW.name());

        Object object = ruleSetMachine.test(ArticleEventEnum.EVALUATE, "ID");

    }

}
