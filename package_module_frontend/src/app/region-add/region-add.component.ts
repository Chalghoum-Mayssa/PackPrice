import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegionService } from '../services/region.service';
import { PRMPackageRegion } from '../models/PRMPackageRegion';

@Component({
  selector: 'app-region-add',
  templateUrl: './region-add.component.html',
  styleUrls: ['./region-add.component.css']
})
export class RegionAddComponent implements OnInit {
  region: PRMPackageRegion = new PRMPackageRegion();
  maxIds: { idPays: number, idRegion: number };

  constructor(
    private router: Router,
    private regionService: RegionService
  ) {}

  ngOnInit(): void {
    this.fetchMaxIds();
  }

  fetchMaxIds(): void {
    this.regionService.getMaxIdPaysAndRegion().subscribe({
      next: (maxIds) => {
        this.maxIds = maxIds;
        this.region.idPays = this.maxIds.idPays + 1;
        this.region.idRegion = this.maxIds.idRegion + 1;
      },
      error: (err) => {
        console.error('Error fetching max ids:', err);
      }
    });
  }

  onAddRegion(): void {
    this.regionService.addRegion(this.region).subscribe({
      next: (addedRegion: PRMPackageRegion) => {
        console.log('Region added successfully!', addedRegion);
        this.router.navigateByUrl(`/regions/${addedRegion.idPays}/${addedRegion.idRegion}`);
      },
      error: (err) => {
        console.error('Error adding region:', err);
      }
    });
  }

  onCancel(): void {
    this.router.navigateByUrl('/regions');
  }
}
