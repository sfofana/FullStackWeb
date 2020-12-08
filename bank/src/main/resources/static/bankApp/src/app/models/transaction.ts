export interface Transaction {
    holderId: number;
    accountNumber: number;
    accountName: string;
    amount: number;
    credit: boolean
    transferAccount: string;
    receiverEmail: string;
}
