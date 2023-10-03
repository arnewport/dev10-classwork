import { useEffect, useState } from 'react';
import { Link } from "react-router-dom";
import { Button, Modal } from 'react-bootstrap';

function AgentTable({ agents, fetchAgents }) {

    const [showModal, setShowModal] = useState(false);
    const [id, setId] = useState(null);

    const handleDeleteClick = (agentId) => {
        setId(agentId);
        setShowModal(true);
    };
    
    const handleCloseModal = () => {
        setShowModal(false);
    };

    useEffect(() => {
		if (id) {
			fetch("http://localhost:8080/api/agent/" + id)
				.then(res => {
					if (res.ok) {
						return res.json();
					} else {
						return Promise.reject(
							new Error(`Unexpected status code: ${res.status}`)
						);
					}
				})
				.catch(error => {
					console.error(error);
				});
		}
	}, [id]);
    
    const handleDelete = () => {
        if (id !== null) {
            const config = {
                method: "DELETE",
            };
            fetch("http://localhost:8080/api/agent/" + id, config)
                .then(res => {
                    if (res.ok) {
                        // success
                        fetchAgents();
                    } else {
                        // unhappy path
                        return Promise.reject(
                            new Error(`Unexpected status code ${res.status}`)
                        );
                    }
                }).then(setId)
                .catch(error => {
                    console.error(error);
                });  
        }
        handleCloseModal();
        return;
    }

    return (
        <div>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Height</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    {agents.map(agent => (
                        <tr key={agent.agentId}>
                            <td>{agent.firstName}{agent.middleName ? " " + agent.middleName : ""} {agent.lastName}</td>
                            <td>{agent.dob}</td>
                            <td>{agent.heightInInches}</td>
                            {/* TODO: Replace buttons with React Router Links (and style appropriately).
                            The delete link should navigate to a confirm delete component.
                            The edit link should navigate to the AgentForm and pre-populate the agent. */}
                            <td>
                                <button className="btn btn-danger me-2" onClick={() => handleDeleteClick(agent.agentId)}>Delete</button>
                                <Link 
                                to={`/agents/edit/${agent.agentId}`}
                                className="btn btn-primary">
                                    Edit
                                </Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table >
            {/* Modal for confirming delete */}
            <Modal show={showModal} onHide={handleCloseModal}>
                <Modal.Header closeButton>
                <Modal.Title>Confirm Delete</Modal.Title>
                </Modal.Header>
                <Modal.Body>Are you sure you want to delete this agent?</Modal.Body>
                <Modal.Footer>
                <Button className="btn btn-danger me-2" variant="primary" onClick={handleDelete}>
                    Delete
                </Button>
                <Button className="btn btn-warning" variant="secondary" onClick={handleCloseModal}>
                    Cancel
                </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default AgentTable;