import { call, put, takeLatest } from 'redux-saga/effects';
import * as types from '../actions/userActionTypes';
import * as actions from '../actions/userActions';
import * as userService from '../../services/userService';

function* getUsersSaga() {
    try {
        const response = yield call(userService.getUsers);
        yield put(actions.getUsersSuccess(response.data));
    } catch (error) {
        yield put(actions.getUsersFailure(error.message));
    }
}

function* deleteUserSaga(action) {
    try {
        const response = yield call(userService.deleteUser, action.payload);
        yield put(actions.deleteUserSuccess(action.payload, response.status));
    } catch (error) {
        yield put(actions.deleteUserFailure(error.message));
    }
}

export function* userSaga() {
    yield takeLatest(types.GET_USERS_REQUEST, getUsersSaga);
    yield takeLatest(types.DELETE_USER_REQUEST, deleteUserSaga);
}
