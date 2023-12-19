import { Routes, Route } from 'react-router-dom'
import { AuthProvider } from './contexts/auth-context'
import Register from './pages/register-page'
import Login from './pages/login-page'
import Cart from './components/cart/cart.jsx'
import ProductList from './pages/product-list'
import { ProductProvider } from './contexts/product-context'
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from './components/navbar/navbar'

function App() {


  return (
    <>
      <AuthProvider>
        <Navbar />
        <ProductProvider>
        <div>
          <Routes>
            <Route path='/register' element={<Register />} />
            <Route path='/login' element={<Login />} />
            <Route path={'/cart'} element={<Cart />} />
            <Route exact path="/" element={<ProductList/>} />
          </Routes>
        </div>
        </ProductProvider>
      </AuthProvider>
    </>
  )
}

export default App
