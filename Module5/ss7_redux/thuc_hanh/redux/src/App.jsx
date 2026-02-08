import './App.css'
import {Provider} from "react-redux";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import User from "./component/user/User.jsx";
import Login from "./component/Login/Login.jsx";
import store from "./redux/store.js"

function App() {

  return (
    <>
      <Provider store={store}>
          <BrowserRouter>
              <Routes>
                  <Route path='/' element={<Login />} />
                  <Route path='/users' element={<User />} />
              </Routes>
          </BrowserRouter>
      </Provider>
    </>
  )
}

export default App
