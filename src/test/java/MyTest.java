import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.sakura.SakuraApplication;
import com.sakura.entity.GShopping;
import com.sakura.entity.User;
import com.sakura.mapper.IGShoppingMapper;
import com.sakura.service.IGShoppingService;
import com.sakura.service.IUserService;
import com.sakura.utils.LabelHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = SakuraApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Autowired
    private IGShoppingMapper shoppingMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGShoppingService shoppingService;


    @Test
    public void test1(){
        System.out.println(shoppingMapper.selectList(new QueryWrapper<>()));
    }

    @Test
    public void test2(){
        LabelHandle.split("[\"第一人称射击游戏\",\"视觉小说\"]").forEach(System.out::println);
    }

    @Test
    public void test3(){
        String[] str = new String[]{"第一人称射击游戏","视觉小说"};
        System.out.println(LabelHandle.splicing(Arrays.asList(str)));
    }

    @Test
    public void test4(){
        User user = new User();
        user.setUserEmail("ceshi@qq.com");
        user.setUserName("测试");
        user.setPassword("123");
        Boolean aBoolean = userService.registerUser(user);
    }


    @Test
    public void test5(){
        GShopping gShopping = new GShopping(null, 2, "mirror", 0.0, null, new Date(), 12, "无", "", "", "[\"第三人称\",\"FPS\"]", "1", "3090ti", 9.3);
        shoppingService.save(gShopping);
        System.out.println(gShopping);
    }


}
