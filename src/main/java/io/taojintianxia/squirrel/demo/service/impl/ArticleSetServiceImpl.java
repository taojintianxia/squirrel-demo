package io.taojintianxia.squirrel.demo.service.impl;

import io.taojintianxia.squirrel.demo.enums.status.RuleSetStatusEnum;
import io.taojintianxia.squirrel.demo.service.ArticleSetService;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:59
 */
public class ArticleSetServiceImpl implements ArticleSetService {
    @Override
    public int save(String id) {
        System.out.println("当前Id为 : " + id);
        System.out.println("根据Id正在保存 ....");
        System.out.println("RuleSet已经保存成功 !");
        return 0;
    }

    @Override
    public boolean updateStatus(String id, String status) {
        System.out.println("当前Id是 : " + id);
        System.out.println("开始更新状态到 " + RuleSetStatusEnum.getNameByStatus(status));
        System.out.println("状态已经变更为 " + RuleSetStatusEnum.getNameByStatus(status));
        return true;
    }
}
