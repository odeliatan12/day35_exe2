import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FundsComponent } from './components/funds/funds.component';
import { TransferService } from './transfer.service';

@NgModule({
  declarations: [
    AppComponent,
    FundsComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ TransferService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
