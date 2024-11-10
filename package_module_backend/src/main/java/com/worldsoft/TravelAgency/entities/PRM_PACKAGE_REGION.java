package com.worldsoft.TravelAgency.dao.entities;

import com.worldsoft.TravelAgency.dao.repositories.PRM_PACKAGE_REGIONRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PRM_PACKAGE_REGIONId.class)
@Table(name = "PRM_PACKAGE_REGION")
public class PRM_PACKAGE_REGION {

    @Id
    @Column(name = "ID_PAYS", nullable = false, updatable = false)
    private Long idPays;

    @Id
    @Column(name = "ID_REGION", nullable = false, updatable = false)
    private Long idRegion;

    @Column(name = "L_REGION", length = 100)
    private String regionName;

    @Column(name = "ORD_REGION")
    private Integer ordRegion;

    @Column(name = "REF_USER", length = 100)
    private String refUser;

    @Column(name = "DT_CREATE")
    private Date dtCreate;

    @Column(name = "DT_MODIF")
    private Date dtModif;

    @Column(name = "VERSION")
    private Integer version;

    @Transient
    private PRM_PACKAGE_REGIONRepository repository;

    @PrePersist
    public void prePersist() {
        if (repository != null) {
            Long maxIdPays = repository.getMaxIdPays();
            Long maxIdRegion = repository.getMaxIdRegion();

            if (maxIdPays != null) {
                this.idPays = maxIdPays + 1;
            } else {
                this.idPays = 1L;
            }

            if (maxIdRegion != null) {
                this.idRegion = maxIdRegion + 1;
            } else {
                this.idRegion = 1L;
            }
        }
    }

}
