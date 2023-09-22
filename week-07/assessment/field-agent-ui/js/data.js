const BASE_URL = 'http://localhost:8080/api/agent';
// CRUD

function fetchAgents() {
    fetch(`${BASE_URL}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            return Promise.reject();
        })
        .then(agents => populateAgents(agents))
        .catch(console.error);
}

async function findById(agentId) {
	const response = await fetch(`${BASE_URL}/${agentId}`);
	// TODO ... handle unhappy path (404, etc.)
	const data = await response.json();
	return data;
}

async function add(agent) {
    const config = {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agent),
	};
	const response = await fetch(BASE_URL, config);
	if (response.status === 201) {
		return null;
	} else if (response.status === 400) {
		const data = await response.json();
		return data;
	} else {
		// TODO: Handle other errors
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}`)
		);
	}
}

async function update(agent) {
	const config = {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agent),
	};
	const response = await fetch(`${BASE_URL}/${agent.agentId}`, config);
	if (response.status === 204) {
		return null;
	} else if (response.status === 400) {
		const data = await response.json();
		return data;
	} else {
		// 404 and other errors
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}`)
		);
	}
}

async function save(agent) {
	if (agent.agentId > 0) {
		return update(agent);
	} else {
		return add(agent);
	}
}

async function deleteById(agentId) {
	const config = {
		method: 'DELETE',
	};
	const response = await fetch(`${BASE_URL}/${agentId}`, config);
	// success
	if (response.status === 204) {
		return null;
	} else {
		// 404 and other errors
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}`)
		);
	}
}