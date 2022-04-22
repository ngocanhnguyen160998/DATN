package com.repository;

import com.dto.ProductDTO;
import com.dto.UserDTO;
import com.dto.WarehouseDTO;
import com.model.Category;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserService;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataAccess {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    public Page<WarehouseDTO> getListWarehouseDTO(Pageable pageable) {
        List<WarehouseDTO> lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_price"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, warehouseService.count());
    }

    public Page<ProductDTO> getListProductDTO(Pageable pageable) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id  ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
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
        return new PageImpl<>(lst, pageable, productService.count());
    }

    public WarehouseDTO findWarehouseById(Long id) {
        WarehouseDTO lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND w.id = ?";
            lst = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_price"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }

    public Page<UserDTO> getListUserDTO(Pageable pageable) {
        List<UserDTO> lst = null;
        try {
            String sql = "SELECT u.*, r.* FROM USER u, ROLE r WHERE u.role_id = r.id ORDER BY u.id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new UserDTO(
                            rs.getLong("id"),
                            rs.getString("user_name"),
                            rs.getString("password"),
                            rs.getString("full_name"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("r.name")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, userService.count());
    }

    public Page<UserDTO> getListUserDTOByUserName(String userName, Pageable pageable) {
        List<UserDTO> lst = null;
        try {
            String sql = "SELECT u.*, r.* FROM USER u, ROLE r WHERE u.role_id = r.id AND user_name LIKE ? ORDER BY u.id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, new Object[]{"%" + userName + "%"}, (rs, rowNum) -> new UserDTO(
                            rs.getLong("id"),
                            rs.getString("user_name"),
                            rs.getString("password"),
                            rs.getString("full_name"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("r.name")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, userService.countByUserNameLike(userName));
    }

    public Page<Category> getListCategoryByName(String name, Pageable pageable) {
        List<Category> lst = null;
        try {
            String sql = "SELECT * FROM CATEGORY WHERE name LIKE ? ORDER BY id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, (rs, rowNum) -> new Category(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, categoryService.countByNameLike(name));
    }

    public Page<ProductDTO> getListProductDTOByName(String name, Pageable pageable) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.name LIKE ?  ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, (rs, rowNum) -> new ProductDTO(
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
        return new PageImpl<>(lst, pageable, productService.countByNameLike(name));
    }

    public Page<WarehouseDTO> getListWarehouseDTOByNameProduct(String name, Pageable pageable) {
        List<WarehouseDTO> lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND p.name LIKE ? ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_price"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, warehouseService.countByLikeNameProduct(name));
    }

    public Page<ProductDTO> getListProductDTOByCategoryId(Pageable pageable, String idCategory) {
        List<ProductDTO> lst = null;
        try {
            String sql = "";
            if ("".equals(idCategory) || idCategory == null) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
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
            } else {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.category_id = ? ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                lst = jdbcTemplate.query(sql, new Object[]{idCategory}, (rs, rowNum) -> new ProductDTO(
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
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, productService.count());
    }

}
