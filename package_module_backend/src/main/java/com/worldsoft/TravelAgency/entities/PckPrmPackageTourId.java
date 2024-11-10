package com.worldsoft.TravelAgency.entities;




import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PckPrmPackageTourId implements Serializable {

    private Long idEntite;
    private Long idPack;

    // Default constructor
    public PckPrmPackageTourId() {
    }

    // Constructor with parameters
    public PckPrmPackageTourId(Long idEntite, Long idPack) {
        this.idEntite = idEntite;
        this.idPack = idPack;
    }

    // Getters and Setters
    public Long getIdEntite() {
        return idEntite;
    }

    public void setIdEntite(Long idEntite) {
        this.idEntite = idEntite;
    }

    public Long getIdPack() {
        return idPack;
    }

    public void setIdPack(Long idPack) {
        this.idPack = idPack;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PckPrmPackageTourId that = (PckPrmPackageTourId) o;
        return Objects.equals(idEntite, that.idEntite) && Objects.equals(idPack, that.idPack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntite, idPack);
    }
}
