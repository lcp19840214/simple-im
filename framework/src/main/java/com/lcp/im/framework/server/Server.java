package com.lcp.im.framework.server;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-12:15
 */
public interface Server {

  /**
   * 服务启动
   *
   * @return
   */
  boolean start();

  /**
   * 服务停止
   *
   * @return
   */
  boolean stop();
}
