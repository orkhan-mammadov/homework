import logo from './logo.svg';
import './App.css';
import UserComponent from './components/UserComponent';
import Products from "./components/Products"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { routes } from "./Routes";
import Navbar from './components/Navbar';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <Routes>
            <Route exact path="/profile" element={<UserComponent user={'jalal'}/>} />
            <Route exact path="/" element={<Products />} />
        </Routes>
      </div>
    </BrowserRouter>

  );
}

export default App;
