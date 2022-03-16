package com.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class assertionTest {

    @Test(expected = Test.None.class /* no exception expected */)
    public void test_printLine() {
        Application.printLine("line");
    }
}
