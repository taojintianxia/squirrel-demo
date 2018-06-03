package io.taojintianxia.squirrel.demo.enums.status;

import com.google.common.base.Strings;
import lombok.Getter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 12:00
 */
@Getter
public enum RuleSetStatusEnum {
    NEW("新建", "1"),
    PENDING_EVALUATION("待评估", "2"),
    EVALUATION_SUCCESS("评估通过", "3"),
    EVALUATION_FAILED("评估未通过", "4");

    private String name;

    private String status;

    RuleSetStatusEnum(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public static String getNameByCode(String code) {
        if (Strings.isNullOrEmpty(code)) {
            return null;
        }

        RuleSetStatusEnum[] ruleSetStatusEnums = RuleSetStatusEnum.values();
        for (RuleSetStatusEnum ruleSetStatusEnum : ruleSetStatusEnums) {
            if (ruleSetStatusEnum.getStatus().equals(code)) {
                return ruleSetStatusEnum.getName();
            }
        }

        return null;
    }

}
