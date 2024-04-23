import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { MyClaim } from 'src/app/models/MyClaim';
import { ClaimService } from 'src/app/services/claim.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./imbox.component.css']

  
})
export class InboxComponent {
  @Input() claims:MyClaim[] = [];
  @Output() claimSended:EventEmitter<void> = new EventEmitter<void>();
  public lastMessage: MyClaim | undefined;

  constructor(private claimService:ClaimService, private http:HttpClient){}

  onDeleteClaim():void{
    this.claimService.deleteClaim().subscribe(
      (response: MyClaim) => {
        this.claimSended.emit();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      },
    );
  }

  public openModalDeleteMessage():void{
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#deleteLastMessage');
    button.click();
  }

  public openModalLastClaim(message:MyClaim):void{
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#showLastMessage');
    this.lastMessage = message;
    button.click();
  }

  onLastClaim():void{
    this.claimService.lastClaim().subscribe(
      (response: MyClaim) => {
        this.openModalLastClaim(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      },
    );
  }

  onSendClaim(addMessage: NgForm):void {
    document.getElementById('close')?.click();
    this.claimService.sendClaim(addMessage.value).subscribe(
      (response: MyClaim) => {
        this.claimSended.emit();
        addMessage.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addMessage.reset();
      },
    );
  }
  
}
