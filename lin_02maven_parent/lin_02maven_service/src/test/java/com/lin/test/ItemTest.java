package com.lin.test;

import com.lin.service.ItemService;
import com.lin.service.impl.ItemServiceImpl;

public class ItemTest {
    public static void main(String[] args) {

        ItemService service = new ItemServiceImpl();
        service.findItemById(33);

    }
}
