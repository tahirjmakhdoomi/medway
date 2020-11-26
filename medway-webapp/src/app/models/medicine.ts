
// Data model for Medicine
export class Medicine {
    public constructor(
        public medicineName:string,
        public mfgdate : Date,
        public expiryDOB: Date,
        public quantity: number,
        public discount: number,
        public price: number,
        public supplierName: string
    ){};
}

