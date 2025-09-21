package org.example;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld app = new HelloWorld();

        String greeting = app.generateGreeting("World");
        String farewell = app.generateFarewell("User");

        app.renderMessage(greeting);
        app.renderMessage(farewell);
    }

    public String generateGreeting(String name) {
        String username = System.getProperty("user.name");
        return "Hello " + name + "! Current user: " + username;
    }

    public String generateFarewell(String name) {
        java.time.LocalTime now = java.time.LocalTime.now();
        return "Goodbye " + name + "! Current time: " + now;
    }

    public void renderMessage(String message) {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(80).height(10);
        builder.element(new PseudoText(message));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }
}