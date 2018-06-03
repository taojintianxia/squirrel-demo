package io.taojintianxia.squirrel.demo.enums.status;

import com.google.common.base.Strings;
import lombok.Getter;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 12:00
 */
@Getter
public enum ArticleStatusEnum {

    NEW("新建", "1"),
    PENDING_EVALUATION("待评估", "2"),
    EVALUATION_SUCCESS("评估通过", "3"),
    EVALUATION_FAILED("评估未通过", "4");

    private String name;

    private String status;

    ArticleStatusEnum(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public static String getNameByStatus(String status) {
        if (Strings.isNullOrEmpty(status)) {
            return null;
        }

        ArticleStatusEnum[] articleStatusEnums = ArticleStatusEnum.values();
        for (ArticleStatusEnum articleStatusEnum : articleStatusEnums) {
            if (articleStatusEnum.getStatus().equals(status)) {
                return articleStatusEnum.getName();
            }
        }

        return null;
    }

    public static ArticleStatusEnum getByStatus(String status) {
        if (Strings.isNullOrEmpty(status)) {
            return null;
        }

        ArticleStatusEnum[] articleStatusEnums = ArticleStatusEnum.values();
        for (ArticleStatusEnum articleStatusEnum : articleStatusEnums) {
            if (status.equals(articleStatusEnum.getStatus())) {
                return articleStatusEnum;
            }
        }

        return null;
    }
}
