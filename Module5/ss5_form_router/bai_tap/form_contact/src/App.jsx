import {BrowserRouter, Route, Routes} from "react-router-dom";
import FormContact from "./component/form_contact/FormContact.jsx";
import FormContactSuccess from "./component/form_contact_success/FormContactSuccess.jsx";

function App() {
  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<FormContact />} />
                <Route path="/success" element={<FormContactSuccess />} />
            </Routes>
        </BrowserRouter>
    </>
  )
}

export default App
