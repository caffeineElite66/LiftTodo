package com.kl.todo.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Collection;

import com.kl.todo.domain.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: May 17, 2010
 * Time: 10:48:01 AM
 * To change this template use File | Settings | File Templates.
 */


@ContextConfiguration(locations = "classpath:test-context.xml")
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    private JpaUserDao userDao;

    @Resource
    public void setUserDao(JpaUserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    public void testSave() throws SQLException {
        User user = new User();
        user.setAccessLevel(1);
        user.setEmail("kevinmsm@yahoo.com");
        user.setUsername("kevinmsm");
        user.setPassword("password");
        userDao.save(user);
        userDao.entityManager.flush();
    }
}
