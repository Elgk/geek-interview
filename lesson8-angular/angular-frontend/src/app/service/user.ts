export class User{

  constructor(public id:number | null,
              public firstName:string,
              public lastName:string,
              public login:string,
              public password:string) {
  }
}
