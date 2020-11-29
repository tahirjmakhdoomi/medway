export class medicineList{
    public constructor(
        public medicineName : string,
        public supplierId : number,
        public manufactureDate: String,
        public expDate: String, 
        public stock: number,
        public discount: number,
        public price: number,
        public quantity:number = 0,
        public finalPrice: number
    ){}

}