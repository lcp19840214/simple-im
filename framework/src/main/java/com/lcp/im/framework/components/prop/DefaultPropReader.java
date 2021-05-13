package com.lcp.im.framework.components.prop;


import com.lcp.im.framework.handler.prop.PropHandler;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * desc:  属性读取  <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-14:04
 */
public class DefaultPropReader implements PropReader {

  private final Properties properties = new Properties();
  private final String propertiesFilePath;

  private Map<String, PropHandler> propHandlerMap;


  public DefaultPropReader(Map<String, PropHandler> propHandlerMap, String propertiesFilePath) {
    this.propHandlerMap = propHandlerMap;
    this.propertiesFilePath = propertiesFilePath;
  }

  @Override
  public void init() {

    // 使用ClassLoader加载properties配置文件生成对应的输入流
    var inputStream = DefaultPropReader.class.getClassLoader().getResourceAsStream(propertiesFilePath);

    // 使用properties对象加载输入流
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    //设定key value
    propHandlerMap.keySet().forEach(key -> {
      var propHandler = propHandlerMap.get(key);
      propHandler.setKey(key);
      propHandler.setValue(properties.getProperty(key));
    });
  }


  @Override
  public <E> PropHandler<E> get(String key) {
    return propHandlerMap.get(key);
  }
}
