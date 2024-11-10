package com.worldsoft.TravelAgency.servicesImpl;

import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;
import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGIONId;
import com.worldsoft.TravelAgency.dao.repositories.PRM_PACKAGE_REGIONRepository;
import com.worldsoft.TravelAgency.services.PRM_PACKAGE_REGIONService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PRM_PACKAGE_REGIONServiceImpl implements PRM_PACKAGE_REGIONService {

    private final PRM_PACKAGE_REGIONRepository regionRepository;

    @Autowired
    public PRM_PACKAGE_REGIONServiceImpl(PRM_PACKAGE_REGIONRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<PRM_PACKAGE_REGION> getAllPackageRegions() {
        return regionRepository.findAll();
    }

    @Override
    public PRM_PACKAGE_REGION getPackageRegionById(Long idPays, Long idRegion) {
        return regionRepository.findById(new PRM_PACKAGE_REGIONId(idPays, idRegion))
                .orElseThrow(() -> new EntityNotFoundException("Region with idPays: " + idPays + " and idRegion: " + idRegion + " not found"));
    }

    @Override
    public PRM_PACKAGE_REGION addPackageRegion(PRM_PACKAGE_REGION packageRegion) {
        generateIdsIfNeeded(packageRegion);
        return regionRepository.save(packageRegion);
    }

    @Override
    public PRM_PACKAGE_REGION updatePackageRegion(Long idPays, Long idRegion, PRM_PACKAGE_REGION packageRegion) {
        packageRegion.setIdPays(idPays);
        packageRegion.setIdRegion(idRegion);
        return regionRepository.save(packageRegion);
    }

    @Override
    @Transactional
    public void deletePackageRegion(Long idPays, Long idRegion) {
        regionRepository.deleteById(new PRM_PACKAGE_REGIONId(idPays, idRegion));
    }

    @Override
    public List<PRM_PACKAGE_REGION> getRegionsByCountry(Long idPays) {
        return regionRepository.findByIdPays(idPays);
    }

    private void generateIdsIfNeeded(PRM_PACKAGE_REGION packageRegion) {
        BigDecimal maxIdPays = BigDecimal.valueOf(regionRepository.getMaxIdPays());
        BigDecimal maxIdRegion = BigDecimal.valueOf(regionRepository.getMaxIdRegion());

        if (packageRegion.getIdPays() == null) {
            packageRegion.setIdPays(maxIdPays != null ? maxIdPays.longValue() + 1 : 1L);
        }
        if (packageRegion.getIdRegion() == null) {
            packageRegion.setIdRegion(maxIdRegion != null ? maxIdRegion.longValue() + 1 : 1L);
        }
    }
    @Override
    public Map<String, Long> getMaxIdPaysAndRegion() {
        Long maxIdPays = regionRepository.getMaxIdPays();
        Long maxIdRegion = regionRepository.getMaxIdRegion();

        Map<String, Long> maxIds = new HashMap<>();
        maxIds.put("idPays", maxIdPays != null ? maxIdPays + 1 : 1L);
        maxIds.put("idRegion", maxIdRegion != null ? maxIdRegion + 1 : 1L);

        return maxIds;
    }
}
