package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;


@AllArgsConstructor
@RestController
public class IndexController {

    private final AnimeService animeService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("Html/index");

        return modelView;
    }

    @PostMapping("/")
    public RedirectView search(@RequestParam String type, String attribute, String value){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(type+"?"+"attribute="+attribute+"&value="+value);//anime?attribute=X&valueY
        return redirectView;
    }

}
