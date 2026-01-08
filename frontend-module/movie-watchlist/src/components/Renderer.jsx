import { useEffect, useState } from 'react'
import ListItem from './ListItem'

const Renderer = ({ movies, deleteMovie , clearAll}) => {

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
    <div>
      <input
        placeholder="Search Movies..."
        value={searchText}
        onChange={(e) => setSearchText(e.target.value)}
      />

      <div>
        <p>Movies in Watchlist {movies.length}</p>
        <button onClick={clearAll}>Clear All</button>
      </div>

      <div>
        {filteredMovies.map(movie => (
          <ListItem
            key={movie.id}
            id={movie.id}
            movieName={movie.name}
            rating={movie.rating}
            deleteMovie={deleteMovie}
          />
        ))}
      </div>
    </div>
  )
}

export default Renderer
