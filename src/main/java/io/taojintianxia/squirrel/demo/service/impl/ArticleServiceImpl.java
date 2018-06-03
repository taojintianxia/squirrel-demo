package io.taojintianxia.squirrel.demo.service.impl;

import io.taojintianxia.squirrel.demo.bo.in.ArticleStatusUpdatingBO;
import io.taojintianxia.squirrel.demo.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:59
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public int save(String id) {
        System.out.println("当前Id为 : " + id);
        System.out.println("根据Id正在保存 ....");
        System.out.println("RuleSet已经保存成功 !");
        return 0;
    }

    @Override
    public boolean updateStatus(ArticleStatusUpdatingBO articleStatusUpdatingBO) {
        return false;
    }

}
