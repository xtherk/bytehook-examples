package io.github.xtherk.bytehook;

import io.github.xtherk.bytehook.example.Example1;
import io.github.xtherk.bytehook.example.Example2;
import io.github.xtherk.bytehook.example.Example3;
import io.github.xtherk.bytehook.util.ThreadUtil;

import java.io.FileNotFoundException;
import java.nio.file.Path;

/**
 * @author xtherk
 */
public class Main {

    private static final String BYTEHOOK_EXAMPLE_MODULE_NAME = "bytehook-example-module";

    static {
        try {
            Path modulePath = ResourceUtils.getByteHookModulePath(BYTEHOOK_EXAMPLE_MODULE_NAME);
            // Add bytehook module, easy to develop debugging
            Modules.addModuleResource(modulePath);
            Modules.initialize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Please add VM option <code>-javaagent:/your/path/bytehook-agent.jar</code>
     */
    public static void main(String[] args) {
        while (!Modules.initialized) {
            ThreadUtil.quietSleep(5);
        }
        Example1.sayHello();
        // Maybe will print Hi Lily,
        // Maybe will print Hello Lily
        // You can try to run a few more times

        // Example2 may be loaded because of prematurely,
        // causing Bytehook to not hook yet Example2
        new Example2().sayName();

        // Let Bytehook have enough time to hook
        ThreadUtil.quietSleep(50);
        // Will print Hello Lily
        new Example2().sayName();
        new Example3().sayAnything("Bytehook");
    }
}
