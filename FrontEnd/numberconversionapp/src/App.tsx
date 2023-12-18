import "./App.css";
import { useEffect, useState } from "react";
import NumeralsConversionForm from "./components/NumeralsConversionForm/NumeralsConversionForm";
import { ApiConversionRequest } from "./components/NumeralsConversionForm/ApiConversionRequest";
import { fetchApiAvailableConversionTypes, sendConversionRequestToApi } from "./api/NumeralsConversionApiClient";

// Parent Component
function App() {

  // Available Conversion Types
  const [availableConversionTypes, setAvailableConversionTypes] = useState([]);

  const fetchAvailableConversionTypes = async () => {
    const availableConversionTypes = await fetchApiAvailableConversionTypes();
    setAvailableConversionTypes(availableConversionTypes);
  };

  // Will be called when loading the component
  useEffect(() => {
    fetchAvailableConversionTypes();
  }, []); // only one time!

  // This function will be called when the form is submitted
  const sendConversionRequest = async (conversionRequest:ApiConversionRequest) => {
    return await sendConversionRequestToApi(conversionRequest);
  }

  return (
    <div>
      <blockquote cite="Dr. Menouer Diab">
        Play with numerals conversion.
      </blockquote>
      <div className="container">
        <NumeralsConversionForm availableConversionTypes={availableConversionTypes} onRequestSubmit={sendConversionRequest} />
      </div>
    </div>
  );
}

export default App;
