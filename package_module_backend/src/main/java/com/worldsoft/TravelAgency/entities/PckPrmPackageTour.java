package com.worldsoft.TravelAgency.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PCK_PRM_PACKAGE_TOUR")
public class PckPrmPackageTour {

    @EmbeddedId
    private PckPrmPackageTourId id;

    @Column(name = "ID_PAYS")
    private Long idPays;

    @Column(name = "ID_REGION")
    private Long idRegion;

    @Column(name = "ID_FRS")
    private Long idFrs;

    @Column(name = "ID_CATPACK")
    private Long idCatpack;

    @Column(name = "PACK_CODE")
    private String packCode;

    @Column(name = "PACK_TITLE")
    private String packTitle;

    @Column(name = "PACK_NAME")
    private String packName;

    @Column(name = "ETAT_PACK", columnDefinition = "CHAR")
    private String etatPack;

    @Column(name = "PACK_CONTACT_NAME")
    private String packContactName;

    @Column(name = "PACK_CONTACT_EMAIL")
    private String packContactEmail;

    @Column(name = "PACK_CONTACT_MOBILE")
    private String packContactMobile;

    @Column(name = "TOUR_DESCRIPTION")
    private String tourDescription;

    @Column(name = "PCK_DESTINATION")
    private String pckDestination;

    @Column(name = "TOUR_OVERVIEW")
    private String tourOverview;

    @Column(name = "TOUR_INCLUSION")
    private String tourInclusion;

    @Column(name = "TOUR_EXCLUSION")
    private String tourExclusion;

    @Column(name = "TOUR_TERMS_CONDITION")
    private String tourTermsCondition;

    @Column(name = "TOUR_CANCEL_POLICY")
    private String tourCancelPolicy;

    @Column(name = "TOUR_PAYMENT_POLICY")
    private String tourPaymentPolicy;

    @Column(name = "DT_START_PACK")
    @Temporal(TemporalType.DATE)
    private Date dtStartPack;

