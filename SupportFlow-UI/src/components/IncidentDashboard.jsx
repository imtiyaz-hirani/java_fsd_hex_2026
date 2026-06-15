import { useEffect, useState } from "react"
import IncidentList from "./IncidentList"
import Stat from "./Stat"
import axios from "axios"

const IncidentDashbaord =()=>{ {/* Parent component */}
    const [incidentCount, setIncidentCount] = useState([])
    const [currentPage, setCurrentPage] = useState(0)
    const [size, setSize] = useState(1)

    const api = 'http://localhost:8080/api/incident/all/v2'

    useEffect(()=>{
        const getIncidentStat = async ()=>{
            const response = await axios.get(api + `?page=${currentPage}&size=${size}`)
            setIncidentCount(response.data.totalRecords)
        }

        getIncidentStat()
    },[])
    return(
        <div>
             {/* Child component */}
             <Stat count = {incidentCount} />
            {/* Child component */}
            <IncidentList />   
        </div>
    )
}

export default IncidentDashbaord

/**
 Strategy: 
 Lets call the API, and fetch all incidents   
 Then, we can pass this to Stat component, and if needed to other child components too
 so they don't have to call the API
 */