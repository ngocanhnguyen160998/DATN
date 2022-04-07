package com.repository;

import com.dto.OrderDTO;
import com.dto.ProductDTO;
import com.dto.UserDTO;
import com.dto.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataAccess {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<WarehouseDTO> getListWarehouseDTO() {
        List<WarehouseDTO> lst = null;
        try {
            String sql = "SELECT w.id, p.name, w.amount, w.note FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id";
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }

    public List<ProductDTO> getListProductDTO() {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY ID ASC";
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new ProductDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("image"),
                            rs.getString("info"),
                            rs.getString("descriptions"),
                            rs.getLong("price"),
                            rs.getLong("sale_price"),
                            rs.getString("c.name"),
                            rs.getString("author")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }

    public WarehouseDTO findWarehouseById(Long id) {
        WarehouseDTO lst = null;
        try {
            String sql = "SELECT w.id, p.name, w.amount, w.note FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND w.id = ?";
            lst = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }

    public List<UserDTO> getListUserDTO() {
        List<UserDTO> lst = null;
        try {
            String sql = "SELECT u.*, r.* FROM USER u, ROLE r WHERE u.role_id = r.id";
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new UserDTO(
                            rs.getLong("id"),
                            rs.getString("user_name"),
                            rs.getString("password"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("r.name")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }
//
//    public ProductDTO findProductById(Long id) {
//        ProductDTO lst = null;
//        try {
//            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id";
//            lst = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new ProductDTO(
//                            rs.getLong("id"),
//                            rs.getString("name"),
//                            rs.getString("image"),
//                            rs.getString("info"),
//                            rs.getString("descriptions"),
//                            rs.getLong("price"),
//                            rs.getLong("sale_price"),
//                            rs.getString("c.name"),
//                            rs.getString("author")
//                    )
//            );
//        } catch (Exception ex) {
//            ex.getMessage();
//        }
//        return lst;
//    }
}
