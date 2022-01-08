package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Service.PopularSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Component
@AllArgsConstructor
@RestController
public class PopularSearchController {
    PopularSearchService popularSearchService;


    @GetMapping("/popular-searches")
    @Operation(summary = "Lista as pesquisas mais populares", description = "Este endpoint retorna as pesquisas mais" +
            " populares em ordem.", tags = {"Popular Search"})
    public Page<PopularSearches> popularSearches(@PageableDefault(sort = {"searchCount"},
                                                 direction = Sort.Direction.DESC)
                                                 @Parameter(hidden = true)
                                                 Pageable pageable){

        return popularSearchService.getPopularSearches(pageable);
    }
}
