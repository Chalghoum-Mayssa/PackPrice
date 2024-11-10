import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegionService } from '../services/region.service';
import { PRMPackageRegion } from '../models/PRMPackageRegion';
import { PRMPackageRegionSummary } from '../models/PRMPackageRegionSummary';

@Component({
  selector: 'app-regions',
  templateUrl: './region.component.html',
  styleUrls: ['./region.component.css']
})
export class RegionComponent implements OnInit {
  regions: PRMPackageRegion[] = [];
  regionsSum: PRMPackageRegionSummary[] = [];
  isWaiting: boolean = true;
  errMess: string = '';
  selectedIdPays: number | null = null; 
  isModalVisible: boolean = false; 
  selectedRegion: { idPays: number, idRegion: number } | null = null; 

  constructor(private router: Router, private regionService: RegionService) {}

  ngOnInit(): void {
    this.loadAllRegions();
  }

  loadAllRegions(): void {
    this.regionService.getAllRegions()
      .subscribe({
        next: (regions) => {
          this.regions = regions;
          this.isWaiting = false;
          this.selectedIdPays = null; 
        },
        error: (errmess) => {
          this.regions = [];
          this.errMess = errmess;
          this.isWaiting = false;
        }
      });
  }

  loadRegionsByCountry(idPays: number): void {
    this.regionService.getRegionsByCountry(idPays)
      .subscribe({
        next: (regions) => {
          this.regionsSum = regions;
          this.isWaiting = false;
          this.selectedIdPays = idPays;
        },
        error: (errmess) => {
          this.regionsSum = [];
          this.errMess = errmess;
          this.isWaiting = false;
        }
      });
  }

  showConfirmationModal(idPays: number, idRegion: number): void {
    this.isModalVisible = true;
    this.selectedRegion = { idPays, idRegion };
  }

  confirmDeletion(): void {
    if (this.selectedRegion) {
        const { idPays, idRegion } = this.selectedRegion;
        this.regionService.deleteRegion(idPays, idRegion).subscribe({
          next: () => {
            console.log('Region deleted!');
            this.regions = this.regions.filter(
              region => region.idPays !== idPays || region.idRegion !== idRegion
            );
            this.regionsSum = this.regionsSum.filter(
              region => region.idPays !== idPays || region.idRegion !== idRegion
            );
            this.isModalVisible = false;
            this.selectedRegion = null;
          },
          error: (errmess) => {
            console.error(errmess);
          }
        });
      }
  }

  cancelDeletion(): void {
    this.isModalVisible = false;
    this.selectedRegion = null;
  }

  onAddRegion(): void {
    this.router.navigateByUrl('/add-region');
  }

  onSelectCountry(event: Event): void {
    const idPays = parseInt((event.target as HTMLSelectElement).value, 10); 
    if (!isNaN(idPays)) {
      this.loadRegionsByCountry(idPays);
    } else {
      this.loadAllRegions(); 
    }
  }
}
