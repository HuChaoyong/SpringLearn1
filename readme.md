# IOC
Inversion of Control 
* 传统的资源查找方式,是组件像容器发送资源请求,容器响应,并返回资源.
* 而 IOC是, 容器主动将资源推送给它所管理的组件,组件所要做的是,选择一种合适的方式来接收资源.

### IOC容器的实现有两种
*   BeanFactory  是Spring的基础设置,面向 Spring本身
*   ApplicationContext, 面向 Spring开发者,几乎所有场合都直接使用 ApplicationContext 而非BeacFactory
1.  ClassPathXmlApplicationContext : 从类路径下加载配置文件
2. FileSystemXmlApplicationContext :从文件系统加载配置文件

# DI
Dependency Injection 依赖注入
*   即组件以一些预先定义好的方式(如 Setter方法) 接收来自容器资源注入

