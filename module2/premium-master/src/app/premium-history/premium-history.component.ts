import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-premium-history',
  templateUrl: './premium-history.component.html',
  styleUrls: ['./premium-history.component.css']
})
export class PremiumHistoryComponent {
  searchQuery: string='';
  data: any;
  isSearchQuerynull=false;
  constructor(private http: HttpClient) {}

  fetchData() {
    this.http.get<any>('http://localhost:8080/api/premium/' + this.searchQuery+'/history')
      .subscribe(response => {
        this.data = response;
        console.warn(response);
        if(!this.data){
          console.warn("error");
          this.isSearchQuerynull=true;
        }
      });
  }
}
