package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.entity.GShopping;

import java.util.List;

public interface IGShoppingService extends IService<GShopping> {
    List<GShopping> likeGName(String name);
}
