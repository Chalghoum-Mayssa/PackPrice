package com.worldsoft.TravelAgency.services;




import com.worldsoft.TravelAgency.entities.PrmPricePacktype;
import com.worldsoft.TravelAgency.entities.PrmPricePacktypeId;

import java.util.List;
import java.util.Optional;

public interface ServicePrice {



    List<PrmPricePacktype> getAllPack();

    Optional<PrmPricePacktype> findByIdTypepack(long idTypepack);

    Optional<PrmPricePacktype> findById(PrmPricePacktypeId id);

    PrmPricePacktype save(PrmPricePacktype packprice);

    void deleteById(PrmPricePacktypeId id);

    PrmPricePacktype update(PrmPricePacktype packprice);

    List<PrmPricePacktype> findByTypepackNameLike(String typepackName);




}



