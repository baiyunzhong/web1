
import com.jnshu.ssm.dao.StudentMapper;
import com.jnshu.ssm.pojo.Page;
import com.jnshu.ssm.pojo.Student;
import com.jnshu.ssm.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author : baiyunzhong
 * created time : 2019/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class TestMybatis {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;
    @Test
    public void testFindById(){
        Student student = studentMapper.findById(4768906);
        System.out.println(student);
    }

    @Test
    public void testFindById2(){
        Student student = studentService.findByOnlineId("66");
        System.out.println(student);
    }
    @Test
    public void testFindByPage(){
        Page page =new Page();
        page.setCurrentPage(2);
        page.setCount(10);
        page.setStart(40);
        System.out.println(studentService.findByPage(page));
    }
}
