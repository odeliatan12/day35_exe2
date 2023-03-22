import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, Subject } from "rxjs";
import { Account, transferAccount, TransferAccountId } from "./models";

const URL = "http://localhost:8080/transfer"

const URL_GETACCOUNTS = "http://localhost:8080/accounts"

@Injectable()
export class TransferService {

    onNewAccount = new Subject<Promise<Account[]>>()

    accounts: Account[] = []
    
    constructor(private http: HttpClient){}

    placeTransfer(transferAcc : transferAccount):Promise<TransferAccountId>{
        return firstValueFrom(
            this.http.post<TransferAccountId>(URL, transferAcc)
        )
    }

    getAccounts():Promise<Account[]>{
        return firstValueFrom(
            this.http.get<Account[]>(URL_GETACCOUNTS)
        ).then(result => {
            this.accounts = result.map(
                (c:any) => (
                    {
                        account_id: c.account_id,
                        name: c.name,
                        balance: c.balance
                    } as Account
                )
            )
            return this.accounts
        })
    }
}