package org.example;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld app = new HelloWorld();

        // Use the original two methods
        String greeting = app.generateGreeting("World");
        String farewell = app.generateFarewell("User");

        // NEW: Use native language greeting
        String nativeGreeting = app.getGreeting("hungarian") + " Világ!";

        // Use ASCII Renderer to display all messages
        app.renderMessage(greeting);
        app.renderMessage(farewell);
        app.renderMessage(nativeGreeting);  // NEW LINE
    }

    // Method 1 - will be modified in branchA
    public String generateGreeting(String name) {
        return "Hello " + name + "!";
    }

    // Method 2 - will be modified in branchB
    public String generateFarewell(String name) {
        return "Goodbye " + name + "!";
    }

    // NEW METHOD: Your original getGreeting method for native languages
    public String getGreeting(String language) {
        switch (language.toLowerCase()) {
            case "english":
            case "eng":
                return "Hello";
            case "hungarian":
            case "hun":
                return "Szia";
            case "arabic":
            case "ar":
                return "Marhaba";
            default:
                return "Hello";
        }
    }

    // ASCII Renderer method using the external library
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