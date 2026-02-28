import React from 'react'
import ComingMoviesListItem from './ComingMoviesListItem'

const ComingSoonSection = () => {
  return (
    <div className='comingSoonContainer'>
        <p id='comingSoonSectionTitle'>Coming Soon</p>
        <ComingMoviesListItem movieName={"Test 1"}></ComingMoviesListItem>
        <ComingMoviesListItem movieName={"Test 2"}></ComingMoviesListItem>
        <ComingMoviesListItem movieName={"Test 3"}></ComingMoviesListItem>
    </div>
  )
}

export default ComingSoonSection