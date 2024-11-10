package com.worldsoft.TravelAgency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.worldsoft.TravelAgency.entities.*;

import java.util.List;

@Repository
public interface PckPrmPackageTourRepository extends JpaRepository<PckPrmPackageTour, PckPrmPackageTourId> {
    List<PckPrmPackageTour> findByPackNameContainingIgnoreCaseOrPackTitleContainingIgnoreCaseOrPackContactNameContainingIgnoreCaseOrPckDestinationContainingIgnoreCaseOrEtatPackContainingIgnoreCase(
            String packName, String packTitle, String packContactName, String pckDestination, String etatPack);
}
