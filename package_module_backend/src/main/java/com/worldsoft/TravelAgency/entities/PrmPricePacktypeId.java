package com.worldsoft.TravelAgency.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PrmPricePacktypeId implements java.io.Serializable {
    private static final long serialVersionUID = 4530325568121812353L;
    @NotNull
    @Column(name = "ID_ENTITE", nullable = false)
    private Long idEntite;

    @NotNull
    @Column(name = "ID_TYPEPACK", nullable = false)
    private Long idTypepack;

    public PrmPricePacktypeId() {
    }

    public PrmPricePacktypeId(long part1, long part2) {
        this.idEntite = part1;
        this.idTypepack = part2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrmPricePacktypeId entity = (PrmPricePacktypeId) o;
        return Objects.equals(this.idEntite, entity.idEntite) &&
                Objects.equals(this.idTypepack, entity.idTypepack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntite, idTypepack);
    }

}
