package controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈hi 控制器〉
 *
 * @author LZ
 * @create 2019/7/23
 * @since 1.0.0
 */
@Controller
public class HiController {

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