    @Column(name = "DT_END_PACK")
    @Temporal(TemporalType.DATE)
    private Date dtEndPack;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "TXT_DURATION")
    private String txtDuration;

    @Column(name = "PACK_COMMENT")
    private String packComment;

    @Column(name = "EMAIL_PACK_1")
    private String emailPack1;

    @Column(name = "EMAIL_PACK_2")
    private String emailPack2;

    @Column(name = "TEL_PACK_1")
    private String telPack1;

    @Column(name = "TEL_PACK_2")
    private String telPack2;

    @Column(name = "STOCK_PACK_INIT")
    private Long stockPackInit = 1L;

    @Column(name = "STOCK_AVAILABLE")
    private Long stockAvailable = 0L;

    @Column(name = "WITH_FLIGHT", columnDefinition = "CHAR")
    private String withFlight = "O";

    @Column(name = "WITH_HOTEL", columnDefinition = "CHAR")
    private String withHotel = "O";

    @Column(name = "MIN_PRICE")
    private Long minPrice = 0L;

    @Column(name = "DEV_PACK")
    private String devPack;

    @Column(name = "IS_ACTIVE", columnDefinition = "CHAR")
    private String isActive = "N";

    @Column(name = "REF_USER")
    private String refUser;

    @Column(name = "DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dtCreate;

    @Column(name = "DT_MODIF")
    @Temporal(TemporalType.DATE)
    private Date dtModif;

    @Column(name = "VERSION")
    private Long version;

    public PckPrmPackageTourId getId() {
        return id;
    }

    public void setId(PckPrmPackageTourId id) {
        this.id = id;
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

    public Long getIdFrs() {
        return idFrs;
    }

    public void setIdFrs(Long idFrs) {
        this.idFrs = idFrs;
    }

    public Long getIdCatpack() {
        return idCatpack;
    }

    public void setIdCatpack(Long idCatpack) {
        this.idCatpack = idCatpack;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public String getPackTitle() {
        return packTitle;
    }

    public void setPackTitle(String packTitle) {
        this.packTitle = packTitle;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getEtatPack() {
        return etatPack;
    }

    public void setEtatPack(String etatPack) {
        this.etatPack = etatPack;
    }

    public String getPackContactName() {
        return packContactName;
    }

    public void setPackContactName(String packContactName) {
        this.packContactName = packContactName;
    }

    public String getPackContactEmail() {
        return packContactEmail;
    }

    public void setPackContactEmail(String packContactEmail) {
        this.packContactEmail = packContactEmail;
    }

    public String getPackContactMobile() {
        return packContactMobile;
    }

    public void setPackContactMobile(String packContactMobile) {
        this.packContactMobile = packContactMobile;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public String getPckDestination() {
        return pckDestination;
    }

    public void setPckDestination(String pckDestination) {
        this.pckDestination = pckDestination;
    }

    public String getTourOverview() {
        return tourOverview;
    }

    public void setTourOverview(String tourOverview) {
        this.tourOverview = tourOverview;
    }

    public String getTourInclusion() {
        return tourInclusion;
    }

    public void setTourInclusion(String tourInclusion) {
        this.tourInclusion = tourInclusion;
    }

    public String getTourExclusion() {
        return tourExclusion;
    }

    public void setTourExclusion(String tourExclusion) {
        this.tourExclusion = tourExclusion;
    }

    public String getTourTermsCondition() {
        return tourTermsCondition;
    }

    public void setTourTermsCondition(String tourTermsCondition) {
        this.tourTermsCondition = tourTermsCondition;
    }

    public String getTourCancelPolicy() {
        return tourCancelPolicy;
    }

    public void setTourCancelPolicy(String tourCancelPolicy) {
        this.tourCancelPolicy = tourCancelPolicy;
    }

    public String getTourPaymentPolicy() {
        return tourPaymentPolicy;
    }

    public void setTourPaymentPolicy(String tourPaymentPolicy) {
        this.tourPaymentPolicy = tourPaymentPolicy;
    }

    public Date getDtStartPack() {
        return dtStartPack;
    }

    public void setDtStartPack(Date dtStartPack) {
        this.dtStartPack = dtStartPack;
    }

    public Date getDtEndPack() {
        return dtEndPack;
    }

    public void setDtEndPack(Date dtEndPack) {
        this.dtEndPack = dtEndPack;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getTxtDuration() {
        return txtDuration;
    }

    public void setTxtDuration(String txtDuration) {
        this.txtDuration = txtDuration;
    }

    public String getPackComment() {
        return packComment;
    }

    public void setPackComment(String packComment) {
        this.packComment = packComment;
    }

    public String getEmailPack1() {
        return emailPack1;
    }

    public void setEmailPack1(String emailPack1) {
        this.emailPack1 = emailPack1;
    }

    public String getEmailPack2() {
        return emailPack2;
    }

    public void setEmailPack2(String emailPack2) {
        this.emailPack2 = emailPack2;
    }

    public String getTelPack1() {
        return telPack1;
    }

    public void setTelPack1(String telPack1) {
        this.telPack1 = telPack1;
    }

    public String getTelPack2() {
        return telPack2;
    }

    public void setTelPack2(String telPack2) {
        this.telPack2 = telPack2;
    }

    public Long getStockPackInit() {
        return stockPackInit;
    }

    public void setStockPackInit(Long stockPackInit) {
        this.stockPackInit = stockPackInit;
    }

    public Long getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Long stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public String getWithFlight() {
        return withFlight;
    }

    public void setWithFlight(String withFlight) {
        this.withFlight = withFlight;
    }

    public String getWithHotel() {
        return withHotel;
    }

    public void setWithHotel(String withHotel) {
        this.withHotel = withHotel;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public String getDevPack() {
        return devPack;
    }

    public void setDevPack(String devPack) {
        this.devPack = devPack;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getRefUser() {
        return refUser;
    }

    public void setRefUser(String refUser) {
        this.refUser = refUser;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getDtModif() {
        return dtModif;
    }

    public void setDtModif(Date dtModif) {
        this.dtModif = dtModif;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
