import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthToken } from './authtoken';

@Injectable()
export class LoginService {

  private baseUrl = '/oauth/token';

  constructor(private http: HttpClient) { }

  getAccessToken(username: string, password: string): Observable<AuthToken> {
    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/x-www-form-urlencoded",
        "Accept": "application/json",
        "Authorization": "Basic " + btoa("kurosh-client-username" + ':' + "kurosh-secret-client-password")
      })
    };
    let data = "username=" + username + "&password=" + encodeURIComponent(password) + "&grant_type=password";
    return this.http.post<AuthToken>(this.baseUrl, data, httpOptions);
  }

}
