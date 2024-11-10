package com.worldsoft.TravelAgency.services;

import com.worldsoft.TravelAgency.dao.entities.PRM_PAYS;

import java.util.List;

public interface PRM_PAYSService {
    List<PRM_PAYS> getAllPays();
    PRM_PAYS getPaysById(Long idPays);
    PRM_PAYS addPays(PRM_PAYS pays);
    PRM_PAYS updatePays(Long idPays, PRM_PAYS pays);
    void deletePays(Long idPays);
}