import { OrderBackend } from './orderBackend';

export class OrderSummary{
    public constructor(
        public orderDetails: OrderBackend[],
        public orderedBy: String,
        public orderedOn: Date,
        public paymentStatus: boolean,
        public user_address1: String,
        public user_address2: String,
        public user_city: String,
        public user_email : String,
        public user_phone: number,
        public user_pin: number,
        public user_state: String,
    ){}
}