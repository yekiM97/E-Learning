import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Categories } from "../model/categories.model";
import { CommandURL } from "../url/command-url";



@Injectable({
  providedIn: "root",
})
export class CategoryService {
  constructor(private http: HttpClient) {}

 

  //ADMIN
  getListCategoryAdmin(json: any) {
    return this.http.post<Array<Categories>>(
      CommandURL.LIST_CATEGORY_ADMIN,
      json
    );
  }

 
}
