package com.example.view;

import javax.annotation.PostConstruct;

import com.example.bean.spring.PrototypeGreeter;
import com.example.bean.spring.SingletonGreeter;
import com.example.bean.vaadin.UIGreeter;
import com.example.bean.vaadin.ViewGreeter;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = View3.VIEW_NAME)
public class View3 extends VerticalLayout implements View {
    public static final String VIEW_NAME = "view3";

    @Autowired
    private SingletonGreeter singletonGreeter;

    @Autowired
    private PrototypeGreeter prototypeGreeter;

    @Autowired
    private PrototypeGreeter prototypeGreeter2;

    // A new instance will be created for every view instance created
    @Autowired
    private ViewGreeter viewGreeter;

    @Autowired
    private ViewGreeter viewGreeter2;

    // The same instance will be used by all views of the UI
    @Autowired
    private UIGreeter uiGreeter;

    @Autowired
    private UIGreeter uiGreeter2;

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("Navigation View 3 '/#!view3' "));
        addComponent(new Label(singletonGreeter.sayHello()));
        addComponent(new Label(prototypeGreeter.sayHello()));
        addComponent(new Label("** Prototype 2 --> " + prototypeGreeter2.sayHello()));
        addComponent(new Label(uiGreeter.sayHello()));
        addComponent(new Label("** UIScope 2 --> " +  uiGreeter2.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
        addComponent(new Label("** ViewScope 2 --> "+ viewGreeter2.sayHello()));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
