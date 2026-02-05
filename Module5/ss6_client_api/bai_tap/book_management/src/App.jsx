import { Routes, Route } from 'react-router-dom'
import BookList from './component/BookList'
import AddBook from './component/AddBook'
import EditBook from './component/EditBook'

function App() {
  return (
    <Routes>
      <Route path="/" element={<BookList />} />
      <Route path="/add" element={<AddBook />} />
      <Route path="/edit/:id" element={<EditBook />} />
    </Routes>
  )
}

export default App
