import HomePage from './pages/HomePage.jsx'
import React from 'react'
import {Routes, Route, Router} from 'react-router-dom'
import BookTicketPage from './pages/BookTicketPage.jsx'

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<HomePage></HomePage>}></Route>
        <Route path='/bookTicket/:movieName' element={<BookTicketPage></BookTicketPage>}></Route>
      </Routes>
    </>
  )
}

export default App
