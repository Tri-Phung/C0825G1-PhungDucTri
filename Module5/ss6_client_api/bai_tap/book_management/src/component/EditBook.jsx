import { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import { toast } from 'react-toastify'
import { getBookById, updateBook } from '../service/bookService'
import BookForm from './BookForm'

function EditBook() {
    const { id } = useParams()
    const navigate = useNavigate()
    const [book, setBook] = useState(null)
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        const fetchBook = async () => {
            try {
                const data = await getBookById(id)
                setBook(data)
            } catch (error) {
                toast.error('Lỗi khi tải thông tin sách!')
                navigate('/')
            } finally {
                setLoading(false)
            }
        }
        fetchBook()
    }, [id, navigate])

    const handleSubmit = async (data) => {
        try {
            await updateBook(id, data)
            toast.success('Cập nhật sách thành công!')
            navigate('/')
        } catch (error) {
            toast.error('Lỗi khi cập nhật sách!')
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
        <BookForm
            onSubmit={handleSubmit}
            defaultValues={book}
            submitLabel="Save"
            title="Edit"
        />
    )
}

export default EditBook
