import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function IncidentList() {

    const [incidents, setIncidents] = useState([])
    const [currentPage, setCurrentPage] = useState(0)
    const [size, setSize] = useState(7)
    const [totalPages, setTotalPages] = useState(0)
    const [arry, setArry] = useState([])
    const [deleteMsg, setDeleteMessage] = useState()

    let count = 0

    const api = 'http://localhost:8080/api/incident/all/v2'
    const deleteApi = 'http://localhost:8080/api/incident/soft-delete/'

    useEffect(() => {

        const getAllIncidents = async () => {
            const response = await axios.get(api + `?page=${currentPage}&size=${size}`)
            setIncidents(response.data.data)
            console.log(response.data.data)
            setTotalPages(response.data.totalPages)
            console.log(response.data.totalPages)
            setArry(Array.from({ length: totalPages }))
            console.log(arry.length)
        }
        getAllIncidents()

    }, [currentPage]) // Dep array 

    const onDelete = async (id) => {
        try {
            // call api to delete 
            await axios.delete(deleteApi + id)                              
            // update the incidents array
            let tempArry = [...incidents].filter(i => i.id !== id)
            setIncidents([...tempArry])
            setDeleteMessage("Incident deleted from the system.")
        }
        catch (err) { }
    }
    return (
        <div>
            <h1>All Incidents with pagination</h1>

            {
                deleteMsg !== undefined ?
                    <div className="toast align-items-center" role="alert" aria-live="assertive" aria-atomic="true">
                        <div className="d-flex">
                            <div className="toast-body">
                                 {deleteMsg}
                            </div>
                            <button type="button" className="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                    </div> : ""
            }
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Incident Type</th>
                        <th scope="col">Incident Status</th>
                        <th scope="col">Officer Name</th>
                        <th scope="col">Reported At</th>
                        <th scope="col">Station Name</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        incidents.map((i, index) => (
                            <tr key={index}>
                                <th scope="row">{i.id}</th>
                                <td>{i.incidentType}</td>
                                <td>{i.incidentStatus}</td>
                                <td>{i.officer?.name}</td>
                                <td>{i.createdAt.toString().split("T")[0]}</td>
                                <td>{i.officer?.station?.stationTitle}</td>
                                <td> <button className="btn btn-link p-0 text-decoration-none"
                                    onClick={() => onDelete(i.id)}>
                                    <i class="bi bi-trash"></i>
                                </button>
                                    &nbsp;&nbsp;&nbsp;
                                    <button className="btn btn-link p-0 text-decoration-none">
                                        <i class="bi bi-pencil"
                                            onClick={() => onEdit(i.id)}></i>
                                    </button>
                                </td>
                            </tr>
                        ))
                    }


                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul className="pagination justify-content-center">

                    <li className="page-item">
                        <button className="page-link" disabled={currentPage === 0}
                            onClick={() => setCurrentPage(currentPage - 1)}>Previous</button>
                    </li>
                    {
                        arry.map((_, index) => (
                            <li className="page-item" key={index} >
                                <button className="page-link" onClick={() => setCurrentPage(index)}> {count = count + 1}
                                </button>
                            </li>
                        ))
                    }


                    <li className="page-item">
                        <button className="page-link" disabled={currentPage === (totalPages - 1)}
                            onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default IncidentList; 