import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

// TODO: Modify this component to support update/edit.
// An update URL should have an agent id.
// Use that id to fetch a single agent and populate it in the form.

const INITIAL_AGENT = {
    firstName: "",
    middleName: "",
    lastName: "",
    dob: "",
    heightInInches: ""
}

function AgentForm() {

    const [agent, setAgent] = useState(INITIAL_AGENT);
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();
	const { id } = useParams();

    useEffect(() => {
		if (id) {
			fetch("http://localhost:8080/api/agent/" + id)
				.then(res => {
                   if (res.ok) {
                    return res.json();
                   }  else {
                    return Promise.reject(
                        new Error(`Unexpected status code ${res.status}`)
                    );
                   }
                })
				.then(setAgent).catch(
                    error => {
                        console.error(error);
                        navigate("/agents");
                    });
                }
            }, [id]);

    function handleChange(evt) {

        setAgent(previous => {
            const next = { ...previous };
            next[evt.target.name] = evt.target.value;
            return next;
        });

    }

    // TODO: Modify this function to support update as well as add/create.
    function handleSubmit(evt) {
        evt.preventDefault();
        if (id > 0) {
            // PUT
            const config = {
				method: "PUT",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(agent),
			};
			fetch("http://localhost:8080/api/agent/" + id, config)
				.then(res => {
					if (res.ok) {
						navigate("/agents");
					} else if (res.status === 400) {
						return res.json();
					}
				})
				.then(errs => {
                    if (errs) {
                        return Promise.reject(errs);
                    }
                })
                .catch(errs => {
                    if (errs.length) {
                        setErrors(errs);
                    } else {
                        setErrors([errs]);
                    }
                });

        } else {
            // POST
            const config = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(agent)
            }
    
            fetch("http://localhost:8080/api/agent", config)
                .then(response => {
                    if (response.ok) {
                        navigate("/agents");
                    } else {
                        return response.json();
                    }
                })
                .then(errs => {
                    if (errs) {
                        return Promise.reject(errs);
                    }
                })
                .catch(errs => {
                    if (errs.length) {
                        setErrors(errs);
                    } else {
                        setErrors([errs]);
                    }
                });
        } 
    }

    return (
        <>
            <h1 className="display-6">Add an Agent</h1>
            {errors && errors.length > 0 && <div className="alert alert-danger">
                <ul className="mb-0">
                    {errors.map(err => <li key={err}>{err}</li>)}
                </ul>
            </div>}
            <form onSubmit={handleSubmit}>
                <div className="row mb-3">
                    <div className="col">
                        <label className="form-label" htmlFor="firstName">First Name</label>
                        <input id="firstName" name="firstName" type="text" className="form-control" required
                            onChange={handleChange} value={agent.firstName} />
                    </div>
                    <div className="col">
                        <label className="form-label" htmlFor="middleName">Middle Name</label>
                        <input id="middleName" name="middleName" type="text" className="form-control"
                            onChange={handleChange} value={agent.middleName} />
                    </div>
                </div>
                <div className="mb-3">
                    <label className="form-label" htmlFor="lastName">Last Name</label>
                    <input id="lastName" name="lastName" type="text" className="form-control" required
                        onChange={handleChange} value={agent.lastName} />
                </div>
                <div className="row mb-3">
                    <div className="col">
                        <label className="form-label" htmlFor="dob">DOB</label>
                        <input id="dob" name="dob" type="date" className="form-control" required
                            onChange={handleChange} value={agent.dob} />
                    </div>
                    <div className="col">
                        <label className="form-label" htmlFor="heightInInches">Height (inches)</label>
                        <input id="heightInInches" name="heightInInches" type="number" className="form-control"
                            required min="36" max="96"
                            onChange={handleChange} value={agent.heightInInches} />
                    </div>
                </div>
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary me-2">Save</button>
                    <Link className="btn btn-warning" to="/agents">Cancel</Link>
                </div>
            </form>
        </>
    );
}

export default AgentForm;