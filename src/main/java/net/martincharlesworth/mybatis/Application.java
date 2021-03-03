package net.martincharlesworth.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        Student student = new Student();
        student.setId(1);
        student.setEmail("student@gmail.com");
        student.setBranch("Area 10");
        student.setName("Joe Bloggs");
        student.setPercentage(80);
        student.setPhone(12345678);

        session.insert("Student.insert", student);
        session.commit();

        List<Student> list = session.selectList("Student.getAll");

        for (int i = 0; i < list.size(); i++) {
            Student student1 =  list.get(i);
            System.out.println(student1);
        }

    }
}
