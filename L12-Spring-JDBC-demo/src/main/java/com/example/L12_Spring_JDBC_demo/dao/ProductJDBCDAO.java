package com.example.L12_Spring_JDBC_demo.dao;

import com.example.L12_Spring_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository("productJDBCDAO")
public class ProductJDBCDAO implements IProductDao{

    private Map<Long, Product> dataStore = new HashMap<>();
    private AtomicLong nextId=new AtomicLong(1l);

    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public Product getById(Long id){
        // call DB
        Product product = null;
        try(Connection con = DriverManager.getConnection(dbUrl,username,password)){
            String sqlQuery = "Select id, name, cost from product where id="+id;
            Statement statement = con.createStatement();
            ResultSet resultSet= statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                product = new Product(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getDouble("cost"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;

    }

//    @Override
//    public Product create(Product product) {
//        try (Connection con = DriverManager.getConnection(dbUrl,username,password)){
//            String sqlInsert = "insert into product values (null,'"+product.getName()+"',"+product.getCost()+")";
//            Statement statement = con.createStatement();
//            int affectedRow = statement.executeUpdate(sqlInsert,Statement.RETURN_GENERATED_KEYS);
//            if(affectedRow ==0){
//                throw new SQLException("Creation Failed");
//            }
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if(generatedKeys.next()){
//                product.setId(generatedKeys.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return product;
//    }


     //with prepareStatement
//    @Override
//    public Product create(Product product) {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(dbUrl,username,password);
//            String sqlInsert = "insert into product values (null,?,?)";
//            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setDouble(2,product.getCost());
//            int affectedRow = preparedStatement.executeUpdate();
//            if(affectedRow ==0){
//                throw new SQLException("Creation Failed");
//            }
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            if(generatedKeys.next()){
//                product.setId(generatedKeys.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            if(con !=null){
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return product;
//    }


    @Override
    public Product create(Product product) {
        Connection con = null;
        boolean autoCommit = false;
        try {
            con = DriverManager.getConnection(dbUrl,username,password);
            autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            String sqlInsert = "insert into product values (null,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2,product.getCost());
            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow ==0){
                throw new SQLException("Creation Failed");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                product.setId(generatedKeys.getLong(1));
            }
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        finally {

            if(con !=null){
                try {
                    con.setAutoCommit(autoCommit);
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }


    public Product update(Long id, Product product){
        return null;
    }

    public Product delete(Long id){
        return null;
    }


}
