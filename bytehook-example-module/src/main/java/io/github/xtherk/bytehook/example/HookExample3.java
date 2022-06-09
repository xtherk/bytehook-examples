package io.github.xtherk.bytehook.example;

import io.github.xtherk.bytehook.HookClass;
import io.github.xtherk.bytehook.HookMethod;
import io.github.xtherk.bytehook.TargetClass;

/**
 * @author xtherk
 */
@HookClass("io.github.xtherk.bytehook.example.Example3")
public class HookExample3 {

    /**
     * When the method signature is inconsistent,
     * you need to specify the method name and signature
     * in the annotation.
     */
    @HookMethod(methodName = "sayAnything", desc = "(Ljava/lang/String;)V")
    public static void sayBye(Object anything) {
        System.out.println("value is :" + anything);
        System.out.println("Bye~Bye~");
    }
}
