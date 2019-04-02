package club.muyoumumumu.springbootwxxiaomuzai;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class RebackMessageText extends BaseMessage {
    private String Content;// 文本消息内容

    private String MsgId;// 消息id，64位整型

    public RebackMessageText(String toUserName, String fromUserName, long createTime, String msgType, String content) {
        super();
        this.toUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Content = content;
    }

    public RebackMessageText() {
    }

    @Override
    public String toString() {
        return "MessageText{" +
                "Content='" + Content + '\'' +
                ", MessageText='" + toUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
