import { useState } from 'react'
import './App.css'
import AddMovieBox from './components/AddMovieBox'
import Renderer from './components/Renderer'
import Title from './components/Title'
import { v4 as uuidv4 } from 'uuid'

class MovieItem{
  constructor(name, rating){
    this.name = name;
    this.rating = rating;
    this.id = uuidv4()
  }
}

function App() {
  const [movieList, setMovieList] = useState([
    new MovieItem("Inception", 5),
    new MovieItem("Interstellar", 4),
    new MovieItem("The Dark Knight", 5),
  ]);

  function addMovie(name, rating) {
    const newMovie = new MovieItem(name, rating)
    setMovieList(prev => [...prev, newMovie])
  }

  function deleteMovie(id) {
    setMovieList(prev => prev.filter(movie => movie.id !== id))
  }

  function clearAll(){
    setMovieList([]);
  }

  return (
    <>
      <div className='container'>
        <Title></Title>
        <AddMovieBox addMovie={addMovie}></AddMovieBox>
        <Renderer movies={movieList} deleteMovie={deleteMovie} clearAll={clearAll}></Renderer>
      </div>
    </>
  )
}

export default App
