package Firedev.DesafioKitsu.Repository;

import Firedev.DesafioKitsu.Domain.PopularSearches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSearchesRepository extends JpaRepository<PopularSearches, Long> {
}
