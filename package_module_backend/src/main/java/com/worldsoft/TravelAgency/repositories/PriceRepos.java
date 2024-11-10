package com.worldsoft.TravelAgency.repositories;
import com.worldsoft.TravelAgency.entities.PrmPricePacktype;
import com.worldsoft.TravelAgency.entities.PrmPricePacktypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository

public interface PriceRepos extends JpaRepository<PrmPricePacktype, PrmPricePacktypeId> {
    //all crude database methods
    @Query("select MAX(p.id.idEntite) from PrmPricePacktype p")
    BigDecimal getMaxIdEntite();
    @Query("select MAX(p.id.idTypepack) from PrmPricePacktype p")
    BigDecimal getMaxIdPricepack();

    @Query("SELECT p FROM PrmPricePacktype p WHERE p.id.idTypepack = :idTypepack")
    Optional<PrmPricePacktype> findByIdTypepack(@Param("idTypepack") long idTypepack);

    @Query("SELECT p FROM PrmPricePacktype p WHERE p.typepackName LIKE %:typepackName%")
    List<PrmPricePacktype> findByTypepackNameLike(@Param("typepackName") String typepackName);

}
