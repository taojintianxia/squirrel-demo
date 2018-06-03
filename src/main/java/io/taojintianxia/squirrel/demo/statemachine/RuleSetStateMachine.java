package main.java.io.taojintianxia.squirrel.demo.statemachine;

import main.java.io.taojintianxia.squirrel.demo.StateMachineRequestContext;
import main.java.io.taojintianxia.squirrel.demo.event.RuleSetEventEnum;
import main.java.io.taojintianxia.squirrel.demo.service.RuleSetService;
import main.java.io.taojintianxia.squirrel.demo.service.impl.RuleSetServiceImpl;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:53
 */

@Transitions({
        @Transit(from = "NEW", to = "PENDING_EVALUATION", on = "EVALUATE", callMethod = "evaluate"),
        @Transit(from = "PENDING_EVALUATION", to = "EVALUATION_SUCCESS", on = "PASS_EVALUATE", callMethod = "accept"),
        @Transit(from = "PENDING_EVALUATION", to = "EVALUATION_FAILED", on = "REJECT_EVALUATE", callMethod = "reject"),

        @Transit(from = "DEPLOYED", to = "EVALUATION_FAILED", on = "REJECT_EVALUATE"),
})
@StateMachineParameters(stateType = String.class, eventType = RuleSetEventEnum.class,
        contextType = String.class)
public class RuleSetStateMachine extends AbstractUntypedStateMachine {

    RuleSetService ruleSetService = new RuleSetServiceImpl();

    public int evaluate(String from, String to, RuleSetEventEnum ruleSetEventEnum, String re) {
        System.out.println("evaluating the rule set");
        return 0;
    }

    public int reject(StateMachineRequestContext<String> stringStateMachineRequestContext) {
        System.out.println("rejected the rule set");
        return 0;
    }

    public int accept(StateMachineRequestContext<String> stringStateMachineRequestContext) {
        System.out.println("passed the rule set");
        return 0;
    }

//    public boolean updateStatus(String from, String to, RuleSetEventEnum ruleSetEventEnum,
//                                StateMachineRequestContext<RuleSetUpdateStatusInBO> statusInBOStateMachineRequestContext) {
//
//        System.out.println("当前状态为 : " + RuleSetStatusEnum.getNameByCode(from));
//        System.out.println("要更新到状态为 : " + RuleSetStatusEnum.getNameByCode(to));
//        System.out.println("事件为 : " + ruleSetEventEnum.name());
//        System.out.println("Context为 : " + statusInBOStateMachineRequestContext.getData());
//
//        RuleSetUpdateStatusInBO ruleSetUpdateStatusInBO = statusInBOStateMachineRequestContext.getData();
//
//        ruleSetService.updateStatus(ruleSetUpdateStatusInBO.getId(), ruleSetUpdateStatusInBO.getStatus());
//
//        return false;
//    }
}
