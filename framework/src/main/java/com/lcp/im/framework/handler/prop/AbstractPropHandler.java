package com.lcp.im.framework.handler.prop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-10:59
 */
public abstract class AbstractPropHandler<O> implements PropHandler<O> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  protected String key;
  protected String value;

  @Override
  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }
}
