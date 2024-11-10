package com.worldsoft.TravelAgency.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PRM_PRICE_PACKTYPE")
public class PrmPricePacktype {
    @EmbeddedId
    private PrmPricePacktypeId id;

    @Size(max = 100)
    @Column(name = "TYPEPACK_NAME", length = 100)
    private String typepackName;

    @Size(max = 10)
    @Column(name = "TYPEPACK_ABRV", length = 10)
    private String typepackAbrv;

    @Column(name = "ORD_PACKTYPE")
    private Long ordPacktype;

    @Size(max = 100)
    @Column(name = "REF_USER", length = 100)
    private String refUser ;

    @Column(name = "DT_CREATE")
    private Date dtCreate ;

    @Column(name = "DT_MODIF")
    private Date dtModif ;

    @Column(name = "VERSION")
    private Integer version ;

    @PrePersist
    protected void onCreate() {
        dtCreate = new Date();
        dtModif = new Date();
        refUser = "defaultUser";
        version = 1;
    }

    @PreUpdate
    protected void onUpdate() {
        dtModif = new Date();
    }

}
