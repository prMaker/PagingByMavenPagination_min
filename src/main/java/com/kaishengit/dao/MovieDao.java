package com.kaishengit.dao;

import com.kaishengit.entity.Movie;
import com.kaishengit.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class MovieDao {

    private DbHelp dbHelp = new DbHelp();

    public List<Movie> findByPage(Integer start,Integer pageSize){
        String sql = "select * from `movie` limit ?,?";
        return dbHelp.query(sql,new BeanListHandler<>(Movie.class),start,pageSize);
    }

    public Long count(){
        String sql = "select count(*) from `movie`";
        return dbHelp.query(sql,new ScalarHandler<Long>());
    }
}
