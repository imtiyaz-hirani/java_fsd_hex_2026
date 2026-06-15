import { useState } from "react"

const Stat =({count})=>{

return(
        <div>
            <h1>Stats</h1>
            <h3>Incidents: {count}</h3>
        </div>
    )
}

export default Stat