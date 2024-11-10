import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { PrmPricePacktype } from '../models/prm-price-packtype.model';

@Injectable({
  providedIn: 'root'
})

export class PriceService {
  private apiUrl = 'http://localhost:8082/api';

  constructor(private http: HttpClient) {}

  getAllPack(): Observable<PrmPricePacktype[]> {
    return this.http.get<PrmPricePacktype[]>(`${this.apiUrl}/price`);
  }

  getPriceById(idTypepack: number): Observable<PrmPricePacktype> {
    return this.http.get<PrmPricePacktype>(`${this.apiUrl}/price/${idTypepack}`);
  }

  getPriceByName(typepackName: string): Observable<PrmPricePacktype[]> {
    return this.http.get<PrmPricePacktype[]>(`${this.apiUrl}/price/name/${typepackName}`);
  }

  createPackPrice(packprice: PrmPricePacktype): Observable<any> {
    return this.http.post<PrmPricePacktype>(`${this.apiUrl}/create`, packprice).pipe(
      catchError(this.handleError)
    );;
  }

  updatePackPrice(part1: number, part2: number, priceDetails: PrmPricePacktype): Observable<PrmPricePacktype> {
    return this.http.put<PrmPricePacktype>(`${this.apiUrl}/update/${part1}/${part2}`, priceDetails);
  }

  deletePackPrice(part1: number, part2: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${part1}/${part2}`, { responseType: 'text' });
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
