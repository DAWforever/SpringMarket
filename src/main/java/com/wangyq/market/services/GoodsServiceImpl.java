package com.wangyq.market.services;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wangyq.market.entities.*;
import com.wangyq.market.mapper.*;

@Service
public class GoodsServiceImpl implements GoodsService{
    //自动装配
    @Resource
    GoodsDAO goodsdao;
    
    //分页
    @Override
    public List<Goods> getGoodsPager(int pageNO, int size) {
        int skip=(pageNO-1)*size;
        return goodsdao.getGoodsPager(skip, size);
    }

    //获得单个产品对象
    @Override
    public Goods getGoodsById(int id) {
        return goodsdao.getGoodsById(id);
    }
    
    //获得商品总数
    @Override
    public int getGoodsCount() {
        return goodsdao.getGoodsCount();
    }

    //添加
    @Override
    public int insert(Goods entity) {
        return goodsdao.insert(entity);
    }

    //删除单个
    @Override
    public int delete(int id) {
        return goodsdao.delete(id);
    }
    
    //删除多个
    @Override
    public int deletes(int[] ids) {
        int rows=0;
        for (int id : ids) {
            rows+=delete(id);
        }
        return rows;
    }

    //更新
    @Override
    public int update(Goods entity) {
        return goodsdao.update(entity);
    }

}