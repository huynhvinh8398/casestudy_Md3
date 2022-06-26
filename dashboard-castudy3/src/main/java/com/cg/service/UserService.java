package com.cg.service;

import com.cg.model.User;
import com.cg.untils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{

private static String SELECT_ALL_USER =
        "SELECT " +
        "u.user_id, " +
        "u.user_name, " +
        "u.password, " +
        "u.full_name, " +
        "u.phone, " +
        "u.email, " +
        "u.address " +
        "FROM users AS u " +
        "ORDER BY u.user_id DESC; ";

private static String SELECT_USER_BY_ID =
        "SELECT " +
        "u.user_id, " +
        "u.user_name, " +
        "u.phone, " +
        "u.email, " +
        "u.address, " +
        "u.createAt " +
        "FROM users AS u " +
        "WHERE u.user_id = ?;";

private static String INSERT_USER = "" +
        "INSERT INTO users(user_name, password,full_name , phone, email, address) " +
        "VALUES (?, ?, ?, ?, ?, ? );";

private static String SP_INSERT_USER = "{CALL sp_insert_user(?, ?, ?, ?, ?, ?, ?, ?)}";

private static String SP_UPDATE_USER = "{CALL sp_update_user(?, ?, ?, ?, ?, ?, ? )}";

private static final String EXIST_EMAIL_USER = "SELECT COUNT(*) AS count FROM users AS u WHERE u.email = ?;";
private static final String EXIST_PHONE_USER = "SELECT COUNT(*) AS count FROM users AS u WHERE u.phone = ?;";



private static String UPDATE_USER_BY_ID =
        "UPDATE users AS u " +
        "SET " +
        "u.user_name = ?, " +
        "u.full_name = ?, " +
        "u.phone = ?, " +
        "u.email = ?, " +
        "u.address = ? " +
        "WHERE u.user_id = ?;";

private static String DELETE_USER_BY_ID = "" +
        "DELETE FROM users AS u " +
        "WHERE u.user_id = ?;";
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
         Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("user_id");
                String username = rs.getString("user_name");
                String password = rs.getString("password");
                String fullname = rs.getString("full_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");

                     userList.add(new User(id,username,password,fullname,phone,email,address));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public boolean create(User user) {
        boolean success = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();

            PreparedStatement statement = connection.prepareCall(INSERT_USER);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getAddress());
            statement.execute();
            success = true;
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean update(User user) {

        boolean success = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(UPDATE_USER_BY_ID);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getAddress());
            statement.setLong(6, user.getId());
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
            PreparedStatement statement = connection.prepareCall(DELETE_USER_BY_ID);
            statement.setInt(1, id);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }
    @Override
    public User findById(long userId) {
        User user = null;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareCall(SELECT_USER_BY_ID);
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("user_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");


                user = new User(id, username, phone, email,address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {

        boolean exists = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(EXIST_EMAIL_USER);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int count = rs.getInt("count");

                if (count > 0) {
                    exists = true;
                }
            }

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return exists;
    }

    @Override
    public boolean existsByPhone(String phone) {

        boolean exists = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(EXIST_PHONE_USER);
            statement.setString(1,phone);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int count = rs.getInt("count");

                if (count > 0) {
                    exists = true;
                }
            }

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return exists;
    }
}
