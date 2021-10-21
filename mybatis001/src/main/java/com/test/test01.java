package com.test;

import com.entity.card;
import com.mapper.CardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class test01 {

    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = test01.class.getClassLoader().getResourceAsStream("config.xml");
        //构建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //通过sqlSession获取接口的代理对象
        CardMapper mapper = sqlSession.getMapper(CardMapper.class);//获取接口的代理实现类

        //接口方法测试
        //1 findByCno
        System.out.println(mapper.findByCno("sx009"));
        //2 save
//        card card = new card();
//        card.setUserCno("sx012");card.setUserName("炼金术士");card.setUserGrades("G22");card.setUserAge(20);
//        System.out.println(mapper.save(card));
//        sqlSession.commit();//增删改需要提交事务

        //3 findAll
//        for (card card2 : mapper.findAll()) {
//            System.out.println(card2);
//        }

        //4 deleteByCno
//        System.out.println(mapper.deleteByCno("sx012"));
//        sqlSession.commit();

        //5 updateCard
//        card sx012 = mapper.findByCno("sx012");
//        sx012.setUserName("波尔多");
//        System.out.println(mapper.updateCardName(sx012));//输出改变行数
//        sqlSession.commit();
    }
}
