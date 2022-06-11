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
        initialize();
    }

    /**
     * In fact, it is not necessary to initialize the modules in the application.
     * It should be initialized by agent.
     * This is just to facilitate the demo.
     */
    private static void initialize() {
        try {
            Path modulePath = ResourceUtils.getByteHookModulePath(BYTEHOOK_EXAMPLE_MODULE_NAME);
            if (null != modulePath) {
                // Just for the development environment, Add bytehook module, easy to develop debugging
                Modules.addModuleResource(modulePath);
                Modules.initialize();
                // Just to wait for the initialization
                // It's also possible to remove
                while (!Modules.initialized) {
                    ThreadUtil.quietSleep(5);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Please add VM option <code>-javaagent:/your/path/bytehook-agent.jar -Dbh.agent.init.disabled=true</code>
     * <p>
     * <code>-Dbh.agent.init.disabled=true</code> <br>
     * The purpose of disable the initialization of java agent is to add module resource paths in the dev-env
     */
    public static void main(String[] args) {
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
