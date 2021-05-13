package com.lcp.im.framework.beans.config;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-13:44
 */
public abstract class NodeInfo {

  private String address;
  private int port;

  public NodeInfo() {
  }

  public NodeInfo(String address, int port) {
    this.address = address;
    this.port = port;
  }

  public String getAddress() {
    return address;
  }

  public final void setAddress(String address) {
    this.address = address;
  }

  public int getPort() {
    return port;
  }

  public final void setPort(int port) {
    this.port = port;
  }


}
