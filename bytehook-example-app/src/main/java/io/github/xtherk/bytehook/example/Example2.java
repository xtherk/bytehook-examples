package io.github.xtherk.bytehook.example;

/**
 * @author xtherk
 */
public class Example2 {

    private String name = "Lily";

    public void sayName() {
        System.out.printf("Hi %s%n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
