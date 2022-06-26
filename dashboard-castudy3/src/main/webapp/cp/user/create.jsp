
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Velonic - Responsive Admin Dashboard Template</title>
    <link rel="stylesheet" href="/assets/css/style.css">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">

    <%@ include file="/cp/layout/header.jsp" %>
</head>

<body>

<!-- Begin page -->
<div id="wrapper">

    <!-- Topbar Start -->
    <%@ include file="/cp/layout/navbar.jsp" %>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <div class="left-side-menu">

        <div class="slimscroll-menu">

            <!--- Sidemenu -->
            <div id="sidebar-menu">

                <%@ include file="/cp/layout/sidebar-left.jsp" %>

            </div>
            <!-- End Sidebar -->

            <div class="clearfix"></div>

        </div>
        <!-- Sidebar -left -->

    </div>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Velonic</a></li>
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Welcome to Create User!</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

            </div> <!-- container -->

        </div>

        <!-- content -->
     <div>
       <form method="post">
        <div class="form-row">
            <div class="col-6 col-sm-6 form-group">
                <label for="fullName" class="form-label">FUll name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Nhập Fullname">
            </div>
            <div class="col-6 col-sm-6 form-group">
                <label for="username" class="form-label">User name</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Nhập username">
            </div>
            <div class="col-6 col-sm-6 form-group">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="Nhập password">
            </div>
            <div class="col-6 col-sm-6 form-group">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Nhập số điện thoại">
            </div>
            <div class="col-6 col-sm-6 form-group">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control"  id="email" name="email" placeholder="Nhập email">
            </div>
            <div class="col-6 col-sm-6 form-group">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Nhập address">
            </div>
        </div>
           <button type="submit" class="btn btn-primary"  >Create</button>
        </form>
     </div>

<%--        <div class="foter">--%>
        <div class="row">
            <div class="col-12" style="margin: 5px">
                <c:if test="${requestScope['success'] == true}">
                <div class="alert alert-success col-3"
                      role="alert" style="width: 50%;text-align: center "  >Thêm mới thành công </div>
                </c:if>
            </div>
            <c:forEach items="${requestScope['errors']}" var="err">
                <div class="alert alert-danger col-3" role="alert" style="width: 50%;text-align: center">${err}</div>
            </c:forEach>
        </div>
    </div>
<%--        </div>--%>
    </div>

</div>
        <!-- Footer Start -->
        <%@ include file="/cp/layout/footer.jsp" %>
        <!-- end Footer -->

<%--    </div>--%>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->


<%--</div>--%>
<!-- END wrapper -->

<!-- Right Sidebar -->
<%@ include file="/cp/layout/rightbar.jsp" %>
<!-- /Right-bar -->

<!-- Right bar overlay-->
<div class="rightbar-overlay"></div>

<%@ include file="/cp/layout/script.jsp" %>
<script rel="stylesheet" src="/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
