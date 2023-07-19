import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PremiumPaymentsService {
  private apiUrl = 'http://localhost:8080/api/premium';

  constructor(private http: HttpClient) {}

  addPremiumPayments(premiumPayments: any): Observable<void> {
    return this.http.post<void>(this.apiUrl, premiumPayments);
  }
}