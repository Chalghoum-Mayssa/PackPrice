package com.worldsoft.TravelAgency.dto;


import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;
import java.util.Date;



public record PRMPackageRegionDTO(
        Long idPays,
        Long idRegion,
        String regionName,
        Integer ordRegion,
        String refUser,
        Date dtCreate,
        Date dtModif,
        Integer version
) {
    public static PRMPackageRegionDTO toDTO(PRM_PACKAGE_REGION packageRegion) {
        return new PRMPackageRegionDTO(
                packageRegion.getIdPays(),
                packageRegion.getIdRegion(),
                packageRegion.getRegionName(),
                packageRegion.getOrdRegion(),
                packageRegion.getRefUser(),
                packageRegion.getDtCreate(),
                packageRegion.getDtModif(),
                packageRegion.getVersion()
        );
    }

    public static PRM_PACKAGE_REGION toEntity(PRMPackageRegionDTO dto) {
        PRM_PACKAGE_REGION packageRegion = new PRM_PACKAGE_REGION();
        packageRegion.setIdPays(dto.idPays());
        packageRegion.setIdRegion(dto.idRegion());
        packageRegion.setRegionName(dto.regionName());
        packageRegion.setOrdRegion(dto.ordRegion());
        packageRegion.setRefUser(dto.refUser());
        packageRegion.setDtCreate(dto.dtCreate());
        packageRegion.setDtModif(dto.dtModif());
        packageRegion.setVersion(dto.version());
        return packageRegion;
    }
}

