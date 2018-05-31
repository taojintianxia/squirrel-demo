package main.java.io.taojintianxia.squirrel.demo.service;

/**
 * @author Nianjun Sun
 * @date 2018/5/31 11:59
 */

public interface RuleSetService {

    int save(String id);

    boolean updateStatus(String status, String id);

}
