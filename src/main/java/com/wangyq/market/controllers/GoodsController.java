package com.wangyq.market.controllers;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wangyq.market.services.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    
    @Resource
    GoodsService goodsService;
    
    /*
     * 产品列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=5;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",goodsService.getGoodsCount());
        model.addAttribute("goods", goodsService.getGoodsPager(pageNO, size));
        return "goods/list";
    }
    
}