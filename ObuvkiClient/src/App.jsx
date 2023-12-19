import { useState } from 'react'
import { Routes, Route } from 'react-router-dom'
import { AuthProvider } from './contexts/auth-context'
import Register from './pages/register-page'

function App() {


  return (
    <>
      <AuthProvider>
        <div>
          <Routes>
            <Route path='/register' element={<Register />} />
          </Routes>
        </div>
      </AuthProvider>
    </>
  )
}

export default App
