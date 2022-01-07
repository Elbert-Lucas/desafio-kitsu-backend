package Firedev.DesafioKitsu.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("Html/index.html");

        modelView.addObject("img", "asdasd");
        return modelView;
    }
}
