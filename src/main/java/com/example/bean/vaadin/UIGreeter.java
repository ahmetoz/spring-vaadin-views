package com.example.bean.vaadin;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent //or @Component
@UIScope
public class UIGreeter {

    private int counter = 0;
    public String sayHello() {
        counter ++;
        return  "Hello from @UIScope bean " + this.getClass() + " same instance called " + counter + " time(s).";
    }
}
