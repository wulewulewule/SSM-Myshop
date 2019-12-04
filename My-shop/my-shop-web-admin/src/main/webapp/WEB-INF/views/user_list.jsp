<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/leftmenu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理111</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info box-info-serach" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <form:form cssClass="form-horizontal" action="/user/search" method="post"
                                   modelAttribute="tbUser">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="username" class="col-sm-4 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <form:input path="username" cssClass="form-control " placeholder="姓名"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-4 control-label">邮箱</label>
                                            <div class="col-sm-8">
                                                <form:input path="email" cssClass="form-control " placeholder="邮箱"/>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-4 control-label">手机</label>
                                            <div class="col-sm-8">
                                                <form:input path="phone" cssClass="form-control " placeholder="手机"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">搜索</button>
                            </div>

                        </form:form>
                    </div>


                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row" style="padding-left: 13px; padding-top: 10px">
                                <a href="/user/form" type="button" class="btn  btn-default btn-sm"><i class="fa fa-fw fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm" onclick="deleteMulit();"><i class="fa fa-fw fa-trash-o"></i>删除</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-fw fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-fw fa-upload"></i>导出</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn  btn-primary btn-sm" onclick="$('.box-info-serach').css('display') == 'none' ? $('.box-info-serach').show('fast') : $('.box-info-serach').hide('fast')"><i class="fa fa-fw fa-search"></i>搜索</button>

                            </div>


                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"/></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="t">
                                    <tr>
                                        <td><input id="${t.id}" type="checkbox" class="minimal"/></td>
                                        <td>${t.id}</td>
                                        <td>${t.username}</td>
                                        <td>${t.phone}</td>
                                        <td>${t.email}</td>
                                        <td><fmt:formatDate value="${t.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td>
                                            <a href="#" type="button" class="btn  btn-default btn-sm"><i
                                                    class="fa fa-fw fa-search"></i>查看</a>&nbsp;&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn  btn-primary btn-sm"><i
                                                    class="fa fa-fw fa-edit"></i>编辑</a>&nbsp;&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn  btn-danger btn-sm"><i
                                                    class="fa fa-fw fa-trash"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>

        </section>


    </div>

    <jsp:include page="../includes/copyright.jsp"/>

</div>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">
                <p>您还没有选择任何数据，请至少选择一项&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="btnModalOk" type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<jsp:include page="../includes/footer.jsp"/>
<script>
    $(function () {
        $("#btnModalOk").bind("click",function () {
            $("#modal-default").modal("hide");
        })

    })
    /**
     * 批量删除
     */
    function deleteMulit() {

        //定义一个存放id的数组
        var idArray =new Array();

        //将选中元素的id放入数组中
        var _checkbox = Check.getCheckbox();
        _checkbox.each(function () {

            var _id =$(this).attr("id");
            if(_id != null && _id!= "undefine" && $(this).is(":checked")){
                idArray.push(_id);
            }

        });

        if(idArray.length === 0){
            $("#modal-default").modal("show");
        }
    }
</script>
</body>
</html>