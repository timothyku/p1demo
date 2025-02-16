import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { Login } from './Components/LoginRegister/Login'
import { Register } from './Components/LoginRegister/Register'

import 'bootstrap/dist/css/bootstrap.css'
//^ This is a required manual import for bootsrap to work!!

function App() {
 

  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* empty string or / for path makes the component render at startup */}
          <Route path="" element={<Login/>}/>
          <Route path="register" element={<Register/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
