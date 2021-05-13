package com.lcp.im.worker.config;

import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_BOSS_THREAD_COUNT;
import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_PORT;
import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_WORKER_THREAD_COUNT;

import com.lcp.im.framework.components.prop.PropReader;
import com.lcp.im.framework.handler.prop.PropHandler;
import com.lcp.im.worker.server.WorkerServer;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-10:38
 */
@Configuration
public class WorkerServerConfig {

  @Resource
  private PropReader propReader;

  @Bean("defaultWorkerServer")
  public WorkerServer buildWorkerServer() {
    PropHandler<Integer> portHandler = propReader.get(WORKER_SERVER_PORT);
    PropHandler<Integer> bossThreadCountHandler = propReader.get(WORKER_SERVER_BOSS_THREAD_COUNT);
    PropHandler<Integer> workerThreadCountHandler = propReader.get(WORKER_SERVER_WORKER_THREAD_COUNT);

    return new WorkerServer(
        bossThreadCountHandler.getTargetValue(),
        workerThreadCountHandler.getTargetValue(),
        portHandler.getTargetValue()
    );
  }

}
