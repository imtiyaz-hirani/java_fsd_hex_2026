// Define Initial State 
const initialState ={
    incidents: []
}
// Inject state and action in reducer and initialize state with
// initial value
export const incidentReducer =(state = initialState,action)=>{
        if(action.type === 'GET_ALL'){
            return {
                 ...state, 
                 incidents: action.payload   
            }
        }
        if(action.type === "ADD" ){
            return{
                ...state,
                incidents: [...state.incidents, action.payload]
            }
        }
        return state
}

/**
 action is expected to have following structure
 action = {
    type: ''
    payload: ''
 }

 return {
        ...state, //making a clone to replace earlier immutable state to new state 
        incidents: action.payload   // attach data(payload) to incidents in store 
            }

ex. Adding a value to array 
state.person = [p1,p2,p3]
add p4 to this array
person =  [...state.person, p4]  : a new array with [p1,p2,p3,p4]
 */