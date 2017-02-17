package com.example.bean.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeGreeter {

    private int counter = 0;

    public String sayHello() {
        counter ++;
        return  "Hello from @Scope('prototype') bean " + this.getClass() + " same instance called" + counter + "time(s).";
    }
}
