import { Injectable } from "@angular/core";
import { OrderBackend } from '../models/orderBackend';
@Injectable()
export class commonService{
    orderlist:OrderBackend[];
    constructor(){}
}