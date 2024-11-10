package com.worldsoft.TravelAgency.dao.repositories;

import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;
import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGIONId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PRM_PACKAGE_REGIONRepository extends JpaRepository<PRM_PACKAGE_REGION, PRM_PACKAGE_REGIONId> {
    List<PRM_PACKAGE_REGION> findByIdPays(Long idPays);

    @Query("select max(p.idPays) from PRM_PACKAGE_REGION p")
    Long getMaxIdPays();

    @Query("select max(p.idRegion) from PRM_PACKAGE_REGION p")
    Long getMaxIdRegion();

}
