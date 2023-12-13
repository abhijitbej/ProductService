package com.productservice.productservice.doubt;

import org.springframework.stereotype.Service;

/**
 * In this service class could not autowire the ThirdPartyClass as
 * it does not have @Component annotation. We cannot add a @Component
 * annotation as it will be inside a jar file.
 */
@Service
public class MyService {
    public String get3rdPartyName() {
        ThirdPartyClass thirdPartyClass = ThirdPartyClass.builder().name("Test").build();
        return thirdPartyClass.getName();
    }
}
