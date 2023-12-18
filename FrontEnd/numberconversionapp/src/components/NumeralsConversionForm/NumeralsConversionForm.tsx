//import React, { useEffect, useState } from "react";
import React, { useState } from "react";
// import axios from "axios";
import { ApiConversionRequest } from "./ApiConversionRequest";
import { ApiConversionTypeResponse } from "./ApiConversionTypeResponse";

// Component Properties
interface ConversionTypesProps {
  availableConversionTypes: ApiConversionTypeResponse[];
  // Function returning Promise<string>. Promise was used due to async / await call
  onRequestSubmit: (convesionRequest: ApiConversionRequest) => Promise<string>;
}

function NumeralsConversionForm(
  {availableConversionTypes,onRequestSubmit,}: ConversionTypesProps) {
  const [numberToConvert, setNumberToConvert] = useState("");
  const [conversionType, setConversionType] = useState("");
  const [conversionResult, setConversionResult] = useState("");

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
      const conversionResultFromApi = await onRequestSubmit(conversionRequest); // MENOUER NOTES: HIER EINFACH RESULT SETZEN
      setConversionResult(conversionResultFromApi);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        {/* input number to convert*/}
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

        {/* Available Conversion-Types as Radio-Buttons*/}
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

      {/* Conversion Result read-only field */}
      <div>
        <label>Conversion-Result: </label>
        <input readOnly value={conversionResult} />
      </div>
    </div>
  );
}

export default NumeralsConversionForm;
