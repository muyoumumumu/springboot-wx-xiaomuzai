package club.muyoumumumu.springbootwxxiaomuzai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TextMessageUtil {
    //消息转化为xml
    public String TextMessageUtil(BaseMessage mt) {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        //xmlMapper.setDefaultUseWrapper(false);
        try {
            String xmlStr = xmlMapper.writeValueAsString(mt);
            return xmlStr;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
