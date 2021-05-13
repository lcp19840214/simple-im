package check;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcp.im.framework.beans.config.PharosInfo;
import com.lcp.im.framework.beans.config.WorkerInfo;
import com.lcp.im.framework.components.prop.PropReader;
import com.lcp.im.pharos.config.BasicConfig;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BasicConfig.class)
public class PropTest {

  private final Logger logger = LoggerFactory.getLogger(PropTest.class);

  @Resource(name = "defaultPropReader")
  private PropReader defaultPropReader;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void test12() {

    // objectMapper.enable(SerializationFeature.INDENT_OUTPUT);// 转换为格式化的json
    // objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 如果json中有新增的字段并且是实体类类中不存在的，不报错

    Set<PharosInfo> pharosInfoSet = (Set<PharosInfo>) defaultPropReader.get("partner.pharos.list").getTargetValue();
    pharosInfoSet.forEach(pharosInfo -> print(pharosInfo, "pharosInfo"));

    Set<WorkerInfo> workerInfoSet = (Set<WorkerInfo>) defaultPropReader.get("partner.pharos.list").getTargetValue();
    workerInfoSet.forEach(workerInfo1 -> print(workerInfo1, "workerInfo"));

  }

  private void print(Object object, String title) {
    try {
      logger.info("{} = {}", title, objectMapper.writeValueAsString(object));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
