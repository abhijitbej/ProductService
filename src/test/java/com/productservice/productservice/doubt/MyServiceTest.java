package com.productservice.productservice.doubt;

import com.productservice.productservice.doubt.MyService;
import com.productservice.productservice.doubt.ThirdPartyClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyServiceTest {
    @Autowired
    private MyService myService;

    @MockBean
    private ThirdPartyClass thirdPartyClass;

    /**
     * Here in this case mock is not working and actual call is made
     * So, test case fails with:
     *        org.opentest4j.AssertionFailedError:
     *        Expected :mock
     *        Actual   :Test
     */
    @Test
    void testGet3rdPartyName() {
        when(thirdPartyClass.getName()).thenReturn("mock");

        String name = myService.get3rdPartyName();
        assertEquals("mock", name);
    }
}