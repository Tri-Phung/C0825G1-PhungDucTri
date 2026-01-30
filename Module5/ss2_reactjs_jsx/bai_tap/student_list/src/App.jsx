import React, { useState } from 'react'
import StudentList from './components/list/StudentList.jsx'
import './App.css'

function App() {
  const [students] = useState([
      {
          id: 1,
          company: 'Alfreds Futterkiste',
          contact: 'Maria Anders',
          country: 'Germany'
      },
      {
          id: 2,
          company: 'Centro comercial Moctezuma',
          contact: 'Francisco Chang',
          country: 'Mexico'
      },
      {
          id: 3,
          company: 'Ernst Handel',
          contact: 'Roland Mendel',
          country: 'Austria'
      },
      {
          id: 4,
          company: 'Island Trading',
          contact: 'Helen Bennett',
          country: 'UK'
      },
      {
          id: 5,
          company: 'Laughing Bacchus Winecellars',
          contact: 'Yoshi Tannamuri',
          country: 'Canada'
      },
      {
          id: 6,
          company: 'Magazzini Alimentari Riuniti',
          contact: 'Giovanni Rovelli',
          country: 'Italy'
      }
  ]);

  return (
    <div className="StudentList">
        <h1>Students</h1>
        <hr/>
        <StudentList students={students} />
    </div>
  )
}

export default App;
