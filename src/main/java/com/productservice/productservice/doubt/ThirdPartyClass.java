package com.productservice.productservice.doubt;

import lombok.Builder;
import lombok.Getter;

/**
 * Imagine, this is a third party class. So it is not having any @Component annotation
 * Object is created via Builder method.
 */
@Getter
@Builder
public class ThirdPartyClass {
    private String name;
}
