package com.lcp.im.worker.config;

import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_BOSS_THREAD_COUNT;
import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_PORT;
import static com.lcp.im.worker.handler.prop.consts.WorkerPropConst.WORKER_SERVER_WORKER_THREAD_COUNT;

import com.lcp.im.framework.components.prop.DefaultPropReader;
import com.lcp.im.framework.components.prop.PropReader;
import com.lcp.im.framework.handler.prop.IntegerPropHandler;
import com.lcp.im.framework.handler.prop.PropHandler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-10:47
 */
@Configuration
public class PropConfig {

  @Bean("defaultPropReader")
  public PropReader buildDefaultPropReader() {
    Map<String, PropHandler> propHandlerMap = new HashMap<>();
    propHandlerMap.put(WORKER_SERVER_PORT, new IntegerPropHandler());
    propHandlerMap.put(WORKER_SERVER_BOSS_THREAD_COUNT, new IntegerPropHandler());
    propHandlerMap.put(WORKER_SERVER_WORKER_THREAD_COUNT, new IntegerPropHandler());

    var propReader = new DefaultPropReader(propHandlerMap, "worker.properties");
    propReader.init();

    return propReader;
  }

}
