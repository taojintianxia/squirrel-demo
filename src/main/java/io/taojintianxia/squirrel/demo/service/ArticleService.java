package io.taojintianxia.squirrel.demo.service;

import io.taojintianxia.squirrel.demo.bo.in.ArticleStatusUpdatingBO;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:59
 */

public interface ArticleService {

    int save(String id);

    boolean updateStatus(ArticleStatusUpdatingBO articleStatusUpdatingBO);

}
