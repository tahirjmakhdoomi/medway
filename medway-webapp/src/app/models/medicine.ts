
// Data model for Medicine
export class Medicine {
    public constructor(
        public medicineName:string,
        public manufactureDate : Date,
        public expDate: Date,
        public stock: number,
        public discount: number,
        public price: number,
        public supplierName: String
    ){};
}

