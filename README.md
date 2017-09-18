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
 
 ************
 @Controller 主要给控制器的注解<br>
 @RestController 等同于 @ResponseBody+@Controller<br>
 @RequestMapping 可以写在方法前，类的前面<br>
 @PathVariable<br>
 @RequestParam(value="",defaultValue="",required=false)<br>
 @GetMapping @PostMapping 省略写法<br>
 
 ************
 添加依赖
 spring-boot-starter-data-jpa
 mysql-connector-java<br>
 想用h2缓存数据库作为演示
 spring:
   datasource:
     password: sa
     driver-class-name: org.h2.Driver
     url: jdbc:h2:file:~/.h2/testdb
     username: sa
   jpa:
     hibernate:
       ddl-auto: create
     show-sql: true
 
 怎么理解H2？<br>
 其实就是一个数据文件数据库，我们可以用h2的驱动去解析成数据库，结构化地去访问
 一般可以用于演示，测试使用，也可以作为缓存数据库，jdbc:h2:file:~/.h2/testdb
 这里的~代表 c:/users/administrator/的目录
 搞了挺长时间的， 去掉file是相对路径，否则是绝对路径。在Ideal的使用过程中，我们会遇到
 问题，就是成功连接上了文件，但始终看不到我们创建的表，需要在配置中设置下我们能看到的schema，设置为ALL
 因为我们创建的表在PUBLIC schema中<br>
 多数据源的配置放到后面讲：http://blog.csdn.net/catoop/article/details/50575038<br>
 
 创建对应的实体类，看看效果。先简单 Student id name sex classid
ddl-auto: create update
 
