import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegionDetailsComponent } from './region-details/region-details.component';
import { RegionUpdateComponent } from './region-update/region-update.component';
import { RegionComponent } from './region/region.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NotfoundComponent } from './notfound/notfound.component';
import { BaseURL } from './shared/baseUrl';
import { RegionService } from './services/region.service';
import { RegionAddComponent } from './region-add/region-add.component';
import { ConfirmationModalComponent } from './confirmation-modal/confirmation-modal.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { PackAddEditComponent } from './pack-add-edit/pack-add-edit.component';
import { PackPriceComponent } from './pack-price/pack-price.component';

@NgModule({
  declarations: [
    AppComponent,
    RegionDetailsComponent,
    RegionUpdateComponent,
    RegionComponent,
    NotfoundComponent,
    RegionAddComponent,
    ConfirmationModalComponent,
    PackAddEditComponent,
    PackPriceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSnackBarModule

    
  ],
  providers: [
    RegionService,
    {provide:'BaseURL', useValue:BaseURL}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
