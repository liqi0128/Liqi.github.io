import com.book.pojo.Borrow;
import com.book.service.Impl.BookBorrowServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ttt {

    @Test
    public void test1(){
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        BookBorrowServiceImpl m = (BookBorrowServiceImpl) context.getBean("bookBorrowServiceImpl");
        List<Borrow> list=m.getLoanRanking();
        for (Borrow b:list) {
            System.out.println(b.getBookinfo().getBookname());
        }

    }
}
