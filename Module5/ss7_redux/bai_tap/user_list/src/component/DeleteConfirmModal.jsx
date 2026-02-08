import Modal from 'react-modal';

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
        width: '90%'
    },
    overlay: {
        backgroundColor: 'rgba(0, 0, 0, 0.5)'
    }
};

Modal.setAppElement('#root');

function DeleteConfirmModal({ isOpen, onClose, onConfirm, userName }) {
    return (
        <Modal
            isOpen={isOpen}
            onRequestClose={onClose}
            style={customStyles}
            contentLabel="Xác nhận xóa"
        >
            <h5 className="mb-3">Xác nhận xóa</h5>
            <p>Bạn có chắc chắn muốn xóa user <strong>{userName}</strong>?</p>
            <div className="d-flex justify-content-end gap-2">
                <button className="btn btn-secondary" onClick={onClose}>
                    Hủy
                </button>
                <button className="btn btn-danger" onClick={onConfirm}>
                    Xóa
                </button>
            </div>
        </Modal>
    );
}

export default DeleteConfirmModal;
