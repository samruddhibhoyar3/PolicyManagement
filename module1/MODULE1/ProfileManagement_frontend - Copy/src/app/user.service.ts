import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from './user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  baseURL = ' http://localhost:8081/api/profile';

  username: string = '';
  constructor(private httpclient: HttpClient) {}

  setUsername(username: string): void {
    this.username = username;
  }
  getUsername(): string {
    return this.username;
  }
  //get list of nominee
  getAllUsers(): Observable<user[]> {
    return this.httpclient.get<user[]>(`${this.baseURL}`);
  }
  //create new user profile
  //http://localhost:8081/api/profile
  ///api/profile
  adduserprofile(User?: user): Observable<Object> {
    return this.httpclient.post<Object>(`${this.baseURL}`, User);
  }

  checkProfileExists(username: string): Observable<boolean> {
    const url = `${this.baseURL}/${username}`;
    return this.httpclient.get<boolean>(url);
  }
}
