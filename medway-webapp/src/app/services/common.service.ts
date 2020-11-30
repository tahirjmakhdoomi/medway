import { Injectable } from "@angular/core";
import { medicineList } from '../models/medicine-list';
import { OrderBackend } from '../models/orderBackend';
@Injectable()
export class commonService{
    orderlist:medicineList[];
    total : number;
    constructor(){}
}