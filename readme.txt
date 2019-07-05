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
4.先启动taotao-manager服务， run 右键 maven-install，再启动taotao-manager-web,右键maven-build，输入clean tomcat7:run     再启动taotao-manager-web服务 
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
按esc 键，输入:wq  保存并推出    :q！ 不保存推出



gitignore只能忽略那些原来没有被track的文件，如果某些文件已经被纳入了版本管理中，则修改.gitignore是无效的
解决办法
git rm -r --cached .
git add .
git commit -m 'update .gitignore'



git 提交代码   ---
1.clone自己github上的代码
git clone https://github.com/gubai/gubai.git
5.git pull   拉去代码  更新代码
2.git status查看状态
3.git add *   add代码缓冲区
4.git commit -m "更新说明"      commit只是提交到缓存区域
6.git push origin master   push到远程master分支上

事物的理解，在添加商品的时候：
 添加商品和商品描述对应的都是单表操作，因此我们使用逆向工程生成的代码即可，也就是说我们不用写Dao层的代码。下面我们来写Service层代码，首先在ItemService接口当中添加一个"添加商品"的接口（这一个接口要操作两张表，一张是商品表，另一张是商品描述表）。如下图所示，参数有两个，一个是商品表的pojo，另一个是商品描述。之所以要抛出异常是因为这个接口要操作两张表，而且这两张表的操作要都成功才叫成功，否则事务就回滚，因此异常要向上抛，在实现类代码中不能用try catch来捕获异常，因为这样的话springmvc会认为代码正常结束了，便不会回滚。





