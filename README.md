# Springboot Learning
作者：钱云龙 422931278@qq.com 15921613518<br>
学习springboot视频操作的代码，供参考

<b>UNIT ONE</b><br>
1 创建工程 <br>
2 项目属性配置 <br>
3 创建Controller <br>
4 数据库的创建<br>
5 事务的处理<br>

************

 configValue: this is a test<br>
 @Value("${configValue}")<br>
 private String configValue;<br>
 配置里面在使用属性</br>
 @Component<br>
 @ConfigurationProperties(prefix = "projectConfig")
 
 在不同环境下面切换配置文件</br>
 java -jar target/***.jar --spring.profiles.active=prod
