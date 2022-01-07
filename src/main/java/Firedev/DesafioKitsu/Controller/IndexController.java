package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;


@AllArgsConstructor
@RestController
public class IndexController {

    //FRONT END
    private final AnimeService animeService;


    @GetMapping("/")
    @Operation(summary = "Front-end inicio", description = "Esta é a pagina inicial da API, possui um form de pesquisa",
    tags = {"Front-end"})
    public ModelAndView index(){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("Html/index");

        return modelView;
    }

    @PostMapping("/")
    @Operation(summary = "Post formulario", description = "Metodo post para pesquisar algo pelo front-end // Ainda nao finalizado",
    tags = {"Front-end"})
    public RedirectView search(@RequestParam String type, String attribute, String value){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(type+"?"+"attribute="+attribute+"&value="+value);//anime?attribute=X&valueY
        return redirectView;
    }

}
