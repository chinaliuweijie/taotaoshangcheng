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





