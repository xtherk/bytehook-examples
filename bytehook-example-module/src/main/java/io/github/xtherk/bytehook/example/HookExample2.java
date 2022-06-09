package io.github.xtherk.bytehook.example;

import io.github.xtherk.bytehook.HookClass;
import io.github.xtherk.bytehook.HookMethod;
import io.github.xtherk.bytehook.TargetClass;

/**
 * @author xtherk
 */
@HookClass("io.github.xtherk.bytehook.example.Example2")
public class HookExample2 {

    /**
     * You only need to keep the method (name & signature)
     * and target method of the same
     */
    @HookMethod
    public static void sayName(@TargetClass Example2 instance) {
        System.out.println("Hello " + instance.getName());
    }
}
