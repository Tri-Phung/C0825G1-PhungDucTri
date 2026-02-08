import * as types from './userActionTypes';

export const getUsersRequest = () => ({
    type: types.GET_USERS_REQUEST
});

export const getUsersSuccess = (users) => ({
    type: types.GET_USERS_SUCCESS,
    payload: users
});

export const getUsersFailure = (error) => ({
    type: types.GET_USERS_FAILURE,
    payload: error
});

export const deleteUserRequest = (userId) => ({
    type: types.DELETE_USER_REQUEST,
    payload: userId
});

export const deleteUserSuccess = (userId, status) => ({
    type: types.DELETE_USER_SUCCESS,
    payload: { userId, status }
});

export const deleteUserFailure = (error) => ({
    type: types.DELETE_USER_FAILURE,
    payload: error
});
