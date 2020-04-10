import com.hupu.service.ScoreServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        
        ScoreServiceImpl scoreService = (ScoreServiceImpl) context.getBean("ScoreServiceImpl");
        System.out.println(scoreService.queryScoreByDate("2014-10-28"));
    }
}
