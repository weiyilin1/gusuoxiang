package com.lin.dao;

import com.lin.domain.Shop;

import java.util.List;

public interface ShopDao {
    List<Shop> findShop(String page);
}
