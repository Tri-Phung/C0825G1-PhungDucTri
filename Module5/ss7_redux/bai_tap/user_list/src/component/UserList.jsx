import { useState, useEffect, useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { toast } from 'react-toastify';
import { getUsersRequest, deleteUserRequest } from '../redux/actions/userActions';
import DeleteConfirmModal from './DeleteConfirmModal';

function UserList() {
    const dispatch = useDispatch();

    const { users, loading, error, deleteStatus } = useSelector(state => state.user);

    const [isModalOpen, setIsModalOpen] = useState(false);
    const [selectedUser, setSelectedUser] = useState(null);

    const prevDeleteStatus = useRef(null);

    const handleGetUsers = () => {
        dispatch(getUsersRequest());
    };

    const handleDeleteClick = (user) => {
        setSelectedUser(user);
        setIsModalOpen(true);
    };
    const handleConfirmDelete = () => {
        if (selectedUser) {
            dispatch(deleteUserRequest(selectedUser.id));
            setIsModalOpen(false);
        }
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
        setSelectedUser(null);
    };

    useEffect(() => {
        if (deleteStatus && deleteStatus !== prevDeleteStatus.current) {
            toast.success("Xóa user thành công!");
            prevDeleteStatus.current = deleteStatus;
        }
    }, [deleteStatus]);

    useEffect(() => {
        if (error) {
            toast.error(`Lỗi: ${error}`);
        }
    }, [error]);

    return (
        <div className="container mt-4">
            <h1 className="mb-4">Quản lý Users</h1>

            <button
                className="btn btn-primary mb-3"
                onClick={handleGetUsers}
                disabled={loading}
            >
                {loading ? 'Đang tải...' : 'Get users'}
            </button>

            <table className="table table-striped table-bordered">
                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Website</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {users.length === 0 ? (
                        <tr>
                            <td colSpan="5" className="text-center">
                                Chưa có dữ liệu. Click "Get users" để tải.
                            </td>
                        </tr>
                    ) : (
                        users.map(user => (
                            <tr key={user.id}>
                                <td>{user.id}</td>
                                <td>{user.name}</td>
                                <td>{user.email}</td>
                                <td>{user.website}</td>
                                <td>
                                    <button
                                        className="btn btn-danger btn-sm"
                                        onClick={() => handleDeleteClick(user)}
                                    >
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>

            <DeleteConfirmModal
                isOpen={isModalOpen}
                onClose={handleCloseModal}
                onConfirm={handleConfirmDelete}
                userName={selectedUser?.name}
            />
        </div>
    );
}

export default UserList;
