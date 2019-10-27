package com.lin.service.impl;

import com.lin.dao.ShopDao;
import com.lin.dao.impl.ShoDaoImpl;
import com.lin.domain.Shop;
import com.lin.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private ShopDao dao = new ShoDaoImpl();


    @Override
    public List<Shop> findShop(String page) {
        return dao.findShop(page);
    }

}
