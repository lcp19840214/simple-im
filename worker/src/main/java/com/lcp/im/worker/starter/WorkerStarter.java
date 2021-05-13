package com.lcp.im.worker.starter;

import com.lcp.im.worker.server.WorkerServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-10:37
 */
public class WorkerStarter {

  public static void main(String[] args) {

    var applicationContext = new AnnotationConfigApplicationContext("com.lcp.im.worker.config");
    var workerServer = applicationContext.getBean(WorkerServer.class);
    workerServer.start();
  }

}
