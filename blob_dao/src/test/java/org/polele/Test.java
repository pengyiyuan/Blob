package org.polele;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.polele.dao.user.UserMapper;
import org.polele.pojo.user.User;

import java.io.InputStream;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 16:27
 */
public class Test {

    public static void main(String[] args) {
        //mybatis的配置文件
        String resource = "mybatis/mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "org.polele.dao.user.UserMapper.findAll";//映射sql的标识字符串
        //这里不再调用SqlSession 的api，而是获得了接口对象，调用接口中的方法。
        UserMapper mapper = session.getMapper(UserMapper.class);
        //List<User> list = mapper.getUserByName("tom");

        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }

}
