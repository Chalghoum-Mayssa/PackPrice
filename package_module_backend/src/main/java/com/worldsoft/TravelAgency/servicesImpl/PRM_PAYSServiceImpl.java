package com.worldsoft.TravelAgency.servicesImpl;


import com.worldsoft.TravelAgency.dao.entities.PRM_PAYS;
import com.worldsoft.TravelAgency.dao.repositories.PRM_PAYSRepository;
import com.worldsoft.TravelAgency.services.PRM_PAYSService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PRM_PAYSServiceImpl implements PRM_PAYSService {

    private final PRM_PAYSRepository paysRepository;

    public PRM_PAYSServiceImpl(PRM_PAYSRepository paysRepository) {
        this.paysRepository = paysRepository;
    }

    @Override
    public List<PRM_PAYS> getAllPays() {
        return this.paysRepository.findAll();
    }

    @Override
    public PRM_PAYS getPaysById(Long idPays) {
        return this.paysRepository.findById(idPays)
                .orElseThrow(() -> new EntityNotFoundException("Pays with id: " + idPays + " not found"));
    }

    @Override
    public PRM_PAYS addPays(PRM_PAYS pays) {
        try {
            return paysRepository.save(pays);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the pays: " + e.getMessage());
        }
    }

    @Override
    public PRM_PAYS updatePays(Long idPays, PRM_PAYS pays) {
        if (paysRepository.existsById(idPays)) {
            try {
                return paysRepository.save(pays);
            } catch (DataIntegrityViolationException e) {
                throw new RuntimeException("An error occurred while updating the pays: " + e.getMessage());
            }
        } else {
            throw new EntityNotFoundException("Pays with id: " + idPays + " not found");
        }
    }

    @Override
    @Transactional
    public void deletePays(Long idPays) {
        try {
            if (paysRepository.existsById(idPays)) {
                paysRepository.deleteById(idPays);
            } else {
                throw new EntityNotFoundException("Pays with id: " + idPays + " not found");
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete pays with id: " + idPays, e);
        }
    }
}