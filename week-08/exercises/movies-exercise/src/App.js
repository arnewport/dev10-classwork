import React from 'react';
import Heading from './Heading';
import Numbers from './Numbers';
import Movies from './Movies';

const headings = [
  {
    id: 1,
    text: 'Alpha'
  },
  {
    id: 2,
    text: 'Beta'
  },
  {
    id: 3,
    text: 'Gamma'
  }
]

const numbersToDisplay = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const movies = [
  { id: 1, title: 'Toy Story', releaseYear: 1995 },
  { id: 2, title: 'The Iron Giant', releaseYear: 1999 },
  { id: 3, title: 'Spider-Man: Into the Spider-Verse', releaseYear: 2018 },
];


function App() {
    return (
      <div>
        {headings.map(heading => (<Heading heading={heading} key={heading.id} />))}
        <ul>
          {numbersToDisplay.map(number => (<Numbers value={number} key={number}/>))}
        </ul>
        {movies.map(movie => (<Movies movie={movie} key={movie.id} />))}
      </div>
    )
}

export default App;
