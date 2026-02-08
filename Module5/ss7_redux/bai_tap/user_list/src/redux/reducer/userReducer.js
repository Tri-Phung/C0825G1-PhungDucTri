import * as types from '../actions/userActionTypes';

const initialState = {
    users: [],
    loading: false,
    error: null,
    deleteStatus: null
};

const userReducer = (state = initialState, action) => {
    switch (action.type) {
        case types.GET_USERS_REQUEST:
            return {
                ...state,
                loading: true,
                error: null
            };

        case types.GET_USERS_SUCCESS:
            return {
                ...state,
                loading: false,
                users: action.payload,
                error: null
            };

        case types.GET_USERS_FAILURE:
            return {
                ...state,
                loading: false,
                error: action.payload
            };

        case types.DELETE_USER_REQUEST:
            return {
                ...state,
                loading: true,
                error: null,
                deleteStatus: null
            };

        case types.DELETE_USER_SUCCESS:
            return {
                ...state,
                loading: false,
                users: state.users.filter(user => user.id !== action.payload.userId),
                deleteStatus: action.payload.status,
                error: null
            };

        case types.DELETE_USER_FAILURE:
            return {
                ...state,
                loading: false,
                error: action.payload,
                deleteStatus: null
            };

        default:
            return state;
    }
};

export default userReducer;
