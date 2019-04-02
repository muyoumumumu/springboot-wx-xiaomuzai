package club.muyoumumumu.springbootwxxiaomuzai;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

//直接处理get请求
@RestController
public class WeChatBack {

    private final static String token = "muyoumumumu";

    //主要是用来接收普通的消息
    @RequestMapping(value = "/")
    public String WeChatInterface(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("---------------开始");

        //接收POST消息
        MessageText mt = null;
        try {
            InputStream in = request.getInputStream();
            //转化为java对象
            XmlMapper xmlMapper = new XmlMapper();
            mt = xmlMapper.readValue(in, MessageText.class);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mt == null) {
            System.out.println("Post数据为空");
            return "Post数据为空";
        }

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String openid = request.getParameter("openid");
        System.out.println("signature:" + signature +
                "timestamp:" + timestamp +
                "nonce:" + nonce +
                "openid:" + openid);
        if (checkSignature(signature, timestamp, nonce)) {
            System.out.println("----------微信验证成功");
            //return rebackTo(request.getc);
        } else {
            System.out.println("------!!!!微信验证失败");
            return null;
        }

        //返回自己想说的东西
        System.out.println("收到的消息为：" + mt.toString());
        String content = "我小木仔已经知晓了~~";
        RebackMessageText nMt = new RebackMessageText(mt.getFromUserName(), mt.getToUserName(), 1554192222, mt.getMsgType(), content);
        return new TextMessageUtil().TextMessageUtil(nMt);
    }

    private boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);   //排序
        String str = arr[0].concat(arr[1]).concat(arr[2]);
        MessageDigest md = null;
        String tmp = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());    //进行SHA-1加密
            tmp = bytetoStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md = null;
        return tmp != null && tmp.equals(signature.toUpperCase());
    }

    private String bytetoStr(byte[] byteArray) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder strDigest = new StringBuilder();
        for (byte b : byteArray) {
            strDigest.append(Digit[(b >>> 4) & 0x0f]);
            strDigest.append(Digit[b & 0x0f]);
        }
        return strDigest.toString();
    }
}