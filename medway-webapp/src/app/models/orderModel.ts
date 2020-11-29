export class orderModel {
    public constructor(
      public user_email: string,
      public user_phone: number,
      public user_address1 : string,
      public user_address2 : string,
      public user_city: string,

      public user_state: string,
      public user_pin: number,
      public paymentStatus:boolean
    ) {}
  }
  