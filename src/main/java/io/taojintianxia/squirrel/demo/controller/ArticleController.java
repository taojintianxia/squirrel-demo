package io.taojintianxia.squirrel.demo.controller;

import io.taojintianxia.squirrel.demo.bo.in.ArticleStatusUpdatingBO;
import io.taojintianxia.squirrel.demo.context.ResponseMessage;
import io.taojintianxia.squirrel.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2018/6/3 18:17
 */

@Slf4j
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/dict/listDictionaries")
    ResponseMessage listDictionaries(@RequestBody ArticleStatusUpdatingBO articleStatusUpdatingBO) {
        try {
            Boolean result = articleService.updateStatus(articleStatusUpdatingBO);
            return new ResponseMessage();
        } catch (Exception e) {
            log.error("got an error", e);
            return new ResponseMessage();
        }
    }

}
