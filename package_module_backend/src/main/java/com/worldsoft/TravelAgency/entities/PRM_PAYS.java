package com.worldsoft.TravelAgency.dao.entities;

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
@Table(name = "PRM_PAYS")
public class PRM_PAYS {

    @Id
    @Column(name = "ID_PAYS", nullable = false)
    private Long idPays;

    @Column(name = "CODE_PAYS", nullable = false, length = 10)
    private String codePays;

    @Column(name = "L_PAYS", nullable = false, length = 50)
    private String paysName;

    @Column(name = "ABRV_PAYS", length = 10)
    private String abrvPays;

    @Column(name = "ORD_PAYS")
    private Integer ordPays;

    @Column(name = "IND_PAYS")
    private Integer indPays;

    @Column(name = "IND_TEL_PAYS", length = 10)
    private String indTelPays;

    @Column(name = "NATIONALITE", length = 80)
    private String nationalite;

    @Column(name = "ADD_VISA", length = 1)
    private Character addVisa;

    @Column(name = "REF_USER", length = 30)
    private String refUser;

    @Column(name = "DT_CREATE")
    private Date dtCreate;

    @Column(name = "DT_MODIF")
    private Date dtModif;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "DISPLAY_WEB", length = 1)
    private Character displayWeb;

    @Column(name = "FOR_VISA", length = 1, columnDefinition = "CHAR DEFAULT 'N'")
    private Character forVisa;

    @Column(name = "POUR_COURRIER", length = 1, columnDefinition = "CHAR DEFAULT 'N'")
    private Character pourCourrier;


}
