import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { InboxComponent } from './components/imbox/inbox.component';
import { HttpClientModule } from '@angular/common/http';
import { ClaimService } from './services/claim.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    InboxComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClaimService],
  bootstrap: [AppComponent]
})
export class AppModule { }
