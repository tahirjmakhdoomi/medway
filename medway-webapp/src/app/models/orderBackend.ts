export class OrderBackend{
    constructor(
        public medicineName : string,
        public supplierId : number,
        public quantity:number,
        public finalPrice: number
    ){}
}