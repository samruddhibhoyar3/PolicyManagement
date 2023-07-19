import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nominee } from './nominee';
import { user } from './user';

@Injectable({
  providedIn: 'root',
})
export class NomineeService {
  baseURL = ' http://localhost:8081/api/profile';
  username?: string;
  constructor(private httpclient: HttpClient) {}

  setUsername(username: string) {
    this.username = username;
  }

  getUsername(): string | undefined {
    return this.username;
  }
  //add new nominee-post
  ///api/profile/<username>/nominee
  //http://localhost:8081/api/profile/sabhoy0004/nominee
  addnominee(username: string, nominee: Nominee): Observable<Object> {
    const url = `${this.baseURL}/${username}/nominee`;
    return this.httpclient.post<Object>(url, nominee);
  }

  //get nominee
  ///api/profile/<username>/nominee
  //http://localhost:8081/api/profile/sabhoy0004/nominee
  getNominee(username: string): Observable<user[]> {
    const url = `${this.baseURL}/${username}/nominee`;
    return this.httpclient.get<user[]>(url);
  }

  //remove nominee
  ///api/profile/<username>/nominee
  //http://localhost:8081/api/profile/sabhoy0004/nominee
  deleteNominee(username: string): Observable<void> {
    const url = `${this.baseURL}/${username}/nominee`;
    return this.httpclient.delete<void>(url);
  }
}
