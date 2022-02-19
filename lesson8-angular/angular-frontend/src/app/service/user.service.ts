import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public http: HttpClient) { }

  public findAll(){
    return this.http.get<User[]>("api/v1/user/all");
  }

  public findById(id:number){
    return this.http.get<User>(`api/v1/user/${id}/id`);
  }

  public create(user: User){
    return this.http.post<User>("api/v1/user", user);
  }

  public update(user: User){
    return this.http.put<User>("api/v1/user", user);
  }

  public delete(id: number){
    return this.http.delete<User>(`api/v1/user/${id}/id`);
  }
}
