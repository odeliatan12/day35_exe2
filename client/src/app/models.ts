export interface transferAccount{
    fromAccount: string
    toAccount: string
    amount: number
    comments: string
}

export interface Account{
    account_id: string
    name: string
    balance: number
}

export interface TransferAccountId{
    id: string
}