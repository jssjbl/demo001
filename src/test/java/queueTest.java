import com.example.demo.DemoApplication;
import com.example.demo.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 消息队列测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class queueTest {
//    @Autowired
//    private Sender sender;
//
//    @Test
//    public void test1(){
//        sender.send("杨逸飞");
//    }
}
