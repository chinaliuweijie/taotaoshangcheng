package com.taotao.order.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderJob {
   //执行任务
   public void execute(){
	   
	   Date date=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println("任务已经执行。。。。。 It is my frist job "+sdf.format(date));

   }
}