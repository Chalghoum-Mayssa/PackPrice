package com.worldsoft.TravelAgency.controllers;



import com.worldsoft.TravelAgency.dao.entities.PRM_PACKAGE_REGION;
import com.worldsoft.TravelAgency.services.PRM_PACKAGE_REGIONService;
import com.worldsoft.TravelAgency.dto.PRMPackageRegionDTO;
import com.worldsoft.TravelAgency.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regions")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PRMPackageRegionController {

    private final PRM_PACKAGE_REGIONService packageRegionService;

    public PRMPackageRegionController(PRM_PACKAGE_REGIONService packageRegionService) {
        this.packageRegionService = packageRegionService;
    }

    @GetMapping()
    public ResponseEntity<List<PRMPackageRegionDTO>> getAllPackageRegions() {
        List<PRMPackageRegionDTO> packageRegions = packageRegionService.getAllPackageRegions()
                .stream()
                .map(PRMPackageRegionDTO::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(packageRegions, HttpStatus.OK);
    }

    @GetMapping("/{idPays}/{idRegion}")
    public ResponseEntity<PRMPackageRegionDTO> getPackageRegionById(@PathVariable Long idPays, @PathVariable Long idRegion) {
        PRMPackageRegionDTO packageRegion = PRMPackageRegionDTO.toDTO(packageRegionService.getPackageRegionById(idPays, idRegion));
        return new ResponseEntity<>(packageRegion, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PRMPackageRegionDTO> addPackageRegion(@RequestBody PRMPackageRegionDTO packageRegionDTO) {
        PRM_PACKAGE_REGION packageRegion = PRMPackageRegionDTO.toEntity(packageRegionDTO);
        return new ResponseEntity<>(PRMPackageRegionDTO.toDTO(packageRegionService.addPackageRegion(packageRegion)), HttpStatus.CREATED);
    }

    @PutMapping("/{idPays}/{idRegion}")
    public ResponseEntity<PRMPackageRegionDTO> updatePackageRegion(@PathVariable Long idPays, @PathVariable Long idRegion, @RequestBody PRMPackageRegionDTO packageRegionDTO) {
        PRM_PACKAGE_REGION packageRegion = PRMPackageRegionDTO.toEntity(packageRegionDTO);
        return new ResponseEntity<>(PRMPackageRegionDTO.toDTO(packageRegionService.updatePackageRegion(idPays, idRegion, packageRegion)), HttpStatus.OK);
    }

    @DeleteMapping("/{idPays}/{idRegion}")
    public ResponseEntity<Void> deletePackageRegion(@PathVariable Long idPays, @PathVariable Long idRegion) {
        packageRegionService.deletePackageRegion(idPays, idRegion);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idPays}")
    public ResponseEntity<List<PRMPackageRegionSummaryDTO>> getRegionsByCountry(@PathVariable Long idPays) {
        List<PRMPackageRegionSummaryDTO> regions = packageRegionService.getRegionsByCountry(idPays)
                .stream()
                .map(PRMPackageRegionSummaryDTO::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/maxIds")
    public Map<String, Long> getMaxIds() {
        return packageRegionService.getMaxIdPaysAndRegion();
    }

}
