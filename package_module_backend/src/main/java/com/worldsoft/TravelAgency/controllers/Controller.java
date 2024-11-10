package com.worldsoft.TravelAgency.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.worldsoft.TravelAgency.entities.*;
import com.worldsoft.TravelAgency.repositories.PckPrmPackageTourRepository;
import com.worldsoft.TravelAgency.servicesImpl.*;
import com.worldsoft.TravelAgency.repositories.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    private PckPrmPackageTourService service;
    @Autowired
    private ReferenceDataRepository referenceDataRepository;
    @GetMapping
    public List<PckPrmPackageTour> getAllPackageTours() {
        return service.findAll();
    }

    @GetMapping("/{idEntite}/{idPack}")
    public ResponseEntity<PckPrmPackageTour> getPackageTourById(@PathVariable Long idEntite, @PathVariable Long idPack) {
        PckPrmPackageTourId id = new PckPrmPackageTourId(idEntite, idPack);
        Optional<PckPrmPackageTour> packageTour = service.findById(id);
        return packageTour.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PckPrmPackageTour createPackageTour(@RequestBody PckPrmPackageTour packageTour) {
        return service.save(packageTour);
    }

    @PutMapping("/{idEntite}/{idPack}")
    public ResponseEntity<PckPrmPackageTour> updatePackageTour(
            @PathVariable Long idEntite, @PathVariable Long idPack, @RequestBody PckPrmPackageTour packageTourDetails) {
        PckPrmPackageTourId id = new PckPrmPackageTourId(idEntite, idPack);
        Optional<PckPrmPackageTour> optionalPackageTour = service.findById(id);
        if (optionalPackageTour.isPresent()) {
            PckPrmPackageTour packageTour = optionalPackageTour.get();
            // Update fields as needed
            packageTour.setId(packageTourDetails.getId());
            packageTour.setIdPays(packageTourDetails.getIdPays());
            packageTour.setIdRegion(packageTourDetails.getIdRegion());
            packageTour.setIdFrs(packageTourDetails.getIdFrs());
            packageTour.setIdCatpack(packageTourDetails.getIdCatpack());
            packageTour.setPackCode(packageTourDetails.getPackCode());
            packageTour.setPackTitle(packageTourDetails.getPackTitle());
            packageTour.setPackName(packageTourDetails.getPackName());
            packageTour.setEtatPack(packageTourDetails.getEtatPack());
            packageTour.setPackContactName(packageTourDetails.getPackContactName());
            packageTour.setPackContactEmail(packageTourDetails.getPackContactEmail());
            packageTour.setPackContactMobile(packageTourDetails.getPackContactMobile());
            packageTour.setTourDescription(packageTourDetails.getTourDescription());
            packageTour.setPckDestination(packageTourDetails.getPckDestination());
            packageTour.setTourOverview(packageTourDetails.getTourOverview());
            packageTour.setTourInclusion(packageTourDetails.getTourInclusion());
            packageTour.setTourExclusion(packageTourDetails.getTourExclusion());
            packageTour.setTourTermsCondition(packageTourDetails.getTourTermsCondition());
            packageTour.setTourCancelPolicy(packageTourDetails.getTourCancelPolicy());
            packageTour.setTourPaymentPolicy(packageTourDetails.getTourPaymentPolicy());
            packageTour.setDtStartPack(packageTourDetails.getDtStartPack());
            packageTour.setDtEndPack(packageTourDetails.getDtEndPack());
            packageTour.setDuration(packageTourDetails.getDuration());
            packageTour.setTxtDuration(packageTourDetails.getTxtDuration());
            packageTour.setPackComment(packageTourDetails.getPackComment());
            packageTour.setEmailPack1(packageTourDetails.getEmailPack1());
            packageTour.setEmailPack2(packageTourDetails.getEmailPack2());
            packageTour.setTelPack1(packageTourDetails.getTelPack1());
            packageTour.setTelPack2(packageTourDetails.getTelPack2());
            packageTour.setStockPackInit(packageTourDetails.getStockPackInit());
            packageTour.setStockAvailable(packageTourDetails.getStockAvailable());
            packageTour.setWithFlight(packageTourDetails.getWithFlight());
            packageTour.setWithHotel(packageTourDetails.getWithHotel());
            packageTour.setMinPrice(packageTourDetails.getMinPrice());
            packageTour.setDevPack(packageTourDetails.getDevPack());
            packageTour.setIsActive(packageTourDetails.getIsActive());
            packageTour.setRefUser(packageTourDetails.getRefUser());
            packageTour.setDtCreate(packageTourDetails.getDtCreate());
            packageTour.setDtModif(packageTourDetails.getDtModif());
            packageTour.setVersion(packageTourDetails.getVersion());

            final PckPrmPackageTour updatedPackageTour = service.save(packageTour);
            return ResponseEntity.ok(updatedPackageTour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEntite}/{idPack}")
    public ResponseEntity<Void> deletePackageTour(@PathVariable Long idEntite, @PathVariable Long idPack) {
        PckPrmPackageTourId id = new PckPrmPackageTourId(idEntite, idPack);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public List<PckPrmPackageTour> searchPackageTours(@RequestParam String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/Entite")
    public List<Map<String, Object>> getEntite(@RequestParam Long id) {
        return referenceDataRepository.getEntite(id);
    }

    @GetMapping("/countries")
    public List<Map<String, Object>> getCountries() {
        return referenceDataRepository.getCountries();
    }

    @GetMapping("/regions")
    public List<Map<String, Object>> getRegions(@RequestParam Long id ) {
        return referenceDataRepository.getRegions(id);
    }

    @GetMapping("/suppliers")
    public List<Map<String, Object>> getSuppliers() {
        return referenceDataRepository.getSuppliers();
    }

    @GetMapping("/package-categories")
    public List<Map<String, Object>> getPackageCategories() {
        return referenceDataRepository.getPackageCategories();
    }
    @GetMapping("/PackageTourId")
    public List<Map<String, Object>> getPackageTourId() {
        return referenceDataRepository.getMaxTourId();
    }

}

