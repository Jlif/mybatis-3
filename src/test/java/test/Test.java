package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiangchen
 * @date 2020/05/26
 */
public class Test {
  public static void main(String[] args) {
    String resource = "test/mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
      Role role = roleMapper.getRole(1L);
      System.out.println(role.getId() + ":" + role.getRoleName() + ":" + role.getNote());
      sqlSession.commit();

    } catch (Exception e) {
      sqlSession.rollback();
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
  }
}
