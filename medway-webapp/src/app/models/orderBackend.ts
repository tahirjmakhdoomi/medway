export class OrderBackend{
    constructor(
        public medicineName : string,
        public quantity:number,
        public finalPrice: number,
        public supplierId : number
 
    ){}
}