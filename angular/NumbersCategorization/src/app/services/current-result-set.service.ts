import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Country } from '../models/country.model';
import { Result } from '../models/result.model';

@Injectable({
  providedIn: 'root'
})
export class CurrentResultSetService {

  resultSet:Result=new Result();

  private messageSource = new BehaviorSubject(this.resultSet);
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  setResult(response:any) {
    this.resultSet = new Result();
    let countries:Country[] = [];
    response.country.forEach((element:any) => {
      let country: Country = new Country();
      country.countryCode = element.countryCode;
      country.id = element.id;
      country.name = element.name;
      country.phone = element.phone;
      country.state = element.state;
      countries.push(country);
    });
    this.resultSet.country = countries;
    this.resultSet.pageSize = response.pageSize;
    this.resultSet.resultSize = response.resultSize;
    this.resultSet.pageNo = response.pageNo;

    this.messageSource.next(this.resultSet);
  }
}
