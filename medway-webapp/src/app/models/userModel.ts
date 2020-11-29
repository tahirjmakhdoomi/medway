import { OrderSummary } from './orderSummary';

export class UserModel {
  public constructor(
    public name: string,
    public user_name: string,
    public user_email: string,
    public user_password: string,
    public user_phone: number,
    public user_storeName : string,
    public user_city: string,
    public user_pin: number,
    public user_state: string,
    public orderSummaries: OrderSummary[]
  ) {}
}
