export class medicineList{
    public constructor(
        public medicineName : String,
        public supplierName : String,
        public manufactureDate: String,
        public expDate: String, 
        public stock: number,
        public discount: number,
        public price: number,
        public quantity:number,
        public finalPrice: number
    ){}

}