const DISPLAY_NONE = "d-none";

const form = document.querySelector("form");
let currentView = "landing";

function changeView(view) {
    for (const element of document.querySelectorAll(`.${currentView}`)) {
        element.classList.add(DISPLAY_NONE);
    }
    for (const element of document.querySelectorAll(`.${view}`)) {
        element.classList.remove(DISPLAY_NONE);
    }
    currentView = view;
}

function resetForm() {
	// formErrorsList.innerHTML = '';
	// formErrorsEl.classList.add('d-none');
	form.reset();
}

// TODO: Populate an existing agent into the HTML form.
async function showUpdate(agentId) {
    resetForm();
	const agent = await findById(agentId);
	if (!agent) {
		return;
	}

	form.firstName.value = agent.firstName;
	form.middleName.value = agent.middleName;
	form.lastName.value = agent.lastName;
	form.dob.value = agent.dob;
	form.heightInInches.value = agent.heightInInches;
	form.agentId.value = agentId;
    changeView("form");
}

// TODO: Populate an existing agent into a delete confirmation view. 
// The confirmation view should allow for a delete or cancel.
// Cancel returns to the agent list view.
function confirmDelete(agentId) {
    alert(`Implement delete! Agent ID: ${agentId}`);
}

// TODO: create a function that deletes an agent when the
// delete confirmation view is confirmed. Confirmation can be a form submission
// or a button click.

function populateAgents(agents) {

    const table = document.querySelector(".list > table");
    const tbody = table.querySelector("tbody");
    const warning = document.querySelector(".list > div");

    if (agents.length === 0) {
        table.classList.add(DISPLAY_NONE);
        warning.classList.remove(DISPLAY_NONE);
        return;
    }

    let html = "";
    for (const agent of agents) {
        // TODO: This embedded HTML explicitly attaches a function call for update and delete.
        // Complete the confirmDelete and showUpdate functions.
        html += `<tr>
            <td>${agent.firstName}${agent.middleName ? " " + agent.middleName : ""} ${agent.lastName}</td>
            <td>${agent.dob}</td>
            <td>${agent.heightInInches}</td>
            <td>
                <button type="button" class="btn btn-danger me-2" onClick="confirmDelete(${agent.agentId})">Delete</button>
                <button type="button" class="btn btn-info edit" onClick="showUpdate(${agent.agentId})">Edit</button>
            </td>
        </tr>`;
    }

    tbody.innerHTML = html;
}

function showList() {
    fetchAgents();
    changeView("list");
}

function showValidationSummary(errors) {
    let html = '<ul class="mb-0">';
    for (const err of errors) {
        html += `<li>${err}</li>`;
    }
    html += '</ul>';
    const validationSummary = document.getElementById("validationSummary");
    validationSummary.classList.remove(DISPLAY_NONE);
    validationSummary.innerHTML = html;
}

function hideValidationSummary() {
    document.getElementById("validationSummary").classList.add(DISPLAY_NONE);
}

// TODO: Modify this function to allow for update.
// Don't create two different forms for create and update.
function submitForm(evt) {

    evt.preventDefault();
    evt.stopPropagation();
    hideValidationSummary();

    if (form.checkValidity()) {

        const agent = {
            firstName: form.firstName.value,
            middleName: form.middleName.value,
            lastName: form.lastName.value,
            dob: form.dob.value,
            heightInInches: form.heightInInches.value,
            agentId: parseInt(form.agentId.value, 10)
        };

        save(agent)
            .then(errors => {
                if (!errors) {
                    showList();
                } else if (errors.messages.length) {
                    showValidationSummary(errors);
                } else {
                    showValidationSummary("Something unexpected went wrong");
                }
            })
            .catch(console.error);
    }
}

// event handlers

document.getElementById("linkAgents")
    .addEventListener("click", evt => {
        evt.preventDefault();
        showList();
    });

document.getElementById("linkAgencies")
    .addEventListener("click", evt => {
        evt.preventDefault();
    });

document.querySelector(".list button")
    .addEventListener("click", () => {
        form.reset();
        changeView("form");
    });

form.addEventListener("submit", submitForm);

document.querySelector("form button[type=button]")
    .addEventListener("click", () => {
        showList();
    });