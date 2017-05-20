package com.github.mikan;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
public class HelloWorld extends UI {
    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);
        content.addComponent(new Label("Hello World!"));
        Button button = new Button("すごーい!", click -> Notification.show("たーのしー!"));
        button.setId("selenide-amazing-button"); // UI テストからの参照用
        content.addComponent(button);
    }
}
