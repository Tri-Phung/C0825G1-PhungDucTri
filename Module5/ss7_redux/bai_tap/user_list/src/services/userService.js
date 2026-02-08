import axios from 'axios';

const API_URL = 'http://localhost:8080';
export const getUsers = async () => {
    const response = await axios.get(`${API_URL}/users`);
    return response;
};
export const deleteUser = async (userId) => {
    const response = await axios.delete(`${API_URL}/users/${userId}`);
    return response;
};
