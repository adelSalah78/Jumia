import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Result } from 'src/app/models/result.model';
import { CurrentResultSetService } from 'src/app/services/current-result-set.service';
import { SearchNumbersService } from 'src/app/services/search-numbers.service';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  code:String="";
  state:String="";
  
  constructor(private service:SearchNumbersService,private cuurentResultService:CurrentResultSetService) { }

  ngOnInit(): void {
  }

  search() {
    this.service.searchNumbers(this.state,this.code,1).subscribe((response:any) => {
      this.cuurentResultService.setResult(response);
      this.service.currentState = this.state;
      this.service.currentCode = this.code;
      this.service.searchClicked = true;
    });
  }

}
