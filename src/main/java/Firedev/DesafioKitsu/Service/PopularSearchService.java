package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Repository.PopularSearchesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PopularSearchService{
    private final PopularSearchesRepository searchsRepository;


    public Page<PopularSearches> getPopularSearches(Pageable pageable){
        return searchsRepository.findAll(pageable);
    }
    @Transactional
    public void SaveOrIncrement(PopularSearches searchToBeSaved){
        //Este metodo recebe o anime que foi pesquisado, caso esse anime nunca tenha sido pesquisado, ele entra no db
        //Caso ele já tenha sido pesquisado, recebe mais +1 no seu contador, assim ele crescre no ranking dos mais pesquisados
        Optional<PopularSearches> searchSaved = searchsRepository.findById(searchToBeSaved.getId());

        if (searchSaved.isEmpty()){
            //Adiciona caso nao exista, e seu contador recebe 1
            searchToBeSaved.setSearchCount(1);
            searchsRepository.save(searchToBeSaved);
        }else {
            //Aumenta seu contador caso ele já tenha sido pesquisado alguma vez
            searchToBeSaved.setSearchCount(searchSaved.get().getSearchCount() + 1);
            searchsRepository.save(searchToBeSaved);
        }
    }

}
