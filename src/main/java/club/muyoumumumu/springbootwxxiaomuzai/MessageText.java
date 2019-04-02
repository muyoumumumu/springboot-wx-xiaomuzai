package club.muyoumumumu.springbootwxxiaomuzai;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MessageText {
    @JacksonXmlProperty(localName = "ToUserName")
    private String ToUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    private String FromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    private long CreateTime;
    @JacksonXmlProperty(localName = "MsgType")
    private String MsgType;
    @JacksonXmlProperty(localName = "Content")
    private String Content;
    @JacksonXmlProperty(localName = "MsgId")
    private long MsgId;

    public MessageText() {
    }

    @Override
    public String toString() {
        return "MessageText{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                '}';
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
