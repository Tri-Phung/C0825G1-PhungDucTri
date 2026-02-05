import axios from 'axios';

const API_URL = 'http://localhost:8080/books';

export const getAllBooks = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const getBookById = async (id) => {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
};

export const createBook = async (book) => {
    const allBooks = await getAllBooks();
    const maxId = allBooks.length > 0
        ? Math.max(...allBooks.map(b => b.id))
        : 0;
    const newId = maxId + 1;

    const response = await axios.post(API_URL, { ...book, id: newId });
    return response.data;
};

export const updateBook = async (id, book) => {
    const response = await axios.put(`${API_URL}/${id}`, book);
    return response.data;
};

export const deleteBook = async (id) => {
    const response = await axios.delete(`${API_URL}/${id}`);
    return response.data;
};
