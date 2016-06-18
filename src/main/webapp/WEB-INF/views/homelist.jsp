<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homelist</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin: 30px auto">
    <h2>电影列表</h2>
    <div class="bs-example" data-example-id="hoverable-table">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>电影名称</th>
                <th>发行时间</th>
                <th>评分</th>
                <th>导演</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${moviePage.items}" var="movie">
                <tr>
                    <th width="50px">${movie.id}</th>
                    <td width="400px">${movie.title}</td>
                    <td width="100px">${movie.sendtime}</td>
                    <td width="50px">${movie.rate}</td>
                    <td width="150px">${movie.daoyan}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <div class="bs-example" data-example-id="simple-pagination">
            <nav>
                <ul class="pagination" id="page">

                    <%--<c:choose>--%>
                        <%--<c:when test="${moviePage.pageNo==1}">--%>
                            <%--<li class="disabled">--%>
                                <%--<a href="/home?p=1" aria-label="Previous">--%>
                                    <%--<span aria-hidden="true">首页</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li class="disabled"><a href="/home?p=${moviePage.pageNo-1}">上一页</a></li>--%>
                        <%--</c:when>--%>

                        <%--<c:when test="${moviePage.pageNo!=1}">--%>

                            <%--<li>--%>
                                <%--<a href="/home?p=1" aria-label="Previous">--%>
                                    <%--<span aria-hidden="true">首页</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="/home?p=${moviePage.pageNo-1}">上一页</a></li>--%>

                        <%--</c:when>--%>

                    <%--</c:choose>--%>
                    <%--<c:choose>--%>
                        <%--<c:when test="${moviePage.pageNo==moviePage.totalPageSize}">--%>
                            <%--<li class="disabled"><a href="/home?p=${moviePage.pageNo+1}">下一页</a></li>--%>
                            <%--<li class="disabled">--%>
                                <%--<a href="/home?p=${moviePage.totalPageSize}" aria-label="Next">--%>
                                    <%--<span aria-hidden="true">末页</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                        <%--</c:when>--%>
                        <%--<c:when test="${moviePage.pageNo!=moviePage.totalPageSize}">--%>
                            <%--<li><a href="/home?p=${moviePage.pageNo+1}">下一页</a></li>--%>
                            <%--<li>--%>
                                <%--<a href="/home?p=${moviePage.totalPageSize}" aria-label="Next">--%>
                                    <%--<span aria-hidden="true">末页</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                        <%--</c:when>--%>

                    <%--</c:choose>--%>

                </ul>
            </nav>
        </div>
    </div>
</div>
<script src="/static/JQuery/jquery-1.11.3.min.js"></script>
<script src="/static/JQuery/jquery.twbsPagination.min.js"></script>
<script>

    $(function(){
        $("#page").twbsPagination({
            totalPages:${moviePage.totalPageSize},
            visiblePages:10,
            first:'首页',
            pre:'上一页',
            next:'下一页',
            last:'尾页',
            href:'?p={{number}}'

        });
    });

</script>
</body>
</html>
