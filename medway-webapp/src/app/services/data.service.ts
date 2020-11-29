import { Injectable } from "@angular/core";
import { orderModel } from '../models/orderModel';

@Injectable()
export class DataService{
    order:orderModel;
    constructor(){}
}