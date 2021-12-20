import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Result } from 'src/app/models/result.model';
import { CurrentResultSetService } from 'src/app/services/current-result-set.service';
import { SearchNumbersService } from 'src/app/services/search-numbers.service';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  result:Result= new Result();
  page:number = 1;

  subscribtion:Subscription = new Subscription();

  constructor(private service:CurrentResultSetService,private searchService:SearchNumbersService) { }

  ngOnInit(): void {
    this.subscribtion=  this.service.currentMessage.subscribe((response:any) =>{
      this.result = response;
      this.page = this.result.pageNo;
    });
  }

  loadPage(event:any) {
    this.searchService.searchNumbers(this.searchService.currentState,this.searchService.currentCode,event).subscribe((response:any) => {
      this.service.setResult(response);
    });
  }

  ngOnDestroy() {
    this.subscribtion.unsubscribe();
    console.log("destroyed!");
  }

}
