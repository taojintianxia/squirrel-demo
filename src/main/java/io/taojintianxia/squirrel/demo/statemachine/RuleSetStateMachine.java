package main.java.io.taojintianxia.squirrel.demo.statemachine;

import main.java.io.taojintianxia.squirrel.demo.StateMachineRequestContext;
import main.java.io.taojintianxia.squirrel.demo.bo.RuleSetUpdateStatusInBO;
import main.java.io.taojintianxia.squirrel.demo.event.RuleSetEventEnum;
import main.java.io.taojintianxia.squirrel.demo.service.RuleSetService;
import main.java.io.taojintianxia.squirrel.demo.service.impl.RuleSetServiceImpl;
import main.java.io.taojintianxia.squirrel.demo.status.RuleSetStatusEnum;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:53
 */

@StateMachineParameters(stateType = String.class, eventType = RuleSetEventEnum.class,
        contextType = StateMachineRequestContext.class)
public class RuleSetStateMachine extends AbstractUntypedStateMachine {

    RuleSetService ruleSetService = new RuleSetServiceImpl();

    public int save(StateMachineRequestContext<String> stringStateMachineRequestContext) {
        return 0;
    }

    public boolean updateStatus(String from, String to, RuleSetEventEnum ruleSetEventEnum,
                                StateMachineRequestContext<RuleSetUpdateStatusInBO> statusInBOStateMachineRequestContext) {

        System.out.println("当前状态为 : " + RuleSetStatusEnum.getNameByCode(from));
        System.out.println("要更新到状态为 : " + RuleSetStatusEnum.getNameByCode(to));
        System.out.println("事件为 : " + ruleSetEventEnum.name());
        System.out.println("Context为 : " + statusInBOStateMachineRequestContext.getData());

        RuleSetUpdateStatusInBO ruleSetUpdateStatusInBO = statusInBOStateMachineRequestContext.getData();

        ruleSetService.updateStatus(ruleSetUpdateStatusInBO.getId(), ruleSetUpdateStatusInBO.getStatus());

        return false;
    }
}
