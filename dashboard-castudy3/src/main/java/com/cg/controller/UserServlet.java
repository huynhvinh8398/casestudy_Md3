package com.cg.controller;


import com.cg.model.User;
import com.cg.service.UserService;
import com.cg.untils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(req, resp);
                break;
            case "edit":
                showEditPage(req, resp);
                break;
            case "list":
                showListPage(req, resp);
                break;
            case "delete":
                doRemove(req, resp);
                break;
            default:
                showListPage(req, resp);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("doPost..............");

        System.out.println("doPostedit..............");
        System.out.println("remove..............");


        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            case "edit":
                doUpdate(req, resp);
                break;
//            case "delete":
//                doRemove(req,resp);
//                break;
        }
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        userService.remove(id);

        List<User> listUser = userService.findAll();
        req.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/users?action=users");
        dispatcher.forward(req, resp);
    }


    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/users.jsp");
        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);

        dispatcher.forward(req, resp);
    }

    public void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/create.jsp");

        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);

        dispatcher.forward(req, resp);
    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        long id = Long.parseLong(req.getParameter("id"));

        User user = userService.findById(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/edit.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }


    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/create.jsp");
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String fullname = req.getParameter("fullName").trim();
        String phone = req.getParameter("phone").trim();
        String email = req.getParameter("email").trim();
        String address = req.getParameter("address").trim();

        List<String> errors = new ArrayList<>();

        boolean isEmail = ValidateUtils.isEmailValid(email);
        boolean isPhone = ValidateUtils.isPhoneValid(phone);
        boolean isUsername = ValidateUtils.isUsernameValid(username);
        boolean isPassword = ValidateUtils.isPasswordvalid(password);
        boolean exitsEmail = userService.existsByEmail(email);
        boolean exitsPhone = userService.existsByPhone(phone);
        if (exitsEmail) {
            errors.add("Email ??a?? t????n ta??i vui lo??ng nh????p email kha??c");
        }
        if (exitsPhone) {
            errors.add("Phone ??a?? t????n ta??i vui lo??ng nh????p phone kha??c");
        }
            if (!isPhone) {
                errors.add("S??? ??i???n tho???i sai ?????nh d???ng (g???m 10 s??? v?? b???t ?????u b???ng s??? 0)");
            }
            if (!isEmail) {
                errors.add("email sai ?????nh d???ng (vd: vinhhuynh123@gmail.com)"); //c?? th??? bao g???m d???u ch???m v?? d???u g???ch d?????i kh??ng g???m c??c k?? t??? ?????c bi???t
            }
            if (!isUsername) {
                errors.add("username sai ?????nh d???ng (b???t ?????u b???ng ch??? c??i th?????ng t???i thi???u 3 v?? < 16 k?? t???)");
            }
            if (!isPassword) {
                errors.add("m???t kh???u sai ?????nh d???ng (T???i thi???u 8 k?? t???, ??t nh???t 1 ch???,1 s??? v?? 1 k?? t??? ?????c bi???t)");
            }
            if (fullname.equals("") ||
                    username.equals("") ||
                    password.equals("") ||
                    phone.equals("") ||
                    email.equals("") ||
                    address.equals("")) {
                errors.add("Kh??ng ???????c ????? tr???ng Ph???i nh???p ?????y ????? th??ng tin");
            }
            if (fullname.equals("")) {
                errors.add("fullname kh??ng ???????c ????? tr???ng");
            }
            if (username.equals("")) {
                errors.add("username kh??ng ???????c ????? tr???ng");
            }
            if (password.equals("")) {
                errors.add("password kh??ng ???????c ????? tr???ng");
            }
            if (phone.equals("")) {
                errors.add("phone kh??ng ???????c ????? tr???ng");
            }
            if (email.equals("")) {
                errors.add("email kh??ng ???????c ????? tr???ng");
            }
            if (password.equals("")) {
                errors.add("password kh??ng ???????c ????? tr???ng");
            }
            boolean success = false;

            if (errors.size() == 0) {
                User user = new User(username, password, phone, fullname, email, address);
                System.out.println("User info: " + user);
                success = userService.create(user);
            }
            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
//                errors.add("Th??m user th???t b???i");
            }
            if (errors.size() > 0) {
                req.setAttribute("errors", errors);
            }
            dispatcher.forward(req, resp);

        }


    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/edit.jsp");
        long id = Long.parseLong(req.getParameter("id"));
        String username = req.getParameter("username");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");


        List<String> errors = new ArrayList<>();

        boolean isEmail = ValidateUtils.isEmailValid(email);
        boolean isPhone = ValidateUtils.isPhoneValid(phone);
        if (!isPhone) {
            errors.add("S??? ??i???n tho???i kh??ng h???p l???");
        }
        if (!isEmail) {
            errors.add("email kh??ng h???p l???");
        }
//      User  user = new User(fullname,username, password, phone, email, address);
        if (fullName.equals("") ||
                username.equals("") ||
                phone.equals("") ||
                email.equals("") ||
                address.equals("")) {
            errors.add("Kh??ng ???????c ????? tr???ng Ph???i nh???p ?????y ????? th??ng tin");
        }
        if (fullName.equals("")) {
            errors.add("fullname kh??ng ???????c ????? tr???ng");
        }
        if (username.equals("")) {
            errors.add("username kh??ng ???????c ????? tr???ng");
        }
        if (phone.equals("")) {
            errors.add("phone kh??ng ???????c ????? tr???ng");
        }
        if (email.equals("")) {
            errors.add("email kh??ng ???????c ????? tr???ng");
        }
        boolean success = false;
        if (errors.size() == 0) {
            User user = new User(id, username, fullName, phone, email, address);
            System.out.println("User info: " + user);
            success = userService.update(user);
        }
        if (success) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("errors", true);
//            errors.add("C???p nh???t user th???t b???i");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
        }
        dispatcher.forward(req, resp);

    }
}
