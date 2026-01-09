import React from 'react'

const ListItem = ({ id, movieName, rating, isWatched , deleteMovie, watched}) => {

  function handleDelete(){
    console.log("handling delete", id);
    console.log(typeof deleteMovie);
    deleteMovie(id);
  }

  function handleWatchEvent(){
    console.log("handling watch event", id);
    watched(id);
  }

  return (
    <div className='listitem'>
      <>
      {isWatched ? <>
        <div className='watchedmoviename'>{movieName}</div>
      </> : 
      <>
      <div>{movieName}</div>
      </>}
      </>
      <div>⭐ {rating}</div>
      <button className='deletebutton' onClick={handleDelete}>Delete</button>
      <button className='watchedButton' onClick={handleWatchEvent}>watch</button>
    </div>
  )
}

export default ListItem
