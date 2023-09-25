const DISPLAY_NONE = "d-none";

const form = document.querySelector("form");
const modal = new bootstrap.Modal(document.getElementById("deleteConfirmationModal"));
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

async function showUpdate(agentId) {
    form.reset();
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

async function confirmDelete(agentId) {

	const agentToDelete = await findById(agentId);

    modal.show();

    const button = document.getElementById("confirm-delete");
    const clone = button.cloneNode(true);
    button.parentNode.replaceChild(clone, button);

    function deleteOnClick() {
        return new Promise((resolve) => {
            document.getElementById("confirm-delete").addEventListener("click", () => {
                resolve();
            });
        });
    }
    
	deleteOnClick().then(() => {
		deleteById(agentId)
			.then(res => {
				// success
				if (!res) {
					fetchAgents();
				}
			})
			.catch(console.error);

            modal.hide();
	})

}

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
        html += `<tr>
            <td>${agent.firstName}${agent.middleName ? " " + agent.middleName : ""} ${agent.lastName}</td>
            <td>${dateFormatter(agent.dob)}</td>
            <td>${heightFormatter(agent.heightInInches)}</td>
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

// formatters

function dateFormatter(date) {
    if (date === null || date === undefined) {
        return "Unknown";
    }

    const dateParts = date.split('-');

    const year = dateParts[0];
    const month = dateParts[1];
    const day = dateParts[2];

    return `${month}/${day}/${year}`;
}

function heightFormatter(inches) {
    if (inches === null || inches === undefined || isNaN(inches)) {
        return "Unknown";
    }

    const feet = Math.floor(inches / 12);
    const remainingInches = inches % 12;

    if (feet === 0) {
        return `${remainingInches}"`;
    }

    if (remainingInches === 0) {
        return `${feet}' 0"`;
    }

    return `${feet}' ${remainingInches}"`;
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