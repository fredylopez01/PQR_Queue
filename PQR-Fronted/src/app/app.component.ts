import { Component } from '@angular/core';
import { MyClaim } from './models/MyClaim';
import { ClaimService } from './services/claim.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public claim: MyClaim[]=[];

  constructor(private claimService:ClaimService){}

  ngOnInit(): void {
    this.getClaims();
  }

  public getClaims():void{
    this.claimService.getClaims().subscribe(
      (response:MyClaim[])=>{
        this.claim = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }
}
