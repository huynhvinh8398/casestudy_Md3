<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                                    <li class="breadcrumb-item active">user</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Welcome to users !</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div>
                    <button type="button" class="btn btn-outline-success" style="float: right; margin: 15px"><a
                            style="text-decoration: none" href="/users?action=create"><i class="fa-solid fa-plus"></i>Create
                        User</a></button>
                    <table class="table table-hover" style="margin-top: -20px">
                        <thead class="table-dark" style="color: white">
                        <th>Id</th>
                        <th>NameUser</th>
<%--                        <th>Password</th>--%>
                        <th>Fullname</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope['userList']}" var="item">
                            <tr>
                                <td>${item.getId()}</td>
                                <td>${item.getUsername()}</td>
<%--                                <td>${item.getPassword()}</td>--%>
                                <td>${item.getFullName()}</td>
                                <td>${item.getPhone()}</td>
                                <td>${item.getEmail()}</td>
                                <td>${item.getAddress()}</td>
                                <td>
                                    <a href="/users?action=edit&id=${item.getId()}">
                                        <button type="button" class="btn btn-outline-success"><a
                                                style="text-decoration: none" href="/users?action=edit&id=${item.getId()}"><i
                                                class="fa-solid fa-pen-to-square"></i>Edit</a></button>
                                    </a>
                                    <a href="/users?action=delete&id=${item.getId()}">
                                        <button type="button" class="btn btn-outline-danger"><a
                                                style="text-decoration: none" href="/users?action=delete&id=${item.getId()}" onclick="return confirm('Bạn có muốn xoá người dùng này');"><i
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