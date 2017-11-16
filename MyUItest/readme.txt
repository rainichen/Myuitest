作者：zlc 时间;2017-11-4
本项目主要做前端框架  LCUI 的开发测试

1、重新设置自增的id
table_name是表名,10表示自增开始的位置
alter table table_name AUTO_INCREMENT=10;

2、<script type="text/html"></script> js模版使用
1.首先这种写，在页面渲染的时候，浏览器不会读取script标签中的html代码
2.外面不能获取到里面的div节点
所以：    在使用时，要在script标签上加个ID可以供我们找到它，


3、css选择器
$('.demoTable .layui-btn') 之见不能有空格  .demoTable是.layui-btn 父级


4、其他项目使用此模板，修改内容：
修改daoxml    <property name="basePackage" value="com.lcui.mapper"/>   value填写自己的xml包
service.xml     填写自己新建的service
springmvc.xml    <context:component-scan base-package="com.lcui.controller">       base-package填写自己的controller包

5、修改webxml
前端控制器   DispatcherServlet
post乱码过滤器   CharacterEncodingFilter


6、json的key-value定义
以"String":object 格式定义, 如果object改变,通过key获取的object不会改变,必须再次赋值

7、json格式的字符串，转换成json对象
形如mystringjson='{"key1":"value1","key2":"value2","key3":"value3"}';          
方法：        eval("("+mystringjson+")")