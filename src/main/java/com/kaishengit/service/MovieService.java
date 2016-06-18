package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class MovieService {
    private MovieDao movieDao = new MovieDao();

    public Page<Movie> listByPage(Integer pageNo){
        int count = movieDao.count().intValue();
        Page<Movie> page = new Page<>(count,10,pageNo);
        List<Movie> movieList = movieDao.findByPage(page.getStart(),10);
        page.setItems(movieList);
        return page;
    }
}
