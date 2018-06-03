package io.taojintianxia.squirrel.demo.statemachine.factory;

import io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
import io.taojintianxia.squirrel.demo.enums.status.ArticleStatusEnum;
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
        builder.externalTransition().from(ArticleStatusEnum.NEW.getStatus()).to(ArticleStatusEnum.PENDING_EVALUATION.getStatus())
                .on(ArticleEventEnum.EVALUATE).callMethod("updateStatus");

        return builder.newStateMachine(ArticleStatusEnum.NEW.getStatus());
    }

    public static UntypedStateMachine getRuleSetStateMachineByStatus(String name) {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(ArticleStateMachine.class);
        return builder.newStateMachine(name);
    }

}
