import { Observable } from "rxjs";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { AuthToken } from './authtoken';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: "app-login-list",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {

  private baseUrl = '/oauth/token';
  isLoggedIn: boolean;


  constructor(private http: HttpClient,
    private router: Router) { }

  ngOnInit() {
    this.login("Adam", "Adam")
  }

  login(username: any, password: any): void {

    this.getAccessToken(username, password).subscribe(
      response => {
        // ...any login logic- cookies and all the good stuff goes here
        this.isLoggedIn = true;
        alert("Login successful " + JSON.stringify(response));
        console.log(response);
      },
      error => {
        this.isLoggedIn = false;
        alert("Login not successful " + JSON.stringify(error));
        console.log(error);
      });
  }

  //: Observable<AuthToken> 
  getAccessToken(username: string, password: string) {


    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/x-www-form-urlencoded",
        "Accept": "application/json",
        "Authorization": "Basic " + btoa("kurosh-client-username" + ':' + "kurosh-secret-client-password")
      })
    };



    let data = "username=" + username + "&password=" + encodeURIComponent(password) + "&grant_type=password";
    /* &" +
      "client_secret=kurosh-secret-client-password&client_id=kurosh-client-username"; */
    
    return this.http.post(this.baseUrl, data, httpOptions);
    /* .map(res => res.json()); */
    /*
        const httpOptions = {
          headers: new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'Basic ' + btoa(oauth2_client_id + ':' + oauth2_client_secret)
          })
        };
    
    
        const body = 'client_id={0}&client_secret={1}&grant_type=password&username={2}&password={3}'
          .replace('{0}', oauth2_client_id)
          .replace('{1}', oauth2_client_secret)
          .replace('{2}', username)
          .replace('{3}', password);
    
        // console.log(body);
    
        return this.http.post<AuthToken>(this.baseUrl, body, httpOptions); */
  }


}


