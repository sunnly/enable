package wang.sunnly.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * AsyncApplicationWithAnnotationTests
 *
 * @author Sunnly
 * @create 2019/7/18 0018 0:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AsyncApplication.class)
public class AsyncApplicationWithAnnotationTests {
    @Autowired
    private AsyncDemo asyncDemo;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        asyncDemo.asyncInvokeSimplest();
        asyncDemo.asyncInvokeWithParameter("test");
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);
        System.out.println(future.get());
    }
}
