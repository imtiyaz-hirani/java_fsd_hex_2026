import axios from "axios"
import { useEffect, useState } from "react"

function Todo() {
    const [todos, setTodos] = useState([])
    const [errMsg, setErrMsg] = useState()
    useEffect(()=>{
        const getAllTodos = async()=>{

           try{
             const response = await axios.get('https://jsonplaceholder.typicode.com/todos')
            console.log(response.data)
            setTodos(response.data)
           }
           catch(err){
                setErrMsg("error")
           }
        }

        getAllTodos()
    },[])
    return (
        <div>
            <h1>Todo</h1>
            <div className="container">
                {errMsg}
                {
                    todos.map((todo, index) => (
                        <div key={index} className="card">
                            UserId: {todo.userId} <br />
                            Title: {todo.title} <br />
                            Completed: {todo.completed?"TRUE":"FALSE"}
                        </div>
                    ))
                }

            </div>
        </div>
    )
}

export default Todo

/**
 React uses its own VirtualDom 
 Browser : DOM 

 React --> JSX => VirtualDom => DOM 
 */