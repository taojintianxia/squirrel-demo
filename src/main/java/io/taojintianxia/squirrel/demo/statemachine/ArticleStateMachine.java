package io.taojintianxia.squirrel.demo.statemachine;

import io.taojintianxia.squirrel.demo.context.FsmContext;
import io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
import io.taojintianxia.squirrel.demo.service.ArticleService;
import io.taojintianxia.squirrel.demo.service.impl.ArticleServiceImpl;
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
@StateMachineParameters(stateType = String.class, eventType = ArticleEventEnum.class,
        contextType = String.class)
public class ArticleStateMachine extends AbstractUntypedStateMachine {

    ArticleService articleService = new ArticleServiceImpl();

    public int evaluate(String from, String to, ArticleEventEnum articleEventEnum, String re) {
        System.out.println("evaluating the rule set");
        return 0;
    }

    public int reject(FsmContext<String> stringFsmContext) {
        System.out.println("rejected the rule set");
        return 0;
    }

    public int accept(FsmContext<String> stringFsmContext) {
        System.out.println("passed the rule set");
        return 0;
    }

//    public boolean updateStatus(String from, String to, ArticleEventEnum ruleSetEventEnum,
//                                FsmContext<ArticleStatusUpdatingBO> statusInBOStateMachineRequestContext) {
//
//        System.out.println("当前状态为 : " + RuleSetStatusEnum.getNameByStatus(from));
//        System.out.println("要更新到状态为 : " + RuleSetStatusEnum.getNameByStatus(to));
//        System.out.println("事件为 : " + ruleSetEventEnum.name());
//        System.out.println("Context为 : " + statusInBOStateMachineRequestContext.getData());
//
//        ArticleStatusUpdatingBO ruleSetUpdateStatusInBO = statusInBOStateMachineRequestContext.getData();
//
//        articleService.updateStatus(ruleSetUpdateStatusInBO.getId(), ruleSetUpdateStatusInBO.getStatus());
//
//        return false;
//    }
}
