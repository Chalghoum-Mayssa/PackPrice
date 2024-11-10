import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegionService } from '../services/region.service';
import { PRMPackageRegion } from '../models/PRMPackageRegion';

@Component({
  selector: 'app-region-update',
  templateUrl: './region-update.component.html',
  styleUrls: ['./region-update.component.css']
})
export class RegionUpdateComponent implements OnInit {
  region: PRMPackageRegion = new PRMPackageRegion();

  constructor(
    private router: Router,
    private regionService: RegionService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(result => {
      const idPays = +result.get('idPays');
      const idRegion = +result.get('idRegion');

      if (idPays !== -1 && idRegion !== -1) {
        this.initRegion(idPays, idRegion);
      }
    });
  }

  initRegion(idPays: number, idRegion: number): void {
    this.regionService.getRegionById(idPays, idRegion).subscribe(region => {
      this.region = region;
    });
  }

  onUpdateRegion(): void {
    this.regionService.updateRegion(this.region.idPays, this.region.idRegion, this.region).subscribe(updatedRegion => {
      console.log('Region updated successfully!', updatedRegion);
      this.router.navigateByUrl(`/regions/${updatedRegion.idPays}/${updatedRegion.idRegion}`);
    }, error => {
      console.error('Error updating region:', error);
    });
  }

  onCancel(): void {
    this.router.navigateByUrl('/regions');
  }
}
