package com.example;

import com.example.view.*;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class MyVaadinUI extends UI{

    @Autowired
    private SpringViewProvider viewProvider;



    @Override
    protected void init(VaadinRequest request) {
 //       setContent(new Label(greeter.sayHello()));

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        navigationBar.addComponent(createNavigationButton("Default", DefaultView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View 2", View2.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View 3", View3.VIEW_NAME));
        root.addComponent(navigationBar);


        Link link = new Link("Reload Page", new ExternalResource("http://localhost:8080"));
        root.addComponent(link);
        root.addComponent(about());
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0F);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    Panel about() {
        Panel p = new Panel("About");
        VerticalLayout content = new VerticalLayout() {
            {
                setSpacing(true);
                setMargin(true);
                addStyleName("wrapping");

                Label springUI = new Label("The @SpringUI annotation the Vaadin Spring plugin will know to inject the UI rather than directly instantiating it. With injected beans we can use all of the usual Spring features such as autowiring. ");
                springUI.addStyleName("small");
                springUI.setCaption("@SpringUI");
                addComponent(springUI);

                Label singleton = new Label("For thread safe background services, the scope @Scope(\"singleton\") can be used, but it should not be used for Vaadin Components.");
                singleton.addStyleName("small");
                singleton.setCaption("@Scope(\"singleton\")");
                addComponent(singleton);

                Label prototype = new Label("Most commonly, you would use @Scope(\"prototype\") to inject a new instance every time that bean is injected");
                prototype.addStyleName("small");
                prototype.setCaption("@Scope(\"prototype\")");
                addComponent(prototype);

                Label uiScope = new Label("The @UIScope annotation is specific to Vaadin Spring. Anything injected with that annotation will get the same instance while within the same UI. Load a different UI and you'll get a different instance. If the session expires or the UI is closed, the instances will be cleaned up.");
                uiScope.addStyleName("small");
                uiScope.setCaption("@UIScope");
                addComponent(uiScope);

                Label viewScope = new Label("The annotation @ViewScope, which makes the lifecycle and injection of instances of this bean view specific.");
                viewScope.addStyleName("small");
                viewScope.setCaption("@ViewScope");
                addComponent(viewScope);

            }
        };
        p.setContent(content);
        return p;

    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);

        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));

        return button;
    }
}
