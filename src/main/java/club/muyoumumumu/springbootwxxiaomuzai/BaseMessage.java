package club.muyoumumumu.springbootwxxiaomuzai;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * 类名称: BaseMessage
 * 类描述: 回复消息的基类
 */
public class BaseMessage {

    protected String toUserName;
    protected String FromUserName;
    protected long CreateTime;
    protected String MsgType;

    public BaseMessage() {
        super();
    }

    public String gettoUserName() {
        return toUserName;
    }

    public void settoUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
