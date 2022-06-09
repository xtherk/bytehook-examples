1. `git clone https://github.com/xtherk/bytehook-examples.git`
2. Open your IDEA and load `bytehook-examples` project
3. Compile `bytehook-examples` project
4. Run `Main` and view print result
5. Please add VM option `-javaagent:/your/path/bytehook-agent.jar -Dbh.agent.init.disabled=true`

   > `-Dbh.agent.init.disabled=true` The purpose of disable the initialization of `javaagent` is to add module resource paths in the dev-environment
6. Run `Main` and view print result again

