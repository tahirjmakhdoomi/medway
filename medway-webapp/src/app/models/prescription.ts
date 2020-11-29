export class Prescription{
    constructor(
        public prescriptionId : number,
        public prescriptionContent : String,
        public detectedMedicines : String[],
        public prescriptionPDFLink : String
    ){}
}