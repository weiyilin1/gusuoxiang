package com.lin.service;

import com.lin.domain.Items;

public interface ItemService {
    /**
     * 通过id查询item
     *
     * @return
     */
    Items findItemById(Integer id);


}
