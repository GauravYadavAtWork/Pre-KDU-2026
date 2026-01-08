import React from 'react'

const ListItem = ({ id, movieName, rating , deleteMovie}) => {

  function handleDelete(){
    console.log("handling delete", id);
    console.log(typeof deleteMovie);
    deleteMovie(id);
  }

  return (
    <div className='listitem'>
      <div>{movieName}</div>
      <div>⭐ {rating}</div>
      <button className='deletebutton' onClick={handleDelete}>Delete</button>
    </div>
  )
}

export default ListItem
