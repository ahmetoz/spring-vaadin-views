package com.example.bean.spring;

import org.springframework.stereotype.Component;


@Component
public class SingletonGreeter {

    private int counter = 0;
    public String sayHello() {
        counter ++;
        return  "Hello from default spring @Component bean " + this.getClass() + " same instance called " + counter + " time(s).";
    }
}
