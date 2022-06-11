[中文](README-zh_CN.md)

2. `git clone https://github.com/xtherk/bytehook-examples.git`
3. Open your IDEA and load `bytehook-examples` project
4. Compile `bytehook-examples` project
5. Run `Main` and view print result
6. Please add VM option `-javaagent:/your/path/bytehook-agent.jar -Dbh.agent.init.disabled=true`

   > `-Dbh.agent.init.disabled=true` The purpose of disable the initialization of `javaagent` is to add module resource paths in the dev-environment
7. Run `Main` and view print result again

