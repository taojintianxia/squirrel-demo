package io.taojintianxia.squirrel.demo.statemachine.factory;

import io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
import io.taojintianxia.squirrel.demo.enums.status.RuleSetStatusEnum;
import io.taojintianxia.squirrel.demo.statemachine.ArticleStateMachine;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 13:39
 */
public class ArticleStateMachineFactory {

    public static UntypedStateMachine getRuleSetStateMachine() {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(ArticleStateMachine.class);
        builder.externalTransition().from(RuleSetStatusEnum.NEW.getStatus()).to(RuleSetStatusEnum.PENDING_EVALUATION.getStatus())
                .on(ArticleEventEnum.EVALUATE).callMethod("updateStatus");

        return builder.newStateMachine(RuleSetStatusEnum.NEW.getStatus());
    }

    public static UntypedStateMachine getRuleSetStateMachineByStatus(String name) {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(ArticleStateMachine.class);
        return builder.newStateMachine(name);
    }

}
