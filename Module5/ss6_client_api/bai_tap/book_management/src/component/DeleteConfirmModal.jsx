import Modal from 'react-modal'
import { Button } from 'react-bootstrap'

const customStyles = {
    content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)',
        padding: '20px',
        borderRadius: '8px',
        maxWidth: '400px',
        width: '90%',
    },
    overlay: {
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
    },
}

function DeleteConfirmModal({ isOpen, onClose, onConfirm, book }) {
    if (!book) return null

    return (
        <Modal
            isOpen={isOpen}
            onRequestClose={onClose}
            style={customStyles}
            contentLabel="Delete Confirmation"
        >
            <h4 className="mb-3">Xác nhận xóa</h4>
            <p>Bạn có chắc chắn muốn xóa sách này?</p>
            <div className="border rounded p-3 mb-3 bg-light">
                <p className="mb-1">
                    <strong>Title:</strong> {book.title}
                </p>
                <p className="mb-0">
                    <strong>Quantity:</strong> {book.quantity}
                </p>
            </div>
            <div className="d-flex justify-content-end gap-2">
                <Button variant="secondary" onClick={onClose}>
                    Cancel
                </Button>
                <Button variant="danger" onClick={onConfirm}>
                    Delete
                </Button>
            </div>
        </Modal>
    )
}

export default DeleteConfirmModal
