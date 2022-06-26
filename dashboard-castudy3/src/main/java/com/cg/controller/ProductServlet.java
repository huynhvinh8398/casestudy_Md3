package com.cg.controller;


import com.cg.model.Product;
import com.cg.model.User;
import com.cg.service.ProductService;
import com.cg.untils.AppUntils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
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
                doRemove(req,resp);
                break;
            default:
                showListPage(req, resp);
                break;

        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("doPost..............");

        System.out.println("doPostedit..............");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create" :
                doCreate(req, resp);
                break;
            case "edit" :
             doUpdate(req,resp);
                break;

        }
    }
    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/list.jsp");

        List<Product> productList = productService.findAll();
        req.setAttribute("productList", productList);

        dispatcher.forward(req, resp);
    }
    public void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/create.jsp");

        List<Product> productList = productService.findAll();
        req.setAttribute("productList", productList);

        dispatcher.forward(req, resp);
    }
    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/edit.jsp");
        req.setAttribute("product",product);
        dispatcher.forward(req, resp);
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("nhảy vào đây");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/create.jsp");
        String productName = req.getParameter("productName").trim();
        double price = Double.parseDouble(req.getParameter("price").trim());
        int quantity = Integer.parseInt(req.getParameter("quantity").trim());
        String Category = req.getParameter("Category").trim();
        String image = req.getParameter("file").trim();
        AppUntils.doubleToVND(price);

        List<String> errors = new ArrayList<>();


        if (price <=0){
            errors.add("giá sản phẩm phải lớn hơn 0 không được âm");
        }
        if (price >999999999){
            errors.add("giá sản phẩm vượt giới hạn cho phép");
        }
        if (productName.equals("")){
            errors.add("tên sản phẩm không được để trống");
        }
         if (image.equals("")){
             errors.add("ảnh sản phẩm chưa được chọn");
         }
         if (quantity<=0 && quantity < 99){
             errors.add("số lượng ít nhất là 1 và nhỏ hơn 99");
         }
       boolean success = false;
        if (errors.size()==0) {
            Product product = new Product(productName, price, quantity, Category, image);
            System.out.println("product info: " + product);
            success = productService.create(product);
        }

        if (success) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("errors", true);
//            errors.add("Thêm sản phẩm thất bại");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
        }
        dispatcher.forward(req, resp);
    }
    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/edit.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        String productName = req.getParameter("productName");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String Category = req.getParameter("Category");
        String image = req.getParameter("file");

        List<String> errors = new ArrayList<>();
        if (price <= 0) {
            errors.add("giá sản phẩm phải lớn hơn 0 không được âm");
        }
        if (price > 999999999) {
            errors.add("giá sản phẩm vượt giới hạn cho phép");
        }
        if (productName.equals("")) {
            errors.add("tên sản phẩm không được để trống");
        }

        if (quantity <= 0 && quantity < 99) {
            errors.add("số lượng ít nhất là 1 và nhỏ hơn 99");
        }
        if (image.equals("")) {
            errors.add("ảnh sản phẩm chưa được chọn");
        }
        boolean success = false;
        if (errors.size() == 0) {
            Product product = new Product(id, productName, price, quantity, Category,image);
            System.out.println("User info: " + product);
            success = productService.update(product);
        }
//        System.out.println("User info: " + product);
//        boolean success =  productService.update(product);


        if (success) {
            req.setAttribute("success", true);
        } else {
//            errors.add("update thất bại");
            req.setAttribute("error", errors);
        }
            if (errors.size() > 0) {
                req.setAttribute("errors", errors);
            }
        dispatcher.forward(req, resp);
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        productService.remove(id);
        List<Product> productList = productService.findAll();
        req.setAttribute("productList",productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product?action=product");
        dispatcher.forward(req,resp);
    }
}
