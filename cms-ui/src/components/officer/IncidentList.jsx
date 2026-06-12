import { useSelector } from "react-redux"

const IncidentList = ()=>{

    /*
        state ={
            incidents :[],
            others : [] 
        }
    */
    const {incidents} =  useSelector(state=> state.incidents)
    return(
        <div>
            <h1> Incidents managed by officer</h1>
            <div className="container card">
                {
                    incidents.map((i,index)=>(
                        <div key={index} className="card mt-4">
                            <p>{i.incidentType}</p>    
                            <p>{i.incidentStatus}</p> 
                            <p>{i.progressDetails}</p> 
                        </div>
                    ))
                }
            </div>
            
        </div>
    )
}

export default IncidentList