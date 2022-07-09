package com.sakura.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.dto.ResultDTO;
import com.sakura.entity.GShopping;
import com.sakura.service.IGShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;
import java.util.Date;
import java.util.List;

@Controller
@PermitAll
@RequestMapping
@RequiredArgsConstructor
public class GameController {

    private final IGShoppingService gShoppingService;

    /**
     * 游戏商品列表 分页显示
     * @param page
     * @return
     */
    @RequestMapping("game/show/")
    @ResponseBody
    public List<GShopping> gameShow(Integer page){

        Integer pageNum = page == null ? 0 : page;
        Page<GShopping> gPage = new Page<>(pageNum, 3);

        Page<GShopping> gamePage = gShoppingService.page(gPage, new QueryWrapper<>());
        List<GShopping> gameList = gamePage.getRecords();
        System.out.println("一共多少数据："+gamePage.getTotal());
        System.out.println("一共有几页："+gamePage.getPages());
        System.out.println("当前第几页："+gamePage.getCurrent());
        System.out.println("一页多少数据"+gamePage.getSize());
        System.out.println("是否有下一页："+gamePage.hasNext());
        System.out.println("是否有上一页："+gamePage.hasPrevious());
        return gameList;
    }

    //添加游戏信息
    @GetMapping("game/addGS")
    @ResponseBody
    public ResultDTO addGS(@RequestBody GShopping shopping){
        shopping =
                new GShopping(null,2,"csgo",999.0,null,new Date(),12,"无","","","[\"第三人称\",\"FPS\"]","1","3090ti",9.3);


        boolean b= gShoppingService.save(shopping);
        return null;
    }

    // 模糊搜索
    // 根据游戏名称

    // 根据游戏发行日期
    // 发行厂商
    // 价格区间
    // 年龄分级
    // 标签搜索

}
