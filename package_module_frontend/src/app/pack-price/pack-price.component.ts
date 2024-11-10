import { Component, ViewChild } from '@angular/core';
import { PrmPricePacktype } from '../models/prm-price-packtype.model';
import { PackAddEditComponent } from '../pack-add-edit/pack-add-edit.component';
import { MatTableDataSource } from '@angular/material/table';
import { PriceService } from '../services/pack-price.service';
import { CoreService } from '../core/core.service';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-pack-price',
  templateUrl: './pack-price.component.html',
  styleUrls: ['./pack-price.component.css']
})
export class PackPriceComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  displayedColumns: string[] = [
    'position',
    'typepackName',
    'dtCreate', 
    'dtModif',  
    'ordPacktype',
    'refUser',
    'typepackAbrv',
   
    'action'
  ];

  dataSource = new MatTableDataSource<any>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _dialog: MatDialog , 
    private _packService : PriceService , private _coreService : CoreService){}
  
  ngOnInit(): void {
    this.getAllPack();
  }

  openAddEditPackForm(){
    const dialogRef = this._dialog.open(PackAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next : (val) =>{
        this.getAllPack();
      }
    })
  }

  getAllPack() {
    this._packService.getAllPack().subscribe({
      next: (res) => {
        console.log(res);
        const dataWithPosition = res.map((item, index) => ({
          ...item,
          position: index + 1
        }));
        this.dataSource = new MatTableDataSource<PrmPricePacktype>(dataWithPosition);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  deletePackPrice(part1: number, part2: number){
    this._packService.deletePackPrice(part1 , part2).subscribe({
      next : (res)=>{
        this._coreService.openSnackBar('pack price deleted')
        this.getAllPack();
      },
      error: console.log,
    });
  }

  OpenEditForm(data: any){
    const dialogRef =this._dialog.open(PackAddEditComponent , {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next : (val) =>{
        this.getAllPack();
      }
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.trim().toLowerCase();

    if (filterValue) {
      this._packService.getPriceByName(filterValue).subscribe({
        next: (prices: PrmPricePacktype[]) => {
          if (prices.length > 0) {
            
            const dataWithPosition = prices.map((item, index) => ({
              ...item,
              position: index + 1
            }));
            this.dataSource.data = dataWithPosition;
          } else {
            this.dataSource.data = [];
          }
          if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
          }
        },
        error: (error) => {
          console.error('Error fetching pack prices by name', error);
          this.dataSource.data = [];
        }
      });
    } else {
      this.getAllPack(); 
    }
  }

}
