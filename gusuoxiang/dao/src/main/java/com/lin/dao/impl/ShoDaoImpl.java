package com.lin.dao.impl;

import com.lin.dao.ShopDao;
import com.lin.domain.Shop;
import com.lin.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShoDaoImpl implements ShopDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Shop> findShop(String page) {
        String sql = "select * from shop limit ?,12";
        return template.query(sql,new BeanPropertyRowMapper<>(Shop.class),
                Integer.parseInt(page)*12);
    }
}
