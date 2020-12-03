import { CompositeKey } from './supplier-composit-key';

// Data model for Medicine
export class Medicine {
    public constructor(
        public compositeKey : CompositeKey,
        public manufactureDate : Date,
        public expDate: Date,
        public stock: number,
        public discount: number,
        public price: number
    ){};
}

