import { useState } from 'react'
import '../App.css'
import AddMovieBox from '../components/AddMovieBox'
import Renderer from '../components/Renderer'
import Title from '../components/Title'
import { v4 as uuidv4 } from 'uuid'
import ComingSoonSection from '../components/ComingSoonSection'

class MovieItem{
  constructor(name, rating){
    this.name = name;
    this.rating = rating;
    this.id = uuidv4();
    this.isWatched = false;
  }
}

function HomePage() {
  const [movieList, setMovieList] = useState([
    new MovieItem("Inception", 5),
    new MovieItem("Interstellar", 4),
    new MovieItem("The Dark Knight", 5),
  ]);

  function addMovie(name, rating) {
    const duplicate = movieList.filter(movie => {
      return movie.name.toLowerCase() === name.toLowerCase().trim();
    });

    if(duplicate.length === 0){
      const newMovie = new MovieItem(name.trim(), rating)
      setMovieList(prev => [...prev, newMovie])
    }else{
      alert("Duplicate movie name")
    }
  }

  function deleteMovie(id) {
    const newList = movieList.filter(movie => movie.id !== id);
    setMovieList(newList);
  }

  function clearAll(){
    setMovieList([]);
  }

  function watched(id){
    const updateMovies = movieList.map(movie => {
      if(movie.id === id){
        movie.isWatched = true;
      }
      return movie;
    });

    setMovieList(updateMovies);
  }  

  return (
    <>
      <div className='container'>
        <Title></Title>
        <AddMovieBox addMovie={addMovie}></AddMovieBox>
        <Renderer movies={movieList} deleteMovie={deleteMovie} clearAll={clearAll} watched={watched}></Renderer>
      </div>
      <ComingSoonSection></ComingSoonSection>
    </>
  )
}

export default HomePage
