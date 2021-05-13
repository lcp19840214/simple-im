package com.lcp.im.pharos.server;

import com.lcp.im.framework.beans.config.PharosInfo;
import com.lcp.im.framework.beans.config.WorkerInfo;
import java.util.Set;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-12:21
 */
public abstract class AbstractPharosServer {

  protected Set<PharosInfo> partnerPharosSet;//合作灯塔
  protected Set<WorkerInfo> workerSet;//worker set

  public final void setPartnerPharosSet(Set<PharosInfo> partnerPharosSet) {
    this.partnerPharosSet = partnerPharosSet;
  }

  public final void setWorkerSet(Set<WorkerInfo> workerSet) {
    this.workerSet = workerSet;
  }


}
