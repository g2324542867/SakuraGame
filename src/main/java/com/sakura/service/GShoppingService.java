package com.sakura.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.GShopping;
import com.sakura.mapper.IGShoppingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GShoppingService extends ServiceImpl<IGShoppingMapper,GShopping> implements IGShoppingService {

    private final IGShoppingMapper shoppingMapper;


    // 根据游戏名称进行模糊查询
    @Override
    public List<GShopping> likeGName(String name) {

        QueryWrapper<GShopping> gShopping = new QueryWrapper<>();
        gShopping.like("g_name",name);
        List<GShopping> gameList = shoppingMapper.selectList(gShopping);

        return gameList;
    }
}
