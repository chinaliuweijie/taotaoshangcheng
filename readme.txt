maven��������̣�����tomcat����������̣�ssm�������dao���service�㡣

��⣨SSM�������֮springmvc���ϼ����������Ĺ�ϵ��
dubbo��ܴ������������ dubbo ����  �Ӷ�ʵ��һ����ѯ��Ʒ����ӿ�

����linx zookeeper �����÷����ַ 
��ѯ�ӿڵ�ַ��http://localhost:8081/item/830972
https://www.cnblogs.com/1315925303zxz/p/7211037.html
https://blog.csdn.net/weixin_39202006/article/details/78870963

�����������̣�
1.�����������
2.����centos7 ��/root/zookeeper/zookeeper-3.4.14/binĿ¼��ʹ������./zkServer.sh start������zookeeper��������֮�����ǿ���ʹ��./zkServer.sh status���鿴����״̬
3.�������з�����������÷����õ���ip�Ͷ˿ڶԲ���
4.������taotao-manager���� run �Ҽ� maven-install��������taotao-manager-web,�Ҽ�maven-build������clean tomcat7:run     ������taotao-manager-web���� 
5.����http����http://localhost:8081/item/830972   ������ȷ�ĵõ�json ����
{"id":830972,"title":"������ �����ֻ� (X2560) ������ �ƶ���ͨ2G�ֻ� ˫��˫��","sellPoint":"�����Ű�Ѫѹ��+8G�ڴ棡�����������ذ����ޣ������ã������ּ򵥽��������ֻ������Բ�����ָм��ѣ�","price":48900,"num":99999,"barcode":null,"image":"http://image.taotao.com/jd/4f1d41baa6c84219a622f20a4f1c32bb.jpg","cid":560,"status":1,"created":1425821310000,"updated":1425821310000}
˵�������ɹ�
6.activitemq �������� binĿ¼�£�Ȼ��ʹ������./activemq start��������




����tomct  ���Ҳ鿴dubbo�������
1.����/root/apache-tomcat-9/apache-tomcat-9.0.21 Ŀ¼
2.ִ��bin/startup.sh
3.ʹ��tailf logs/catalina.out�������������̡�
4.�����ɹ������Ƿ���dubbo�ĵ�ַ��http://192.168.156.40:8080/dubbo-admin/���������������û��������룬Ĭ�϶���root��
����Tomcat����    ./startup.sh
ֹͣTomcat��������./shutdown.sh


�鿴ip ָ� ip addr 
�½��ļ��У� mkdir /usr/java
��ѹ���ļ���tar -zxvf jdk-7u80-linux-x64.gz -C /usr/java
�༭�ļ���vim /etc/profile   
Shift+G ���ٵ��ļ�ĩβ   ��a����i����༭ģʽ  �ײ�����insert��ʾ
��esc ��������:wq  ���沢�Ƴ�    :q�� �������Ƴ�

��װvim ��  yum install vim
��װgcc��yum install gcc-c++


gitignoreֻ�ܺ�����Щԭ��û�б�track���ļ������ĳЩ�ļ��Ѿ��������˰汾�����У����޸�.gitignore����Ч��
����취
git rm -r --cached .
git add .
git commit -m 'update .gitignore'



git �ύ����   ---
1.clone�Լ�github�ϵĴ���
git clone https://github.com/gubai/gubai.git
5.git pull   ��ȥ����  ���´���
2.git status�鿴״̬
3.git add *   add���뻺����
4.git commit -m "����˵��"      commitֻ���ύ����������
6.git push origin master   push��Զ��master��֧��

�������⣬�������Ʒ��ʱ��
 �����Ʒ����Ʒ������Ӧ�Ķ��ǵ���������������ʹ�����򹤳����ɵĴ��뼴�ɣ�Ҳ����˵���ǲ���дDao��Ĵ��롣����������дService����룬������ItemService�ӿڵ������һ��"�����Ʒ"�Ľӿڣ���һ���ӿ�Ҫ�������ű�һ������Ʒ����һ������Ʒ������������ͼ��ʾ��������������һ������Ʒ���pojo����һ������Ʒ������֮����Ҫ�׳��쳣����Ϊ����ӿ�Ҫ�������ű����������ű�Ĳ���Ҫ���ɹ��Žгɹ�����������ͻع�������쳣Ҫ�����ף���ʵ��������в�����try catch�������쳣����Ϊ�����Ļ�springmvc����Ϊ�������������ˣ��㲻��ع���


redis:����ʹ�ú�̨����

[root@redis bin]# ./redis-server redis.conf
�鿴�Ƿ�������ps -ef|grep redis��ps aux | grep redis
���Է���
       ʹ��./redis-cli������redis����Ȼ��ʹ��ping���������ص���PONG��˵������û����
redis ��centos 7 �������Ӳ��ϣ� 1.ע�͵�redis.conf�ļ��� bind 127.0.0.1;2.�ر��������ǽ3.����


����ÿ��Redisʵ��:����/usr/local/redis-clusterĿ¼��redis-clusterĿ¼��ʹ��vim start-all.sh����������һ���������ļ�  ./start-all.sh����������ÿ��Redisʵ��
ʹ��ps aux|grep redis�������鿴ÿһ��Redisʵ������������
redis ��Ⱥ������
���� cd /usr/local/redis-5.0.5/src��ִ��
./redis-cli --cluster create 192.168.121.131:7001 192.168.121.131:7002 192.168.121.131:7003 192.168.121.131:7004 192.168.121.131:7005 192.168.121.131:7006 --cluster-replicas 1
�������ӣ�

./redis-cli -h 192.168.121.131 -p 7003 -c
set key1 123

ʹ������cluster info�鿴��Ⱥ��ĳЩ��Ϣ
ͨ������cluster nodes���鿴�ڵ���Ϣ


solr ����tomcat �ͺ��� bin/startup.sh tailf logs/catalina.out
   solr ���ֶ�
   <field name="item_title" type="text_ik" indexed="true" stored="true"/>
   <field name="item_sell_point" type="text_ik" indexed="true" stored="true"/>
   <field name="item_price"  type="plong" indexed="true" stored="true"/>
   <field name="item_image" type="string" indexed="false" stored="true" />
   <field name="item_category_name" type="string" indexed="true" stored="true" />
   <field name="item_desc" type="text_ik" indexed="true" stored="false" />

<field name="item_keywords" type="text_ik" indexed="true" stored="false" multiValued="true"/>
<copyField source="item_title" dest="item_keywords"/>
<copyField source="item_sell_point" dest="item_keywords"/>
<copyField source="item_category_name" dest="item_keywords"/>
<copyField source="item_desc" dest="item_keywords"/>



����ʼǱ���������:                    ��˾�������ã�
zookeeper activemq��ַ��31.130                  121.128
redis ��ַ��    31.132                  121.131  
fastdfs��ַ:    31.131                  121.130
solr ��ַ��     31.133                  121.132
mysql�û������룺 root ""                 root   root

163 ������Ȩ�����룺qwert12345

linux mysql������service mysqld start   ����mysql����:service mysqld restart
����mycat������mycatĿ¼��bin/mycat start  �鿴״̬��bin/mycat status


