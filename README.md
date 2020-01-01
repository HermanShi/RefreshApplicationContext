# 配置文件动态加载

动态加载配置文件中的配置项到spring的applicationContext中

代码逻辑较为简单，应该都能看懂，此处只是提供一种实现方式。

仅供参考，如上线生产环境，需完善

使用场景：

- 手动修改配置项，自动生效，无需重启，仅刷新被@Refresh标记的bean
- 配置文件已由别的程序自动更新，仅处理java项目的自动刷新配置