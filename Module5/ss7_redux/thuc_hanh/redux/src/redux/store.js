import {applyMiddleware, createStore} from "redux";
import rootReducer from "./reducer.js";
import rootSaga from "../saga/userSaga.js";
import createSagaMiddleware from "redux-saga";

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
    rootReducer,
    applyMiddleware(sagaMiddleware)
);

sagaMiddleware.run(rootSaga);

export default store;