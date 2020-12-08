import { AccountHolder } from './account-holder';

export interface Account {
    number: number;
    name: string;
    credit: boolean;
    balance: number;
    holder: number;
}
