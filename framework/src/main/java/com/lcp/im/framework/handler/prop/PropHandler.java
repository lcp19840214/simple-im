package com.lcp.im.framework.handler.prop;

/**
 * desc: 属性处理器   <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-13:28
 */
public interface PropHandler<O> {

  void setKey(String key);

  void setValue(String value);

  O getTargetValue();

}
