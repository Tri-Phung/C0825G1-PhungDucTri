
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Step1 from "./component/health_form/Step1.jsx";
import Step2 from "./component/health_form/Step2.jsx";
import Success from "./component/form_success/Success.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Step1 />} />
                <Route path="/step2" element={<Step2 />} />
                <Route path="/success" element={<Success />} />
            </Routes>
        </BrowserRouter>
    </>
  )
}

export default App
