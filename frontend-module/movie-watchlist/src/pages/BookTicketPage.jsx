import React from 'react'
import { useParams } from 'react-router-dom'
import Title from '../components/Title';

const BookTicketPage = () => {
    const {movieName} = useParams();
  return (
    <div>
        <h1>{movieName}</h1>
        <h2>Booking tickets for: {movieName}</h2>
    </div>
  )
}

export default BookTicketPage