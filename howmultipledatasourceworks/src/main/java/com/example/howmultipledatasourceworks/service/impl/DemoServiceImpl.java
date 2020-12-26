package com.example.howmultipledatasourceworks.service.impl;

import com.example.howmultipledatasourceworks.mapper.db1.UserMapper;
import com.example.howmultipledatasourceworks.mapper.db2.OrganizationMapper;
import com.example.howmultipledatasourceworks.model.db1.User;
import com.example.howmultipledatasourceworks.model.db2.Organization;
import com.example.howmultipledatasourceworks.service.DemoService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    @Qualifier("db2tx")
    private DataSourceTransactionManager db2tx;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional(value = "db1tx")
    public void test(int i) {
        TransactionDefinition transactionDefinition = TransactionDefinition.withDefaults();
        TransactionStatus transactionStatus = db2tx.getTransaction(transactionDefinition);
        try {
            User user = new User("renjiyun");
            Organization organization = new Organization("org1");
//            userMapper.insert(user);
//            organizationMapper.insert(organization);

            if (i % 2 == 0) {
                throw new RuntimeException("==========");
            }
            db2tx.commit(transactionStatus);
        } catch (Throwable t) {
            db2tx.rollback(transactionStatus);
            throw t;
        }
    }

    @Override
    public User getUser(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Organization getOrg(long id) {
        return organizationMapper.selectById(id);
    }

    @Override
    @Transactional
    public void testStream() throws IOException {
        Cursor<User> cursor = userMapper.scanAllUser();
        cursor.forEach(user -> {
            System.out.println(user.getName());
        });
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
