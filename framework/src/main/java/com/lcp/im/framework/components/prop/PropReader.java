package com.lcp.im.framework.components.prop;

import com.lcp.im.framework.handler.prop.PropHandler;

/**
 * desc:  属性读取  <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-14:00
 */
public interface PropReader {

  void init();

  <O> PropHandler<O> get(String key);

}
