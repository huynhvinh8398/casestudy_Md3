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
            errors.add("Email đã tồn tại vui lòng nhập email khác");
        }
        if (exitsPhone) {
            errors.add("Phone đã tồn tại vui lòng nhập phone khác");
        }
            if (!isPhone) {
                errors.add("Số điện thoại sai định dạng (gồm 10 số và bắt đầu bằng số 0)");
            }
            if (!isEmail) {
                errors.add("email sai định dạng (vd: vinhhuynh123@gmail.com)"); //có thể bao gồm dấu chấm và dấu gạch dưới không gồm các kí tự đặc biệt
            }
            if (!isUsername) {
                errors.add("username sai định dạng (bắt đầu bằng chữ cái thường tối thiếu 3 và < 16 kí tự)");
            }
            if (!isPassword) {
                errors.add("mật khẩu sai định dạng (Tối thiểu 8 kí tự, ít nhất 1 chữ,1 số và 1 kí tự đặc biệt)");
            }
            if (fullname.equals("") ||
                    username.equals("") ||
                    password.equals("") ||
                    phone.equals("") ||
                    email.equals("") ||
                    address.equals("")) {
                errors.add("Không được để trống Phải nhập đầy đủ thông tin");
            }
            if (fullname.equals("")) {
                errors.add("fullname không được để trống");
            }
            if (username.equals("")) {
                errors.add("username không được để trống");
            }
            if (password.equals("")) {
                errors.add("password không được để trống");
            }
            if (phone.equals("")) {
                errors.add("phone không được để trống");
            }
            if (email.equals("")) {
                errors.add("email không được để trống");
            }
            if (password.equals("")) {
                errors.add("password không được để trống");
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
//                errors.add("Thêm user thất bại");
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
            errors.add("Số điện thoại không hợp lệ");
        }
        if (!isEmail) {
            errors.add("email không hợp lệ");
        }
//      User  user = new User(fullname,username, password, phone, email, address);
        if (fullName.equals("") ||
                username.equals("") ||
                phone.equals("") ||
                email.equals("") ||
                address.equals("")) {
            errors.add("Không được để trống Phải nhập đầy đủ thông tin");
        }
        if (fullName.equals("")) {
            errors.add("fullname không được để trống");
        }
        if (username.equals("")) {
            errors.add("username không được để trống");
        }
        if (phone.equals("")) {
            errors.add("phone không được để trống");
        }
        if (email.equals("")) {
            errors.add("email không được để trống");
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
//            errors.add("Cập nhật user thất bại");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
        }
        dispatcher.forward(req, resp);

    }
}
