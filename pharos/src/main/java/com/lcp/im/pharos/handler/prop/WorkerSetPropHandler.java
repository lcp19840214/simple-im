package com.lcp.im.pharos.handler.prop;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

import com.lcp.im.framework.beans.config.WorkerInfo;
import com.lcp.im.framework.handler.prop.AbstractPropHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * desc:  得到worker集合  <br/>
 *
 * @author lichunpeng
 * @since 2021/5/11-13:30
 */
public class WorkerSetPropHandler extends AbstractPropHandler<Set<WorkerInfo>> {

  @Override
  public Set<WorkerInfo> getTargetValue() {

    if (StringUtils.isEmpty(value)) {
      return new HashSet<>();
    }

    try {
      return Arrays.stream(value.split(","))
          .map(item -> item.split(":"))
          .map(array -> new WorkerInfo(array[INTEGER_ZERO], Integer.parseInt(array[INTEGER_ONE])))
          .collect(Collectors.toSet());
    } catch (Exception ex) {
      logger.error("exchange worker set exception:{}", value);
      return new HashSet<>();
    }
  }

}
