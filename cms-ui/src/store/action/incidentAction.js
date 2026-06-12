// Action functions will be called from Component so make them exportable 

import axios from "axios"

// Prepare the header 
const config = {
    headers: {
        'Authorization': "Bearer " + localStorage.getItem('token')
    }
}

const getAllApi = 'http://localhost:8080/api/incident/all'
const addApi = ''

export const getAll = () => {
    // action Fn must return a Fn having action object wrapped in dispatch 
    return async (dispatch) => { // Thunk gives us dispatch 
        // Call the GET ALL API
       const response = await axios.get(getAllApi, config)
        // dispatch the action object 
        let action = {
            type: 'GET_ALL',
            payload: response.data
        }  
        dispatch(action)
    }
}

export const add = (incident) => {
    return (dispatch) => { // Thunk provides dispatch
        // Call the API
        
        // dispatch the action object 
        let action = {
            type: 'ADD',
            payload: incident
        }  
        dispatch(action)
    }
}