import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  readonly API_URL = "http://localhost:8080";
  readonly ENDPOINT_TASK = "/task";
  
  constructor(private httpClient: HttpClient) { 

  }

  getTasks () {
    return this.httpClient.get(this.API_URL+this.ENDPOINT_TASK);
  }
}