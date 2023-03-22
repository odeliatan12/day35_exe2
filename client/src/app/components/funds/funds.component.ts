import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { Account, transferAccount } from 'src/app/models';
import { TransferService } from 'src/app/transfer.service';

@Component({
  selector: 'app-funds',
  templateUrl: './funds.component.html',
  styleUrls: ['./funds.component.css']
})
export class FundsComponent implements OnInit {

  form!: FormGroup
  accounts: Account[] = []

  constructor(private fb: FormBuilder, private transferSvc: TransferService){ }

  get values(): transferAccount {
    return this.form.value as transferAccount
  }

  ngOnInit(): void {

    this.form = this.createFundsTransferForm()
    this.transferSvc.getAccounts()
        .then(result => this.accounts = result)
  }

  clear(){
    this.form.reset()
  }

  private createFundsTransferForm(): FormGroup {
    return this.fb.group({
      fromAccount: this.fb.control<string>('', [Validators.required]),
      toAccount: this.fb.control<string>('', Validators.required),
      amount: this.fb.control<number>(10, [Validators.required, Validators.min(10)]),
      comments: this.fb.control<string>('')
    });
  }

}
