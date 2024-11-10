package com.worldsoft.TravelAgency.controllers;


import com.worldsoft.TravelAgency.entities.PrmPricePacktype;
import com.worldsoft.TravelAgency.entities.PrmPricePacktypeId;
import com.worldsoft.TravelAgency.services.ServicePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PackPriceController {
    @Autowired
    private ServicePrice servicePrice;


    @GetMapping(value = "/price")
    public List<PrmPricePacktype> getAllPack() {
        return servicePrice.getAllPack();
    }

    @GetMapping("/price/{idTypepack}")
    public ResponseEntity<PrmPricePacktype> getPriceById(@PathVariable long idTypepack) {
        Optional<PrmPricePacktype> packprice = servicePrice.findByIdTypepack(idTypepack);
        return packprice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(value ="/create")
    public PrmPricePacktype createPackPrice(@RequestBody PrmPricePacktype packprice) {
        return servicePrice.save(packprice);
    }

    @PutMapping("/update/{part1}/{part2}")
    public ResponseEntity<PrmPricePacktype> updatedPrice(@PathVariable long part1, @PathVariable long part2, @RequestBody PrmPricePacktype priceDetails) {
        PrmPricePacktypeId id = new PrmPricePacktypeId(part1, part2);
        Optional<PrmPricePacktype> optionalPackPrice = servicePrice.findById(id);
        if (optionalPackPrice.isPresent()) {
            PrmPricePacktype packprice = optionalPackPrice.get();

            // Mise à jour ll les valeurs non nulles khw
            if (priceDetails.getTypepackName() != null) {
                packprice.setTypepackName(priceDetails.getTypepackName());
            }
            if (priceDetails.getTypepackAbrv() != null) {
                packprice.setTypepackAbrv(priceDetails.getTypepackAbrv());
            }
            packprice.setOrdPacktype(priceDetails.getOrdPacktype());
            packprice.setRefUser(priceDetails.getRefUser() != null ? priceDetails.getRefUser() : "defaultUser");
            packprice.setDtModif(new Date());
            packprice.setVersion(priceDetails.getVersion() != null ? priceDetails.getVersion() : packprice.getVersion() + 1);

            PrmPricePacktype updatedPrice = servicePrice.save(packprice);
            return ResponseEntity.ok(updatedPrice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{part1}/{part2}")
    public ResponseEntity<String> deletePackPrice(@PathVariable long part1, @PathVariable long part2) {
        PrmPricePacktypeId id = new PrmPricePacktypeId(part1, part2);
        Optional<PrmPricePacktype> optionalPackPrice = servicePrice.findById(id);
        System.out.println("Pack Prices are ===> "+ optionalPackPrice.toString());

        if (optionalPackPrice.isPresent()) {
            try {
                servicePrice.deleteById(id);
                return ResponseEntity.ok("Pack Price deleted");
            } catch (Exception e) {
                System.out.println("Error occurred while deleting the pack price: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
        } else {
            System.out.println("we are in the else ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pack price not found");
        }
    }
    @GetMapping("/price/name/{typepackName}")
    public ResponseEntity<List<PrmPricePacktype>> getPriceByName(@PathVariable String typepackName) {
        List<PrmPricePacktype> packprices = servicePrice.findByTypepackNameLike(typepackName);
        return packprices.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(packprices);
    }
}

