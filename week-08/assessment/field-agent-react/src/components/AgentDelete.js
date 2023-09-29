import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

function AgentDelete() {
	const [agent, setSolarPanel] = useState(null);
	const [success, setSuccess] = useState(false);
	const { id } = useParams();
	const navigate = useNavigate();

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
				.then(setSolarPanel)
				.catch(error => {
					console.error(error);
					navigate("/agents");
				});
		}
	}, []);

	function handleDelete() {
		const config = {
			method: "DELETE",
		};
		fetch("http://localhost:8080/api/agent/" + id, config)
			.then(res => {
				if (res.ok) {
					// success
					setSuccess(true);
					setTimeout(() => {
						navigate("/agents");
					}, 2000);
				} else {
					// unhappy path
					return Promise.reject(
						new Error(`Unexpected status code ${res.status}`)
					);
				}
			})
			.catch(error => {
				console.error(error);
				navigate("/agents");
			});
	}

	if (!agent) {
		return (
			<div
				style={{ minHeight: "80vh" }}
				className="d-flex justify-content-center align-items-center">
				<div className="spinner-border " role="status">
					<span className="visually-hidden">Loading...</span>
				</div>
			</div>
		);
	}

	return (
		<div>
			<h1>Delete</h1>
			<div className="alert alert-warning" role="alert">
				<p>
					Are you sure you want to delete the agent?
				</p>
				<button onClick={handleDelete} classes="btn-danger me-2">
					Delete
				</button>
				<Link className="btn btn-secondary" to="/agents">
					Cancel
				</Link>
			</div>
			{success && (
				<div className="alert alert-success" role="alert">
					<p>
						Successfully deleted agent! Navigating back to
						agent list ...{" "}
					</p>
				</div>
			)}
		</div>
	);
}

export default AgentDelete;