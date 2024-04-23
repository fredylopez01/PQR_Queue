import { Injectable } from '@angular/core';
import { MyClaim } from '../models/MyClaim';
import { HttpClient} from "@angular/common/http";
import { Observable, isEmpty } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {
  private apiServerUrl = 'http://localhost:8080/claim';

  constructor(private http: HttpClient){}
  
  public getClaims(): Observable<MyClaim[]>{
      return this.http.get<MyClaim[]>(`${this.apiServerUrl}/getClaim`);
  }

  public sendClaim(message:MyClaim): Observable<MyClaim>{
      return this.http.post<MyClaim>(`${this.apiServerUrl}/addClaim`, message);
  }

  public deleteClaim(): Observable<MyClaim>{
      return this.http.delete<MyClaim>(`${this.apiServerUrl}/deleteClaim`);
  }

  public lastClaim(): Observable<MyClaim>{
      return this.http.get<MyClaim>(`${this.apiServerUrl}/firstClaim`);
  }

 
}
