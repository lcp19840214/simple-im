package com.lcp.im.pharos.config;

import static com.lcp.im.pharos.handler.prop.consts.PharosPropConst.PARTNER_PHAROS_LIST;
import static com.lcp.im.pharos.handler.prop.consts.PharosPropConst.WORKER_LIST;

import com.lcp.im.framework.components.prop.DefaultPropReader;
import com.lcp.im.framework.components.prop.PropReader;
import com.lcp.im.framework.handler.prop.PropHandler;
import com.lcp.im.pharos.handler.prop.PartnerPharosSetPropHandler;
import com.lcp.im.pharos.handler.prop.WorkerSetPropHandler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-16:39
 */
@Configuration
@ComponentScan({
    "com.lcp.im.pharos.handler.prop",
    "com.lcp.im.pharos.server"
})
public class BasicConfig {

  @Bean("defaultPropReader")
  public PropReader buildDefaultPropReader() {
    Map<String, PropHandler> propHandlerMap = new HashMap<>();
    propHandlerMap.put(PARTNER_PHAROS_LIST, new PartnerPharosSetPropHandler());
    propHandlerMap.put(WORKER_LIST, new WorkerSetPropHandler());

    var propReader = new DefaultPropReader(propHandlerMap, "pharos.properties");
    propReader.init();
    return propReader;
  }

}
