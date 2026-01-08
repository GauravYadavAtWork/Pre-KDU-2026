import React from 'react'

const ListItem = ({ id, movieName, rating , deleteMovie}) => {

  function handleDelete(){
    console.log("handling delete", id);
    console.log(typeof deleteMovie);
    deleteMovie(id);
  }

  return (
    <div>
      <div>{movieName}</div>
      <div>⭐ {rating}</div>
      <button onClick={handleDelete}>Delete</button>
    </div>
  )
}

export default ListItem
