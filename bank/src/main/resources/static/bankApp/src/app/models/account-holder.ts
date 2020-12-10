import { Account } from './account';

export interface AccountHolder {
    id: number;
    firstname: string;
    lastname: string;
    dob: string;
    address: string;
    ssn: number;
    loggedin: boolean;
    activeDate: string;
    creditScore: number;
    email: string;
    password: string;
    accounts: Account[];
}
