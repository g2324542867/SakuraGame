import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakura.SakuraApplication;
import com.sakura.mapper.IGShoppingMapper;
import com.sakura.utils.LabelHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@SpringBootTest(classes = SakuraApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Autowired
    private IGShoppingMapper shoppingMapper;


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


}
