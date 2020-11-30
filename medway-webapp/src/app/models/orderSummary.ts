import { OrderBackend } from './orderBackend';

export class OrderSummary{
    public constructor(
        public orderId: number,
        public orderedBy: String,
        public orderedOn: Date,
        public totalPrice: number,
        public contactNumber: number,
        public paymentCompleted: boolean,
        public addressLine1: String,
        public addressLine2: String,
        public city: String,
        public state: String,
        public pinCode: number,
        public orderDetails: OrderBackend[]
    ){}
}