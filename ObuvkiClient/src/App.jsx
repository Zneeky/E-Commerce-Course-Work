import { Routes, Route } from 'react-router-dom'
import { AuthProvider } from './contexts/auth-context'
import Register from './pages/register-page'
import Login from './pages/login-page'

function App() {


  return (
    <>
      <AuthProvider>
        <div>
          <Routes>
            <Route path='/register' element={<Register />} />
            <Route path='/login' element={<Login />} />
          </Routes>
        </div>
      </AuthProvider>
    </>
  )
}

export default App
