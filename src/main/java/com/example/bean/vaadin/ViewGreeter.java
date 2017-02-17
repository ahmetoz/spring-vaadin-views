package com.example.bean.vaadin;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent //or @Component
@ViewScope
public class ViewGreeter {

    private int counter = 0;
    public String sayHello() {
        counter ++;
        return  "Hello from @ViewScope bean " + this.getClass() + " same instance called " + counter + " time(s).";
    }
}
