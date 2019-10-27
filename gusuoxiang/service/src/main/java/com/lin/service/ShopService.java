package com.lin.service;

import com.lin.domain.Shop;

import java.util.List;

public interface ShopService {
    /**
     * 通过页数查询商品
     * @param page
     * @return
     */
    List<Shop> findShop(String page);
}
