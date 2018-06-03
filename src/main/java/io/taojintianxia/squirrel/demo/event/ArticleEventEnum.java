package main.java.io.taojintianxia.squirrel.demo.event;

import lombok.Getter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 13:47
 */

@Getter
public enum ArticleEventEnum {

    /**
     * 删除作品
     */
    DELETE,

    /**
     * 编辑作品
     */
    EDIT,

    /**
     * 作品评估
     */
    EVALUATE,

    /**
     * 评估通过
     */
    PASS_EVALUATION,

    /**
     * 评估未通过
     */
    REJECT_EVALUATION

}
