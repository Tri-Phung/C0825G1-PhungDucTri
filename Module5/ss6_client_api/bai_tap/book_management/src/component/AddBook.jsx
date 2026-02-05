import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { createBook } from '../service/bookService'
import BookForm from './BookForm'

function AddBook() {
    const navigate = useNavigate()

    const handleSubmit = async (data) => {
        try {
            await createBook(data)
            toast.success('Thêm sách thành công!')
            navigate('/')
        } catch (error) {
            toast.error('Lỗi khi thêm sách!')
        }
    }

    return (
        <BookForm
            onSubmit={handleSubmit}
            submitLabel="Add"
            title="Add a new Book"
        />
    )
}

export default AddBook
