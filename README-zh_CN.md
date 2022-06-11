1. `git clone https://github.com/xtherk/bytehook-examples.git`
2. 打开IDEA并加载`bytehook-examples`项目
3. 编译 `bytehook-examples`项目
4. 运行`Main`并查看控制台打印结果
5. 请添加VM Option `-javaagent:/your/path/bytehook-agent.jar -Dbh.agent.init.disabled=true`

   > `-Dbh.agent.init.disabled=true`的作用是为了禁止`bytehook-agent`对模块进行初始化，改为由我们程序控制何时初始化（Modules#initialize()），方便添加模块资源路径。
   > 该选项一般无需使用，唯一的用途就是开发环境方便调试
6. 再次运行`Main`并查看控制台打印结果

