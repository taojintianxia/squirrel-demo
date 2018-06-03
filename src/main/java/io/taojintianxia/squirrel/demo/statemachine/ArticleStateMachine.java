package io.taojintianxia.squirrel.demo.statemachine;

import io.taojintianxia.squirrel.demo.bo.in.ArticleStatusUpdatingBO;
import io.taojintianxia.squirrel.demo.context.FsmContext;
import io.taojintianxia.squirrel.demo.enums.event.ArticleEventEnum;
import io.taojintianxia.squirrel.demo.service.ArticleService;
import io.taojintianxia.squirrel.demo.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
})
@StateMachineParameters(stateType = ArticleEventEnum.class, eventType = ArticleEventEnum.class, contextType = FsmContext.class)
public class ArticleStateMachine extends AbstractUntypedStateMachine {

    @Autowired
    ArticleService articleService;

    public int evaluate(String from, String to, ArticleEventEnum event, FsmContext fsmContext) {
        articleService.updateStatus(new ArticleStatusUpdatingBO());
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

}
