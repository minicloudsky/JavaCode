<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Law APP</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="../js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../css/form-elements.css">
    <script src="../js/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap/js/bootstrap.min.js"></script>
	<script src="../js/jquery.backstretch.min.js"></script>
	<script src="../js/template.js"></script>
	<script src="../js/placeholder.js"></script>
</head>
<body>
<div class="container">
    <div class="header clearfix">
        <nav class="navbar navbar-default">
        <ul class="nav nav-pills nav-justified">
            <li role="presentation" class="active"><a href="#">Study</a></li>
            <li role="presentation" ><a href="#">Exam</a></li>
            <li role="presentation"><a href="#">Manager</a></li>
        </ul>
        </nav>
    </div>

    <div class="jumbotron">
        <div class="list-group clearfix" id="classify">
             <a  class="list-group-item active">宪法</a>
            <a  class="list-group-item">刑法</a>
            <a  class="list-group-item">民法</a>
            <a  class="list-group-item">经济法</a>
            <a  class="list-group-item">劳动法</a>
            <a  class="list-group-item">婚姻法</a>
            <a  class="list-group-item">行政法</a>
            <a  class="list-group-item">商法</a>
            <a  class="list-group-item">金融法</a>
            <a  class="list-group-item">税务法</a>
        </div>
        <div class="panel panel-defaul panel-content">
            <!-- Table -->
            <table class="table table-striped" id="table_list">
                <tr>
                    <th>#</th>
                    <th>name</th>
                    <th>edit</th>
                </tr>
            </table>
            <div class="text-center"><span class="study-add
             glyphicon glyphicon-plus" aria-hidden="true"></span></div>
        </div>
        <nav aria-label="Page navigation" class="text-center">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <footer class="footer text-center">
        <p>&copy; 2018 Edit By Sun.</p>
    </footer>

</div> <!-- /container -->
<script id="tableRow" type="text/html">
    {{if success}}
        {{each data as value i}}
	<tbody>
    <tr class="table_content">
        <td>{{i+1}}</td>
        <td>{{value.studyTitle}}</td>
        <td>
            <span class="glyphicon glyphicon-pencil" aria-hidden="true" id="update"></span>
            <span class="glyphicon glyphicon-remove" aria-hidden="true" id="delete"></span>
        </td>
	</tr>
	</tbody>
        {{/each}}
    {{/if}}
</script>
<script type="text/javascript">
    $(function () {
 		var hostUrl = "http://127.0.0.1:8080/ssm/";
        var httpprox = "../httpproxy/httpproxy.jsp?url=";
        var STUDY_GET_BY_CLASSIFY = hostUrl + "study/getByClassify?studyClassify="
        updateTable();

        function updateTable(){
            var selectedClassify = $("#classify .active").text().trim();
            var initDataUrl = STUDY_GET_BY_CLASSIFY + selectedClassify;
            $.ajax({
                type: "get",
                url: initDataUrl,
                dataType:"json",
                success: function (response) {
                    var studyHtml = template("tableRow",response);
                    $("tr").remove(".table_content"); 
                    $("#table_list").append(studyHtml);
                }
            });
        }

        $.each($("#classify a"),function (i,n) {
           $(this).click(function () {
               $.each($(this).siblings(),function (id,elem) {
                   $(this).removeClass("active");
               });
               $(this).addClass("active");
               updateTable();
           })
        });
        
        

    });
</script>
</body>
</html>