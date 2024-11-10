package com.worldsoft.TravelAgency.dto;


import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;

public record PRMPackageRegionSummaryDTO(
        Long idPays,
        Long idRegion,
        String regionName,
        boolean featured
) {
    public static PRMPackageRegionSummaryDTO toDTO(PRM_PACKAGE_REGION packageRegion) {
        return new PRMPackageRegionSummaryDTO(
                packageRegion.getIdPays(),
                packageRegion.getIdRegion(),
                packageRegion.getRegionName(),
                false
        );
    }
}

