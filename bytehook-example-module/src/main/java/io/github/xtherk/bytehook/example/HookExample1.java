package io.github.xtherk.bytehook.example;

import io.github.xtherk.bytehook.HookClass;
import io.github.xtherk.bytehook.HookMethod;

/**
 * @author xtherk
 */
@HookClass("io.github.xtherk.bytehook.example.Example1")
public class HookExample1 {

    /**
     * You only need to keep the method (name & signature)
     * and target method of the same
     */
    @HookMethod
    public static void sayHello() {
        System.out.println("Hello bytehook!");
    }
}
