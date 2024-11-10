package com.worldsoft.TravelAgency.servicesImpl;

import com.worldsoft.TravelAgency.services.IService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worldsoft.TravelAgency.entities.*;
import com.worldsoft.TravelAgency.repositories.PckPrmPackageTourRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PckPrmPackageTourService implements IService {
    @Autowired
    private PckPrmPackageTourRepository repository;

    @Override
    public List<PckPrmPackageTour> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PckPrmPackageTour> findById(PckPrmPackageTourId id) {
        return repository.findById(id);
    }

    @Override
    public PckPrmPackageTour save(PckPrmPackageTour pckPrmPackageTour) {
        return repository.save(pckPrmPackageTour);
    }

    @Override
    public void deleteById(PckPrmPackageTourId id) {
        repository.deleteById(id);
    }
    @Override
    public List<PckPrmPackageTour> search(String keyword) {
        return repository.findByPackNameContainingIgnoreCaseOrPackTitleContainingIgnoreCaseOrPackContactNameContainingIgnoreCaseOrPckDestinationContainingIgnoreCaseOrEtatPackContainingIgnoreCase(
                keyword, keyword, keyword, keyword, keyword);
    }
}
