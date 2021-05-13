package com.lcp.im.framework.beans.config;

import com.lcp.im.framework.handler.prop.PropHandler;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-14:15
 */
@Deprecated
public class PropItemInfo<O> {

  private PropHandler<O> propHandler;

  public PropItemInfo() {
  }

  public PropItemInfo(PropHandler<O> propHandler) {
    this.propHandler = propHandler;
  }

  public PropItemInfo(String key, String value, PropHandler<O> propHandler) {
    this.propHandler = propHandler;
  }

  public PropHandler<O> getPropHandler() {
    return propHandler;
  }

  public final void setPropHandler(PropHandler<O> propHandler) {
    this.propHandler = propHandler;
  }

}
