import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { Container, Table, Button } from 'react-bootstrap'
import { toast } from 'react-toastify'
import { getAllBooks, deleteBook } from '../service/bookService'
import DeleteConfirmModal from './DeleteConfirmModal'

function BookList() {
    const [books, setBooks] = useState([])
    const [loading, setLoading] = useState(true)
    const [selectedBook, setSelectedBook] = useState(null)
    const [isModalOpen, setIsModalOpen] = useState(false)
    const navigate = useNavigate()

    const fetchBooks = async () => {
        try {
            const data = await getAllBooks()
            setBooks(data)
        } catch (error) {
            toast.error('Lỗi khi tải danh sách sách!')
        } finally {
            setLoading(false)
        }
    }

    useEffect(() => {
        fetchBooks()
    }, [])

    const handleDeleteClick = (book) => {
        setSelectedBook(book)
        setIsModalOpen(true)
    }

    const handleCloseModal = () => {
        setIsModalOpen(false)
        setSelectedBook(null)
    }

    const handleConfirmDelete = async () => {
        try {
            await deleteBook(selectedBook.id)
            toast.success('Xóa sách thành công!')
            handleCloseModal()
            await fetchBooks()
        } catch (error) {
            toast.error('Lỗi khi xóa sách!')
        }
    }

    if (loading) {
        return (
            <Container className="mt-4">
                <p>Đang tải...</p>
            </Container>
        )
    }

    return (
        <Container className="mt-4">
            <h1 className="mb-4">Library</h1>
            <Button
                variant="primary"
                className="mb-3"
                onClick={() => navigate('/add')}
            >
                Add a new Book
            </Button>

            <Table striped bordered hover responsive>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map((book) => (
                        <tr key={book.id}>
                            <td>{book.title}</td>
                            <td>{book.quantity}</td>
                            <td>
                                <Button
                                    variant="warning"
                                    size="sm"
                                    className="me-2"
                                    onClick={() => navigate(`/edit/${book.id}`)}
                                >
                                    Edit
                                </Button>
                                <Button
                                    variant="danger"
                                    size="sm"
                                    onClick={() => handleDeleteClick(book)}
                                >
                                    Delete
                                </Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

            <DeleteConfirmModal
                isOpen={isModalOpen}
                onClose={handleCloseModal}
                onConfirm={handleConfirmDelete}
                book={selectedBook}
            />
        </Container>
    )
}

export default BookList
