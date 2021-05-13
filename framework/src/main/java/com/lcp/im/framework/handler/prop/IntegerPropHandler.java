package com.lcp.im.framework.handler.prop;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-11:14
 */
public class IntegerPropHandler extends AbstractPropHandler<Integer> {

  @Override
  public Integer getTargetValue() {
    return Integer.valueOf(value);
  }
}
