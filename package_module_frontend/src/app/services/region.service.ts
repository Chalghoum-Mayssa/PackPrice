import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { BaseURL } from '../shared/baseUrl';
import { ProcesshttpmsgService } from './processhttpmsg.service';
import { PRMPackageRegion } from '../models/PRMPackageRegion';
import { PRMPackageRegionSummary } from '../models/PRMPackageRegionSummary';


@Injectable({
  providedIn: 'root'
})
export class RegionService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    @Inject('BaseURL') private baseUrl: string,
    private processHTTPMsgService: ProcesshttpmsgService
  ) { }

  getAllRegions(): Observable<PRMPackageRegion[]> {
    return this.http.get<PRMPackageRegion[]>(this.baseUrl + "regions")
      .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getRegionsByCountry(idPays: number): Observable<PRMPackageRegionSummary[]> {
    return this.http.get<PRMPackageRegionSummary[]>(this.baseUrl+ "regions/"+ idPays)
      .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getRegionById(idPays: number, idRegion: number): Observable<PRMPackageRegion> {
    return this.http.get<PRMPackageRegion>(`${this.baseUrl}regions/${idPays}/${idRegion}`);
  }
  
  addRegion(region: PRMPackageRegion): Observable<PRMPackageRegion> {
    return this.http.post<PRMPackageRegion>(this.baseUrl+"regions", region, this.httpOptions)
      .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  updateRegion(idPays: number, idRegion: number, region: PRMPackageRegion): Observable<PRMPackageRegion> {
    return this.http.put<PRMPackageRegion>(`${this.baseUrl}regions/${idPays}/${idRegion}`, region)
      .pipe(catchError(this.processHTTPMsgService.handleError));
  }


  deleteRegion(idPays: number, idRegion: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}regions/${idPays}/${idRegion}`)
      .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getMaxIdPaysAndRegion(): Observable<{ idPays: number, idRegion: number }> {
    return this.http.get<{ idPays: number, idRegion: number }>(`${this.baseUrl}regions/maxIds`);
  }
}
