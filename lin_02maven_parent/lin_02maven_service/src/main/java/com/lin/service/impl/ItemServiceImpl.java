package com.lin.service.impl;

import com.lin.dao.ItemsDao;
import com.lin.domain.Items;
import com.lin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsDao dao;


    public Items findItemById(Integer id) {
        return dao.findItemById(id);
    }
}
