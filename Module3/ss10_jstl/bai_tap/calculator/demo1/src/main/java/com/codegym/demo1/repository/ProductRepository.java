package com.codegym.demo1.repository;

import com.codegym.demo1.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {

    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try{
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("SELECT id,name,price,quantity,description FROM products where is_deleted is false");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                products.add(new Product(id,name, price, quantity, description));
            }
        }catch(SQLException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
        return products;
    }

    public Product findById(Integer id) {
        Product product = null;
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("SELECT id,name,price,quantity,description FROM products where id=? and is_deleted is false");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt("id"),rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"));
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return product;
    }

    public boolean save(Product product) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("insert into products(name,price,quantity,description) values (?,?,?,?)");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Integer id) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("update products set is_deleted=true where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateById(Integer id,Product product) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("update products set name=?,price=?,quantity=?,description=? where id=?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Product> findAllByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("SELECT id,name,price,quantity,description FROM products where is_deleted is false and name like ?");
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return products;
    }
}
