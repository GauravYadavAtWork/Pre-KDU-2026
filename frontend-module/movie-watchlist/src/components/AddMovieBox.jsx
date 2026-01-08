import { useState } from 'react'

const AddMovieBox = ({ addMovie }) => {

  const [name, setName] = useState("")
  const [rating, setRating] = useState("")

  function handleAdd() {
    if (!name || !rating) {
      alert("Please enter movie name and rating")
      return
    }

    addMovie(name, Number(rating))
    setName("")
    setRating("")
  }

  return (
    <div className='addMovieContainer'>
      <p>Movie Name</p>
      <input
        className='movieNameInputBox'
        placeholder='Enter movie name ...'
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <p>Rating</p>
      <select
        id='selectdropdown'
        value={rating}
        onChange={(e) => setRating(e.target.value)}
      >
        <option value="">Select rating</option>
        <option value="1">1 star</option>
        <option value="2">2 star</option>
        <option value="3">3 star</option>
        <option value="4">4 star</option>
        <option value="5">5 star</option>
      </select>

      <button id='addButton' onClick={handleAdd}>
        + Add to Watchlist
      </button>
    </div>
  )
}

export default AddMovieBox
