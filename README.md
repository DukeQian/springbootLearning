# Springboot Learning
作者：钱云龙 422931278@qq.com 15921613518<br>
学习springboot视频操作的代码，供参考

廖师兄视频学习记录<br>
spring-boot 基础
http://www.imooc.com/learn/767<br>
spring-boot-web 基础
http://www.imooc.com/learn/810<br>
spirng-boot-projecct 项目实践 http://coding.imooc.com/learn/list/117.html

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
 文件同时访问我一直搞不定，了解了下./ file: tcp的区别
 其实就是一个数据文件数据库，我们可以用h2的驱动去解析成数据库，结构化地去访问
 一般可以用于演示，测试使用，也可以作为缓存数据库，jdbc:h2:file:~/.h2/testdb
 这里的~代表 c:/users/administrator/的目录
 搞了挺长时间的， 去掉file是相对路径，否则是绝对路径。在Ideal的使用过程中，我们会遇到
 问题，就是成功连接上了文件，但始终看不到我们创建的表，需要在配置中设置下我们能看到的schema，设置为ALL
 因为我们创建的表在PUBLIC schema中<br>
 多数据源的配置放到后面讲：http://blog.csdn.net/catoop/article/details/50575038<br>
 
 创建对应的实体类，看看效果。先简单 Student id name sex classid
ddl-auto: create update<br>

1 添加一个数据项 <br>
2 然后查询该数据项 <br>
3 当查询不到数据的时候，返回为空<br>
4 增删改查的操作<br>
5 通过年龄来查询<br>

关于一些jpa查询的拓展
http://www.cnblogs.com/rulian/p/6533109.html<br>

@Transactional 在service层中添加了事物，如果异常被抛出则回滚<br>


****************
<b>UNIT TWO</b><br>
1 表单验证 <br>
2 AOP请求处理 <br>
3 异常处理 <br>
************************
对于项目重新的整理，项目的路径，可以再学习下git的操作<br>
git checkout -b web-2 web-2

Spring-boot 对于表单的支持也特别方便
BindingResult, 同时添加@Valid的注解

关于VUE的课程学习  http://www.imooc.com/learn/796<br>

AOP的基本概念

************************
spring-boot-starter-aop

在访问方法前面，记录日志，知道进入了方法体内
@Aspect
@Component注解
同时在里面的方法前面加入根据适配符号找到对应的方法集合
@Before("execution(public * com.example.one.controller.TestController.queryStudent(..))")
<br>

@PointCut注解，切点，让切面直接引入的概念

案例是：
在方法的前面可以直接打印出请求的地址，请求的类型，方法名，参数，同时打印出返回的结果
@AfterReturning(returning = "object", pointcut = "log()")
public void doAfterReturning(Object object)

************************
异常处理
当某些条件不满抛出信息。
1 不够资格，权限，次数
2 代码空指针，越界
3 数据库的异常

返回格式要统一
【code  message data】
然后提供一些工具类，代码公共部分的封装，格式统一，这样代码很清爽了。
把所有的逻辑放到service中
设标记返回不通的结果。

统一遇到异常返回相同的结果类型
把异常拼命往外抛，抛给异常处理器去处理
定义自定义异常 
@ControllerAdvice
@ExceptionHandler
对于其他异常，我们该如何处理。先打印下日志
异常中code， message统一地进行管理起来,通过枚举去实现

**************************
单元测试
你把bug的程序丢给别人测试，这个很不负责的行为。当然像领导，事物繁忙，或者逻辑复杂，测试环境问题。

@RunWith(SpringRunner.class)
@SpringBootTest
@Test注解

Assert.assertEqual(13, 13);

通过IDE快速的创建测试案例

方法的请求， URL的测试
@AutoConfigureMocked
MockMvc mvc;
mvc.perform  MockRequestBuilders.get


mvn clean package -Dmaven.test.skip=true


最后看下DOCKER的视频，将开发
http://www.imooc.com/video/15640

对开发，运维,测试都是很有帮助的技术 linux  bash
镜像容器， 多容器app, 容器存储， registry

sudo wget -qO- https://get.docker.com | sh ,
安装没啥说的，命令行说一下

docker run 镜像名称 echo hello docker
docker run nginx
docker images -p 8080:80 -d
docker ps
docker cp index.html 镜像ID 镜像内部的文件路径://**/**
docker stop
docker commit -m 'fun' id
docker rmi id







 
