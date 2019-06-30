maven环境搭建工程，集成tomcat插件启动工程，ssm框架整合dao层和service层。

理解（SSM框架整合之springmvc整合及父子容器的关系）
dubbo框架搭建，发布和引用 dubbo 服务  从而实现一个查询商品详情接口

启动linx zookeeper 并配置服务地址 
查询接口地址：http://localhost:8081/item/830972
https://www.cnblogs.com/1315925303zxz/p/7211037.html
https://blog.csdn.net/weixin_39202006/article/details/78870963

服务启动过程：
1.启动打开虚拟机
2.进入centos7 的/root/zookeeper/zookeeper-3.4.14/bin目录，使用命令./zkServer.sh start来启动zookeeper，启动完之后，我们可以使用./zkServer.sh status来查看启动状态
3.检查代码中发布服务和引用服务用到的ip和端口对不对
4.先启动taotao-manager服务， run 右键 maven-install，输入clean tomcat7:run     再启动taotao-manager-web服务 
5.发送http请求http://localhost:8081/item/830972   可以正确的得到json 数据
{"id":830972,"title":"飞利浦 老人手机 (X2560) 深情蓝 移动联通2G手机 双卡双待","sellPoint":"赠：九安血压计+8G内存！超长待机，关爱无限，更好用！飞利浦简单健康老人手机！外观圆滑，手感极佳！","price":48900,"num":99999,"barcode":null,"image":"http://image.taotao.com/jd/4f1d41baa6c84219a622f20a4f1c32bb.jpg","cid":560,"status":1,"created":1425821310000,"updated":1425821310000}
说明启动成功



启动tomct  并且查看dubbo监控中心
1.进入/root/apache-tomcat-9/apache-tomcat-9.0.21 目录
2.执行bin/startup.sh
3.使用tailf logs/catalina.out来跟踪启动过程。
4.启动成功后，我们访问dubbo的地址：http://192.168.156.40:8080/dubbo-admin/，会让我们输入用户名和密码，默认都是root。
启动Tomcat命令    ./startup.sh
停止Tomcat服务命令./shutdown.sh


查看ip 指令： ip addr 
新建文件夹： mkdir /usr/java
解压缩文件：tar -zxvf jdk-7u80-linux-x64.gz -C /usr/java
编辑文件：vim /etc/profile   
Shift+G 快速到文件末尾   按a或者i进入编辑模式  底部会有insert显示
按esc 键，输入:wq  保存并推出    :!q 不保存推出


