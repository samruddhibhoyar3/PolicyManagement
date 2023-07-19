import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-premium-due',
  templateUrl: './premium-due.component.html',
  styleUrls: ['./premium-due.component.css']
})
export class PremiumDueComponent {
  data: any;
  ispresent = false;
  constructor(private http: HttpClient) {}

  fetchData() {
    this.http.get<any>('http://localhost:8080/api/premium/dues')
      .subscribe(response => {
        this.data = response;
        this.ispresent = true;
        console.warn(response);
      });
  }
}
