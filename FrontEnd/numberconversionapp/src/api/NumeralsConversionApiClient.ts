import axios from "axios";
import { ApiConversionRequest } from "../components/NumeralsConversionForm/ApiConversionRequest";

const apiBaseUrl = "http://localhost:8080/api/";
const apiConverterTypesUrl = apiBaseUrl + "converters";
const apiConversionUrl = apiBaseUrl + "conversion";

/* Api client*/
const fetchApiAvailableConversionTypes = async () => {
    const { data } = await axios.get(apiConverterTypesUrl);
    const availableConversionTypes = data;
    return availableConversionTypes;
};

const sendConversionRequestToApi = async (conversionRequest:ApiConversionRequest) => {
  const response = await axios.post(apiConversionUrl, conversionRequest);
  return response.data.conversionResult;
}

export { fetchApiAvailableConversionTypes, sendConversionRequestToApi }; // Export all api functions

