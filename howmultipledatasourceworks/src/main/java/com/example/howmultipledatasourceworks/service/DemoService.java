package com.example.howmultipledatasourceworks.service;

import com.example.howmultipledatasourceworks.model.db1.User;
import com.example.howmultipledatasourceworks.model.db2.Organization;

import java.io.IOException;

public interface DemoService {
    void test(int i);

    User getUser(long id);

    Organization getOrg(long id);

    void testStream() throws IOException;
}
