import { Route, Router, Routes } from "react-router-dom";
import Login from "./components/Login";
import Todo from "./components/Todo";
import IncidentList from "./components/IncidentList";
 
function App(){

  return(
    <div>
        <Routes>
          <Route path="/" element={<Login />}/>
          <Route path="/todos" element={<Todo />}/>
          <Route path="/incidents" element={<IncidentList />}/>
        </Routes>
    </div>
  )
}

export default App; 

// API: handle data : states 
// read input thru form 

// Component : Read Input - login 
// App --> pages --> components 

// App --> components