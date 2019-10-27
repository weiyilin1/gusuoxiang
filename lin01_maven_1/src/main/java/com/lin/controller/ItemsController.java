package com.lin.controller;


import com.lin.domain.Items;
import com.lin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model) {
        Items item = itemService.findItemById(1);
        model.addAttribute("item", item);
        return "success";

    }


}
