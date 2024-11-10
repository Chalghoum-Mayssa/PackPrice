package com.worldsoft.TravelAgency.services;

import com.worldsoft.TravelAgency.entities.*;

import java.util.List;
import java.util.Optional;

public interface IService {
    List<PckPrmPackageTour> findAll();

    Optional<PckPrmPackageTour> findById(PckPrmPackageTourId id);

    PckPrmPackageTour save(PckPrmPackageTour pckPrmPackageTour);

    void deleteById(PckPrmPackageTourId id);
    public List<PckPrmPackageTour> search(String keyword);
}
