package com.kaishengit.util;


import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/18.
 */
public class DbHelp {


    private static Logger logger = LoggerFactory.getLogger(DbHelp.class);
    private static QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
    public void update(String sql,Object...params){
        try {
            queryRunner.update(sql,params);
            logger.debug("执行{}成功",sql);
        } catch (SQLException e) {
            logger.debug("执行{}成功",sql);
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }

    public <T> T query(String sql, ResultSetHandler<T> resultSetHandler,Object...params){
        T t=null;
        try {
            t = queryRunner.query(sql,resultSetHandler,params);
            logger.debug("执行{}成功",sql);
        } catch (SQLException e) {
            logger.debug("执行{}异常",sql);
            throw new DataAccessException("执行"+sql+"异常",e);
        }
        return t;
    }

}
