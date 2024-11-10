package com.worldsoft.TravelAgency.services;

import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;

import java.util.List;
import java.util.Map;

public interface PRM_PACKAGE_REGIONService {
    List<PRM_PACKAGE_REGION> getAllPackageRegions();
    PRM_PACKAGE_REGION getPackageRegionById(Long idPays, Long idRegion);
    PRM_PACKAGE_REGION addPackageRegion(PRM_PACKAGE_REGION packageRegion);
    PRM_PACKAGE_REGION updatePackageRegion(Long idPays, Long idRegion, PRM_PACKAGE_REGION packageRegion);
    void deletePackageRegion(Long idPays, Long idRegion);
    List<PRM_PACKAGE_REGION> getRegionsByCountry(Long idPays);
    Map<String, Long> getMaxIdPaysAndRegion();
}
