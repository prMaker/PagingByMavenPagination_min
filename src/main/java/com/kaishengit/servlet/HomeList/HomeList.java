package com.kaishengit.servlet.HomeList;

import com.kaishengit.entity.Movie;
import com.kaishengit.entity.Page;
import com.kaishengit.service.MovieService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */

@WebServlet("/home")
public class HomeList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageNo = req.getParameter("p");
        int p = 1;
        if(StringUtils.isNumeric(pageNo)){
            p = Integer.parseInt(pageNo);
        }
        MovieService movieService = new MovieService();
        Page<Movie> moviePage = movieService.listByPage(p);
        req.setAttribute("moviePage",moviePage);
        req.getRequestDispatcher("/WEB-INF/views/homelist.jsp").forward(req,resp);
    }
}
