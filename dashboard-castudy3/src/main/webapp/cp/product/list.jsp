<%@ page import="com.cg.untils.AppUntils" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Velonic - Responsive Admin Dashboard Template</title>
    <!-- third party css -->
    <link href="/assets/libs/datatables/dataTables.bootstrap4.css" rel="stylesheet" type="text/css">
    <link href="/assets/libs/datatables/responsive.bootstrap4.css" rel="stylesheet" type="text/css">
    <link href="/assets/libs/datatables/buttons.bootstrap4.css" rel="stylesheet" type="text/css">
    <link href="/assets/libs/datatables/select.bootstrap4.css" rel="stylesheet" type="text/css">
    <!-- third party css end -->

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
                            <h4 class="page-title">Welcome to Product !</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div>
                    <button type="button" class="btn btn-outline-success" style="float: right; margin: 15px"><a
                            style="text-decoration: none" href="/product?action=create"><i class="fa-solid fa-plus"></i>Create product</a></button>
                    <table class="table table-hover" style="margin-top: -20px">
                        <thead class="table-dark" style="color: white">
                        <th>Id</th>
                        <th>NameProduct</th>
                        <th>image</th>
                        <th>price</th>
                        <th>quantity</th>
                        <th>Category</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope['productList']}" var="item">
                            <tr>
                                <td>${item.getIdProduct()}</td>
                                <td>${item.getName()}</td>
                                <td ><img src="/assets/images/product/${item.getImage()}"  width="60px" height="60px"> </td>
                               <td>${item.getPrice()} </td>
                                <td>${item.getQuantity()}</td>
                                <td>${item.getCategory()}</td>

                                <td>
                                    <a href="/product?action=edit&id=${item.getIdProduct()}">
                                        <button type="button" class="btn btn-outline-success"><a
                                                style="text-decoration: none" href="/product?action=edit&id=${item.getIdProduct()}"><i
                                                class="fa-solid fa-pen-to-square"></i>Edit</a></button>
                                    </a>

                                    <a href="/product?action=delete&id=${item.getIdProduct()}">
                                        <button type="button" class="btn btn-outline-danger"><a
                                                style="text-decoration: none" href="/product?action=delete&id=${item.getIdProduct()}" onclick="return confirm('Bạn có muốn xoá sản phẩm dùng này');"><i
                                                class="fa-solid fa-trash-can"></i>Remove</a></button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
            <!-- container -->

        </div> <!-- content -->

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

<!-- Vendor js -->
<script src="/assets/js/vendor.min.js"></script>

<!-- third party js -->
<script src="/assets/libs/datatables/jquery.dataTables.min.js"></script>
<script src="/assets/libs/datatables/dataTables.bootstrap4.js"></script>
<script src="/assets/libs/datatables/dataTables.responsive.min.js"></script>
<script src="/assets/libs/datatables/responsive.bootstrap4.min.js"></script>
<script src="/assets/libs/datatables/dataTables.buttons.min.js"></script>
<script src="/assets/libs/datatables/buttons.bootstrap4.min.js"></script>
<script src="/assets/libs/datatables/buttons.html5.min.js"></script>
<script src="/assets/libs/datatables/buttons.flash.min.js"></script>
<script src="/assets/libs/datatables/buttons.print.min.js"></script>
<script src="/assets/libs/datatables/dataTables.keyTable.min.js"></script>
<script src="/assets/libs/datatables/dataTables.select.min.js"></script>
<script src="/assets/libs/pdfmake/pdfmake.min.js"></script>
<script src="/assets/libs/pdfmake/vfs_fonts.js"></script>
<!-- third party js ends -->

<!-- Datatables init -->
<script src="/assets/js/pages/datatables.init.js"></script>

<!-- App js -->
<script src="/assets/js/app.min.js"></script>

</body>
</html>