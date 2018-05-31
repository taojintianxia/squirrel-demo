package main.java.io.taojintianxia.squirrel.demo.statemachine.factory;

import main.java.io.taojintianxia.squirrel.demo.event.RuleSetEventEnum;
import main.java.io.taojintianxia.squirrel.demo.statemachine.RuleSetStateMachine;
import main.java.io.taojintianxia.squirrel.demo.status.RuleSetStatusEnum;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 13:39
 */
public class RuleSetStateMachineFactory {

    public static UntypedStateMachine getRuleSetStateMachine() {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(RuleSetStateMachine.class);
        builder.externalTransition().from(RuleSetStatusEnum.NEW.getCode()).to(RuleSetStatusEnum.PENDING_EVALUATION.getCode())
                .on(RuleSetEventEnum.PENDING).callMethod("updateStatus");

        return builder.newStateMachine(RuleSetStatusEnum.NEW.getCode());
    }

}
