package club.muyoumumumu.springbootwxxiaomuzai;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class NormalMessage {
    /////@RequestMapping(value = "/")
    public String RebackNormalMessage(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}
