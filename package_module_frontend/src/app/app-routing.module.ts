import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegionComponent } from './region/region.component';
import { RegionUpdateComponent } from './region-update/region-update.component';
import { RegionDetailsComponent } from './region-details/region-details.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { RegionAddComponent } from './region-add/region-add.component';
import { PackPriceComponent } from './pack-price/pack-price.component';

const routes: Routes = [
  { path: 'pack-price', component: PackPriceComponent },  
  { path: 'regions', component: RegionComponent },
  { path: 'add-region', component: RegionAddComponent },
  { path: 'regions/edit/:idPays/:idRegion', component: RegionUpdateComponent },
  { path: 'regions/:idPays/:idRegion', component: RegionDetailsComponent },
  { path: '**', component: NotfoundComponent },
  { path: '', redirectTo: '/regions', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
