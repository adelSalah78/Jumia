import { Country } from "./country.model";

export class Result {
    country:Country[] = [];
    pageSize:number=0;
    resultSize:number=0;
    pageNo:number=0;
}