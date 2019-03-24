import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Mybatis {
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;

    }

    public static void main(String[] args) {

        SqlSession sqlSession = getSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Student student = personMapper.find("zdh");
        System.out.println(student.getName());

    }
}
