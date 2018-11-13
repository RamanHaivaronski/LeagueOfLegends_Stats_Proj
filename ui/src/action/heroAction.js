import axios from "axios";
import {
    LOAD_START_HERO_FULL,
    LOAD_END_HERO_FULL, LOAD_ERROR_HERO_FULL
} from "../constants/ActionTypes";

export const getAllHeroesData = () => {
    return dispatch => {
        dispatch(loadStartHeroFull());
        axios.get("/api/v1/public/heroFull/")
            .then(
            result => {
                dispatch(loadEndHeroFull(result.data));
            },
            error => {
                dispatch(loadErrorHeroFull());
            }
        )
    }
};

const loadStartHeroFull = ()=>{
    return {
        type: LOAD_START_HERO_FULL
    }
};

const loadEndHeroFull = (payload)=>{
    return {
        type: LOAD_END_HERO_FULL,
        payload
    }
};

const loadErrorHeroFull = ()=>{
    return {
        type: LOAD_ERROR_HERO_FULL
    }
};