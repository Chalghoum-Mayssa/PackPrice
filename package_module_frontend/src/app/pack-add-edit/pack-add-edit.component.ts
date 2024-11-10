import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PriceService } from '../services/pack-price.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { PrmPricePacktype } from '../models/prm-price-packtype.model';
import { CoreService } from '../core/core.service';

@Component({
  selector: 'app-pack-add-edit',
  templateUrl: './pack-add-edit.component.html',
  styleUrls: ['./pack-add-edit.component.css']
})
export class PackAddEditComponent implements OnInit{
  packForm :FormGroup;
  //najmou nsstaamlou ngOnInit wala l constructeur c'est comme comme
  constructor(private _fb :FormBuilder , private _packService : PriceService , 
    private _dialogRef : MatDialogRef<PackAddEditComponent> ,
    @Inject(MAT_DIALOG_DATA) public data:PrmPricePacktype , 
    private _coreService : CoreService) {

    this.packForm = this._fb.group({
      typepackName :'',
      typepackAbrv :'',
      ordPacktype :'',
    })
  }
  ngOnInit(): void {
      this.packForm.patchValue(this.data)
  }
  onFormSbmit(){
    // debugger;
      if (this.packForm.valid) {
        if(this.data){
          const part1 = this.data.id.idEntite;
          const part2 = this.data.id.idTypepack;
          this._packService.updatePackPrice(part1, part2, this.packForm.value).subscribe({
            next:(_val:any) =>{
              // alert('Pack price updated');
              this._coreService.openSnackBar('Pack price updated')
              this._dialogRef.close(true);
  
            },
            error : (err : any) => {
              console.error(err)
            }
          })

        }else{
          this._packService.createPackPrice(this.packForm.value).subscribe({
            next:(_val:any) =>{
              // alert('Pack price added');
              this._coreService.openSnackBar('Pack price added')
              this._dialogRef.close(true);
  
            },
            error : (err : any) => {
              console.error(err)
            }
          })
        }
 
        
      }
  }




  validatePositive(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    let value = parseFloat(inputElement.value);
  
    if (value <= 0) {
      // Si la valeur est inférieure ou égale à 0, la définir à une petite valeur positive.
      inputElement.value = '1'; // Vous pouvez définir une valeur minimale appropriée.
    }
  }
}
