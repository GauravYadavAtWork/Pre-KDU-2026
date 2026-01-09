import { useEffect, useState } from 'react'
import ListItem from './ListItem'

const Renderer = ({ movies, deleteMovie , clearAll, watched}) => {

  const [searchText, setSearchText] = useState("")
  const [debouncedSearch, setDebouncedSearch] = useState("")

  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedSearch(searchText)
    }, 300)

    return () => clearTimeout(timer)
  }, [searchText])

  const filteredMovies = movies.filter(movie =>
    movie.name
      .toLowerCase()
      .includes(debouncedSearch.toLowerCase())
  )

  return (
    <>
    <div className='searchBox'>
      <input
          id='searchInputBox'
          placeholder="Search Movies..."
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
          />
    </div>

    <div className='rendererBox'>
      <div id='rendererline'>
        <p>Movies in Watchlist: <span id='counter'> {movies.length} </span></p>
        <p id='clearAllLink' onClick={clearAll}>Clear All</p>
      </div>
    </div>

    {filteredMovies.map(movie => (
      <ListItem
        key={movie.id}
        id={movie.id}
        movieName={movie.name}
        rating={movie.rating}
        isWatched={movie.isWatched}
        deleteMovie={deleteMovie}
        watched={watched}
        />
        ))}
    </>
  )
}

export default Renderer
