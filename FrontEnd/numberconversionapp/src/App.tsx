import "./App.css";
import NumeralsConversionForm from "./components/NumeralsConversionForm/NumeralsConversionForm";

// const conversionTypes= [];

function App() {
  return (
    <div>
      <blockquote cite="Dr. Menouer Diab">
        Play with numerals conversion.
      </blockquote>
      <div className="container">
        <NumeralsConversionForm />
      </div>
    </div>
  );
}

export default App;
