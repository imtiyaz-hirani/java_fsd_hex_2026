import axios from "axios";
import { useState } from "react";

function Login(){
const [username, setUsername] = useState()
const [password, setPassword] = useState()
  const onLogin =async (e)=>{
      e.preventDefault();
       
      let body = {
    "incidentType" :username,
    "progressDetails" : password, 
    "incidentStatus" : "VERIFIED"
    
}
      // API 
      await axios.post("api path", body  ,"header");

  }
  return(
    <div>
       <h1>Login</h1>
       <div className="container">
          <div className="row">
              <div className="col-sm-3"></div>
              <div className="col-md-6">
                <form onSubmit={(e)=>onLogin(e)}>
                <div className="card">
                    <div className="mt-4">
                      <label>Username: </label>
                      <input type="text" required className="form-control" 
                      onChange={(e)=>setUsername(e.target.value)} />
                    </div>
                    <div className="mt-4">
                      <label>Password: </label>
                      <input type="password" required className="form-control" 
                      onChange={(e)=>setPassword(e.target.value)}/>
                    </div>
                    <div className="mt-4">
                       
                      <input type="submit" value="Login" className="btn btn-primary"/>
                    </div>
                </div>
                </form>
              </div>
              <div className="col-sm-3"></div>
          </div>
       </div>
    </div>
  )
}

export default Login; 