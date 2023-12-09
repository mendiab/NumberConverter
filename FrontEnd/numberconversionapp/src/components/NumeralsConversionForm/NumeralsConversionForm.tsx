import React, { useEffect, useState } from "react";
import axios from "axios";
import { ApiConversionRequest } from "./ApiConversionRequest";
import { ApiConversionTypeResponse } from "./ApiConversionTypeResponse";

function NumeralsConversionForm() {
  const [availableConversionTypes, setAvailableConversionTypes] = useState([]);
  const [numberToConvert, setNumberToConvert] = useState("");
  const [conversionType, setConversionType] = useState("");
  const [conversionResult, setConversionResult] = useState("");

  const fetchAvailableConversionTypes = async () => {
    const { data } = await axios.get("http://localhost:8080/api/converters");
    const availableConversionTypes = data;
    setAvailableConversionTypes(availableConversionTypes);
    console.log(availableConversionTypes);
  };

  useEffect(() => {
    fetchAvailableConversionTypes();
  }, []);

  const onOptionChange = (e: any) => {
    setConversionType(e.target.value);
  };

  const handleChange = (e: any) => {
    setNumberToConvert(e.target.value);
  };

  const handleSubmit = async (e: React.ChangeEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const conversionRequest = new ApiConversionRequest(
        conversionType,
        numberToConvert
      );
      console.log(conversionRequest);
      const response = await axios.post("http://localhost:8080/api/conversion", conversionRequest);
      setConversionResult(response.data.conversionResult);
      console.log(response.data.conversionResult);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <label htmlFor="numberToConvert">Number to convert:</label>
        <input
          type="text"
          name="numberToConvert"
          id="numberToConvert"
          onChange={handleChange}
          value={numberToConvert}
          required
          maxLength={20}
        />

        <br />

        {/* Conversion Types as Radio-Buttons*/}
        {availableConversionTypes.map((type: ApiConversionTypeResponse) => (
          <React.Fragment>
            <input
              type="radio"
              onChange={onOptionChange}
              value={type.name}
              name="conversions-types"
            />
            <label>{type.description}</label>
            <br />
          </React.Fragment>
        ))}
        <button>Convert Number</button>
      </form>
      <div>
        <label>Conversion-Result: </label>
        <input readOnly value={conversionResult} />
      </div>
    </div>
  );
}

export default NumeralsConversionForm;
