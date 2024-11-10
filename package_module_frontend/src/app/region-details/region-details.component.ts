import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegionService } from '../services/region.service';
import { PRMPackageRegion } from '../models/PRMPackageRegion';

@Component({
  selector: 'app-region-details',
  templateUrl: './region-details.component.html',
  styleUrls: ['./region-details.component.css']
})
export class RegionDetailsComponent implements OnInit {
  idPays: number | null = null;
  idRegion: number | null = null;
  region: PRMPackageRegion | null = null;
  error: string | null = null;
  isWaiting: boolean = true;


  constructor(
    private regionService: RegionService,
    private route: ActivatedRoute,
    private router: Router,
    @Inject('BaseURL') public baseUrl: string
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idPaysParam = params.get('idPays');
      const idRegionParam = params.get('idRegion');
      
      if (idPaysParam && idRegionParam) {
        this.idPays = +idPaysParam;
        this.idRegion = +idRegionParam;

        this.regionService.getRegionById(this.idPays, this.idRegion)
          .subscribe({
            next: (region) => {this.region = region; this.isWaiting = false;
            },
            error: (err) => {this.error = err.message; this.isWaiting = false;
            }
          });
      }
    });
  }

  onRegions() {
    this.router.navigateByUrl('/regions');
  }
}
