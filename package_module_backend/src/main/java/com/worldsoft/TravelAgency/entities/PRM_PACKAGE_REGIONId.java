package com.worldsoft.TravelAgency.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PRM_PACKAGE_REGIONId implements Serializable {

    @Column(name = "ID_PAYS")
    private Long idPays;

    @Column(name = "ID_REGION")
    private Long idRegion;

    public PRM_PACKAGE_REGIONId(Long idPays, Long idRegion) {
        this.idPays = idPays;
        this.idRegion = idRegion;
    }

    public PRM_PACKAGE_REGIONId() {

    }

    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PRM_PACKAGE_REGIONId that = (PRM_PACKAGE_REGIONId) o;
        return Objects.equals(idPays, that.idPays) && Objects.equals(idRegion, that.idRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, idRegion);
    }
}
