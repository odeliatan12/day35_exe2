import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FundsComponent } from './components/funds/funds.component';
import { transferAccount, TransferAccountId } from './models';
import { TransferService } from './transfer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,AfterViewInit {
  
  title = 'client';

  accountId!: TransferAccountId

  @ViewChild(FundsComponent)
  fundsComponent!: FundsComponent;

  constructor(private transferSvc: TransferService){ }

  ngOnInit(): void {
      
  }

  ngAfterViewInit(): void {
    
  }

  processFundTransfer(){
    const transfer: transferAccount = this.fundsComponent.values 
    console.info(">>>>>> transfer values", transfer)
    this.transferSvc.placeTransfer(transfer)
      .then(result => {
        this.accountId = result
      })
    this.fundsComponent.clear()
  }

}
