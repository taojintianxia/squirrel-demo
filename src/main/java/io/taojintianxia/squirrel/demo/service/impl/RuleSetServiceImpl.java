package main.java.io.taojintianxia.squirrel.demo.service.impl;

import main.java.io.taojintianxia.squirrel.demo.service.RuleSetService;
import main.java.io.taojintianxia.squirrel.demo.status.RuleSetStatusEnum;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:59
 */
public class RuleSetServiceImpl implements RuleSetService {
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
        System.out.println("开始更新状态到 " + RuleSetStatusEnum.getNameByCode(status));
        System.out.println("状态已经变更为 " + RuleSetStatusEnum.getNameByCode(status));
        return true;
    }
}
