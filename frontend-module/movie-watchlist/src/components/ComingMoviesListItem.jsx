import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

const ComingMoviesListItem = ({ movieName }) => {
  const [counter, setCounter] = useState(15)
  const [isRunning, setIsRunning] = useState(false)
  const [isFinished, setIsFinished] = useState(false)
  const navigate = useNavigate()

  function handleStartButton() {
    if (isRunning) return
    setIsRunning(true)
  }

  function handlePauseButton() {
    setIsRunning(false)
  }

  function handleBookTicketButton() {
    navigate(`/bookTicket/${movieName}`)
  }

  useEffect(() => {
    if (!isRunning) return

    function updateTimer(){
      setCounter(prev => {
        if (prev === 1) {
          setIsRunning(false)
          setIsFinished(true)
          return 0
        }
        return prev - 1
      })
    }
    const intervalId = setInterval(updateTimer, 1000)
    return () => clearInterval(intervalId)
  }, [isRunning])

  return (
    <div className='newMovieListItem'>
      <div>Movie: {movieName}</div>
      <div>Count Down: {counter}</div>

      {!isFinished && (
        <>
          <button
            className='newMovieListItembuttons'
            onClick={handleStartButton}
          >
            Start Countdown
          </button>

          <button
            className={`newMovieListItembuttons ${!isRunning ? 'disableButton' : ''}`}
            disabled={!isRunning}
            onClick={handlePauseButton}
          >
            Pause Countdown
          </button>
        </>
      )}

      {isFinished && (
        <button
          className='bookTicketBtnActive'
          onClick={handleBookTicketButton}
        >
          Book Ticket
        </button>
      )}
    </div>
  )
}

export default ComingMoviesListItem
