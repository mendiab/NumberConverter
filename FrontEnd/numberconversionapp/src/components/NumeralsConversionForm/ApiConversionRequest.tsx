export class ApiConversionRequest {
    conversionType: string;
    numberToConvert: string;

    constructor(conversionType: string, numberToConvert: string) {
        this.conversionType = conversionType;
        this.numberToConvert = numberToConvert;
    }
}