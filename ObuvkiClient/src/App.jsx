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
import Details from './pages/detail.jsx'
import AuthGuard from './components/guards/auth-guard.jsx'
import NotFound from './components/not-found.jsx'

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
            <Route element={<AuthGuard />}>
              <Route path={'/cart'} element={<Cart />} />
              <Route path="/details" element={<Details/>} />
              <Route exact path="/" element={<ProductList/>} />
            </Route>
            <Route path='*' element={<NotFound />} />
          </Routes>
        </div>
        </ProductProvider>
      </AuthProvider>
    </>
  )
}

export default App
