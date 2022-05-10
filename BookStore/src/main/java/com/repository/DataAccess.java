package com.repository;

import com.dto.*;
import com.model.Category;
import com.model.StatisticProduct;
import com.model.response.Search;
import com.model.response.SearchDate;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private OrderService orderService;

    public Page<WarehouseDTO> getListWarehouseDTO(Pageable pageable) {
        List<WarehouseDTO> lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_amount"),
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

    public ProductDTO findProductDTOById(Long id) {
        ProductDTO productDTO = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.id = ?";
            productDTO = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new ProductDTO(
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
        return productDTO;
    }

    public WarehouseDTO findWarehouseById(Long id) {
        WarehouseDTO lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND w.id = ?";
            lst = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_amount"),
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

    public Page<ProductDTO> getListProductDTOByName(String name, Pageable pageable, String sort) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.name LIKE ?  ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

            if("asc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.name LIKE ?  ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            } else if("desc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.name LIKE ?  ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            }

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


    public Page<ProductDTO> getListProductDTOByTypeHot(Pageable pageable, String sort) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c, WAREHOUSE w WHERE p.category_id = c.id AND p.id = w.product_id AND w.amount <= 20 AND w.input_amount >= 50 ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

            if("asc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c, WAREHOUSE w WHERE p.category_id = c.id AND p.id = w.product_id AND w.amount <= 20 AND w.input_amount >= 50  ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            } else if("desc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c, WAREHOUSE w WHERE p.category_id = c.id AND p.id = w.product_id AND w.amount <= 20 AND w.input_amount >= 50  ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            }

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
        return new PageImpl<>(lst, pageable, productService.countByProductHot());
    }

    public Page<ProductDTO> getListProductDTOByTypeSale(Pageable pageable, String sort) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND sale_price > 0 AND sale_price < price ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

            if("asc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND sale_price > 0 AND sale_price < price ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            } else if("desc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND sale_price > 0 AND sale_price < price ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            }

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
        return new PageImpl<>(lst, pageable, productService.countByProductSale());
    }

    public Page<ProductDTO> getListProductDTOByTypeNew(Pageable pageable, String sort) {
        List<ProductDTO> lst = null;
        try {
            String sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY ID DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

            if("asc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            } else if("desc".equals(sort)) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            }

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

    public Page<WarehouseDTO> getListWarehouseDTOByNameProduct(String name, Pageable pageable) {
        List<WarehouseDTO> lst = null;
        try {
            String sql = "SELECT w.*, p.name FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND p.name LIKE ? ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
            lst = jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, (rs, rowNum) -> new WarehouseDTO(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("amount"),
                            rs.getInt("input_amount"),
                            rs.getInt("input_price"),
                            rs.getString("note")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, warehouseService.countByLikeNameProduct(name));
    }

    public Page<ProductDTO> getListProductDTOByCategoryId(Pageable pageable, String idCategory, String sort) {
        List<ProductDTO> lst = null;
        try {
            String sql = "";
            if ("".equals(idCategory) || idCategory == null) {
                sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY ID ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                if ("asc".equals(sort)) {
                    sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                } else if("desc".equals(sort)) {
                    sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                }
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
                if ("asc".equals(sort)) {
                    sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.category_id = ? ORDER BY p.price ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                } else if("desc".equals(sort)) {
                    sql = "SELECT p.*, c.name FROM PRODUCT p, CATEGORY c WHERE p.category_id = c.id AND p.category_id = ? ORDER BY p.price DESC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                }
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

    public List<OrderDetailDTO> getListOrderDTO(SearchDate searchDate) {
        List<OrderDetailDTO> orderDetailDTO = null;
        try {
            String sql = "";
            if (!"".equals(searchDate.getFromDate()) && !"".equals(searchDate.getToDate())) {
                sql = "SELECT o.*, u.user_name, p.name, od.unit_price, od.amount  FROM PRODUCT p, ORDERS o, USER u, ORDERS_DETAILS od WHERE p.id = od.product_id AND u.id = o.user_id AND o.id = od.order_id AND modefined_date BETWEEN ? AND ? GROUP BY o.id";
                orderDetailDTO = jdbcTemplate.query(sql, new Object[]{searchDate.getFromDate(), searchDate.getToDate()}, (rs, rowNum) -> new OrderDetailDTO(
                                rs.getLong("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("phone"),
                                rs.getString("address"),
                                rs.getString("province"),
                                rs.getString("district"),
                                rs.getString("commune"),
                                rs.getString("special_notes"),
                                rs.getDate("modefined_date"),
                                rs.getLong("total_price"),
                                rs.getString("payment_method"),
                                rs.getString("u.user_name"),
                                rs.getString("p.name"),
                                rs.getLong("od.unit_price"),
                                rs.getInt("od.amount"),
                                rs.getLong("status")
                        )
                );
            } else {
                sql = "SELECT o.*, u.user_name, p.name, od.unit_price, od.amount  FROM PRODUCT p, ORDERS o, USER u, ORDERS_DETAILS od WHERE p.id = od.product_id AND u.id = o.user_id AND o.id = od.order_id GROUP BY o.id";
                orderDetailDTO = jdbcTemplate.query(sql, (rs, rowNum) -> new OrderDetailDTO(
                                rs.getLong("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("phone"),
                                rs.getString("address"),
                                rs.getString("province"),
                                rs.getString("district"),
                                rs.getString("commune"),
                                rs.getString("special_notes"),
                                rs.getDate("modefined_date"),
                                rs.getLong("total_price"),
                                rs.getString("payment_method"),
                                rs.getString("u.user_name"),
                                rs.getString("p.name"),
                                rs.getLong("od.unit_price"),
                                rs.getInt("od.amount"),
                                rs.getLong("status")
                        )
                );
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return orderDetailDTO;
    }

    public List<OrderDetailDTO> getOrderDTOById(Long input) {
        List<OrderDetailDTO> orderDetailDTO = null;
        try {
            String sql = "SELECT o.*, u.user_name, p.name, od.unit_price, od.amount  FROM PRODUCT p, ORDERS o, USER u, ORDERS_DETAILS od WHERE p.id = od.product_id AND u.id = o.user_id AND o.id = od.order_id AND o.id = ?";
            orderDetailDTO = jdbcTemplate.query(sql, new Object[]{input}, (rs, rowNum) -> new OrderDetailDTO(
                            rs.getLong("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            rs.getString("province"),
                            rs.getString("district"),
                            rs.getString("commune"),
                            rs.getString("special_notes"),
                            rs.getDate("modefined_date"),
                            rs.getLong("total_price"),
                            rs.getString("payment_method"),
                            rs.getString("u.user_name"),
                            rs.getString("p.name"),
                            rs.getLong("od.unit_price"),
                            rs.getInt("od.amount"),
                            rs.getLong("status")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return orderDetailDTO;
    }

    public Page<StatisticProduct> getStatisticProductByCondition(Search search, Pageable pageable) {
        List<StatisticProduct> lst = null;
        String sql = "";

        String fromDate = search.getFromDate() + " 00:00:00";
        String toDate = search.getToDate() + " 23:59:59" ;


        try {
            if (!"".equals(search.getInput()) && "".equals(search.getFromDate())) {
                sql = "SELECT v.*  FROM V_STATISTIC_PRODUCT v WHERE v.name LIKE ? ORDER BY v.id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                lst = jdbcTemplate.query(sql, new Object[]{"%" + search.getInput() + "%"}, (rs, rowNum) -> new StatisticProduct(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getLong("total_price"),
                                rs.getDate("modefined_date")
                        )
                );
            } else if ("".equals(search.getInput()) && !"".equals(search.getFromDate())) {
                sql = "SELECT v.*  FROM V_STATISTIC_PRODUCT v WHERE v.modefined_date >= ? AND v.modefined_date <= ? ORDER BY v.id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                lst = jdbcTemplate.query(sql, new Object[]{fromDate, toDate}, (rs, rowNum) -> new StatisticProduct(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getLong("total_price"),
                                rs.getDate("modefined_date")
                        )
                );
            } else {
                sql = "SELECT v.*  FROM V_STATISTIC_PRODUCT v WHERE v.name LIKE ? AND v.modefined_date >= ? AND v.modefined_date <= ? ORDER BY v.id ASC LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
                lst = jdbcTemplate.query(sql, new Object[]{"%" + search.getInput() + "%", fromDate, toDate}, (rs, rowNum) -> new StatisticProduct(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getLong("total_price"),
                                rs.getDate("modefined_date")
                        )
                );
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return new PageImpl<>(lst, pageable, countStatisticProductByCondition(search));
    }

    public Long countStatisticProductByCondition(Search search) {
        List<Long> tmp = null;
        Long count = 0l;
        String sql = "";
        String fromDate = search.getFromDate() + " 00:00:00";
        String toDate = search.getToDate() + " 23:59:59" ;
        try {
            if (!"".equals(search.getInput()) && "".equals(search.getFromDate())) {
                sql = "SELECT COUNT(*)  FROM V_STATISTIC_PRODUCT v WHERE v.name LIKE ?";
                tmp = jdbcTemplate.queryForList(sql, new Object[]{"%" + search.getInput() + "%"}, Long.class);
            } else if ("".equals(search.getInput()) && !"".equals(search.getFromDate())) {
                sql = "SELECT COUNT(*)  FROM V_STATISTIC_PRODUCT v WHERE v.modefined_date >= ? AND v.modefined_date <= ?";
                tmp = jdbcTemplate.queryForList(sql, new Object[]{fromDate, toDate}, Long.class);
            } else {
                sql = "SELECT COUNT(*)  FROM V_STATISTIC_PRODUCT v WHERE v.name LIKE ? AND v.modefined_date >= ? AND v.modefined_date <= ?";
                tmp = jdbcTemplate.queryForList(sql, new Object[]{"%" + search.getInput() + "%", fromDate, toDate}, Long.class);
            }
            if (tmp != null && tmp.size() == 1) {
                count = tmp.get(0);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return count;
    }

    public List<WishlistDTO> getListWishlistByUserId(String userId) {
        List<WishlistDTO> lst = null;
        try {
            String sql = "SELECT p.id, p.name, p.image, wh.amount, p.price, p.sale_price FROM wishlist w, product p, warehouse wh WHERE w.product_id = p.id AND p.id = wh.product_id AND w.user_id = ? ORDER BY w.id ASC";
            lst = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> new WishlistDTO(
                            rs.getLong("p.id"),
                            rs.getString("p.name"),
                            rs.getString("p.image"),
                            rs.getInt("wh.amount"),
                            rs.getLong("p.price"),
                            rs.getLong("p.sale_price")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }

    public List<CartDTO> getAllListCartByUserId(String userId) {
        List<CartDTO> lst = null;
        try {
            String sql = "SELECT c.*, p.name, p.image, w.amount FROM cart c, product p, warehouse w WHERE c.product_id = p.id AND w.product_id = p.id AND c.status = 0 AND c.user_id = ?";
            lst = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> new CartDTO(
                            rs.getLong("c.product_id"),
                            rs.getString("p.name"),
                            rs.getString("p.image"),
                            rs.getInt("c.amount"),
                            rs.getInt("w.amount"),
                            rs.getLong("c.total")
                    )
            );
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lst;
    }
}
