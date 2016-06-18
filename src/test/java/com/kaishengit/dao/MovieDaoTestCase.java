package com.kaishengit.dao;

import com.kaishengit.entity.Movie;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/6/18.
 */
public class MovieDaoTestCase {

    @Test
    public void findAllTest(){

        MovieDao movieDao = new MovieDao();
        Assert.assertEquals(679,movieDao.findAll().size());

    }

}
