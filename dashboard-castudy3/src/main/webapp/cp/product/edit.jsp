
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
                                    <li class="breadcrumb-item active">Product</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Welcome to Edit Product!</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

            </div> <!-- container -->

        </div>
        <!-- content -->
        <div>
            <form method="post"  >
                <div class="form-row">
                    <div class="col-6 col-sm-6 form-group">
                        <label for="productName" class="form-label">Product name</label>
                        <input type="text" class="form-control" id="productName" name="productName" placeholder="Nhập Product name">
                    </div>
                    <div class="col-6 col-sm-6 form-group">
                        <label for="file" class="form-label">Image</label>
                        <input type="file" id="file" class="form-control-file" name="file"   >
                    </div>
                    <div class="col-6 col-sm-6 form-group">
                        <label for="price" class="form-label">Price</label>
                        <input type="number" class="form-control" id="price" name="price" placeholder="Nhập price" value="0">
                    </div>
                    <div class="col-6 col-sm-6 form-group">
                        <label for="quantity" class="form-label">Quantity</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Nhập quantity" value="1">
                    </div>
                    <div class="col-6 col-sm-6 form-group">
                        <label for="Category" class="form-label">Category</label>
                        <input type="text" class="form-control"  id="Category" name="Category" placeholder="Nhập thể loại">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary"  >Edit</button>
            </form>
        </div>
        <div class="row">
            <div class="col-12" style="margin: 5px">
                <c:if test="${requestScope['success'] == true}">
                <span class="alert alert-success col-3"
                      role="alert" style="width: 50%;text-align: center; display: block "   >Cập nhật thành công </span>
                </c:if>
            </div>
            <c:forEach items="${requestScope['errors']}" var="err">
                <div class="alert alert-danger col-3" role="alert" style="width: 50%;text-align: center">${err}</div>
            </c:forEach>
        </div>
    </div>
    </div>

</div>
<!-- Footer Start -->
<%@ include file="/cp/layout/footer.jsp" %>
<!-- end Footer -->

</div>

<!-- ============================================================== -->
<!-- End Page content -->
<!-- ============================================================== -->


</div>
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
