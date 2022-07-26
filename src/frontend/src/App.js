import logo from './logo.svg';
import './App.css';
import UserComponent from './components/UserComponent';
import Products from "./components/Products"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { routes } from "./Routes";
import Navbar from './components/Navbar';
import ProductDetails from './components/ProductDetails';
import AddProduct from './components/AddProduct';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <Routes>
            <Route exact path="/profile" element={<UserComponent user={'orkhan'}/>} />
            <Route exact path="/" element={<Products />} />
            <Route path="/product/:productId" element={<ProductDetails />}/>
            <Route path="/addProduct" element={<AddProduct />}/>
        </Routes>
      </div>
    </BrowserRouter>

  );
}

export default App;
