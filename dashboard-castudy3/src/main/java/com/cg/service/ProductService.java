package com.cg.service;

import com.cg.model.Product;
import com.cg.untils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static String SELECT_ALL_PRODUCT =
            "SELECT " +
            "p.id_product, " +
            "p.product_name, " +
            "p.price, " +
            "p.quantity, " +
            "p.description, " +
            "p.img " +
            "FROM products AS p " +
            "ORDER BY p.id_product DESC; ";

    private static String SELECT_PRODUCT_BY_ID =
            "SELECT " +
            "p.id_product, " +
            "p.product_name, " +
            "p.price, " +
            "p.quantity, " +
            "p.img " +
            "FROM products AS p " +
            "WHERE p.id_product = ?;";

    private static String INSERT_PRODUCT = "" +
            "INSERT INTO products(product_name, price,quantity , description, img) " +
            "VALUES (?, ?, ?, ?, ? );";

    private static String UPDATE_PRODUCT_BY_ID =
            "UPDATE products AS p " +
            "SET " +
            "p.product_name = ?, " +
            "p.price = ?, " +
            "p.quantity = ?, " +
            "p.description = ?, " +
            "p.img = ? " +
            "WHERE p.id_product = ?;";

    private static String DELETE_PRODUCT_BY_ID = "" +
            "DELETE FROM products AS p " +
            "WHERE p.id_product = ?;";
    @Override
    public boolean create(Product product) {
        boolean success = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();

            PreparedStatement statement = connection.prepareCall(INSERT_PRODUCT);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getCategory());
            statement.setString(5, product.getImage());
            statement.execute();
            success = true;

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }

        return success;
    }

    @Override
    public boolean update(Product product) {
        boolean success = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(UPDATE_PRODUCT_BY_ID);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getCategory());
            statement.setString(5, product.getImage());
            statement.setLong(6, product.getIdProduct());
            statement.execute();
            success = true;

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }

        return success;

    }

    @Override
    public boolean remove(int id) {
        boolean success = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(DELETE_PRODUCT_BY_ID);
            statement.setInt(1,id);
            statement.execute();

            success = true;
        }catch (SQLException e){
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(SELECT_ALL_PRODUCT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int idProduct = rs.getInt("id_product");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String Category = rs.getString("description");
                String image = rs.getString("img");

                productList.add(new Product(idProduct,name,price,quantity,Category,image));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public Product findById(int productId) {

        Product product = null;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareCall(SELECT_PRODUCT_BY_ID);
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_product");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String img = rs.getString("img");


                product = new Product(id, productName, price, quantity, img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
