import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchNumbersService {

  currentState:String="";
  currentCode:String="";
  searchClicked:Boolean = false;

  baseUrl:String = 'http://localhost:4200/app'
  constructor(private httpClient:HttpClient) { }

  searchNumbers(state:String,code:String,pageNo:number) {
    if(state!="" && code == "")
      return this.httpClient.get(this.baseUrl + "/state/"+state+"/"+pageNo);
    else if(code!="" && state == "")
      return this.httpClient.get(this.baseUrl +"/code/"+code+"/"+pageNo);
    else if(state!="" && code!="")
      return this.httpClient.get(this.baseUrl +"/state-code/"+state+"/"+code+"/"+pageNo);
    else
      return this.httpClient.get(this.baseUrl +"/state-code/all/"+pageNo);
  }
}
