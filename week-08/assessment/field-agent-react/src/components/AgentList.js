import { useEffect, useState } from "react";

import AgentTable from "./AgentTable";

function AgentList() {

    const [agents, setAgents] = useState([]);
    const [loading, setLoading] = useState(true); // Added loading state

    const fetchAgents = async () => {
        const response = await fetch("http://localhost:8080/api/agent");
        if (response.ok) {
            setAgents(await response.json());
        } else {
            setAgents([]);
        }
        setLoading(false); // Set loading to false when API call is complete
    };

    useEffect(() => {
        fetchAgents();
    }, []);

    return (
        <>
            {loading ? (
                <div>
                </div> 
            ) : agents.length === 0 ? (
                <div className="alert alert-warning py-4">
                    No agents found.<br />
                    Do you want to add an agent?
                </div>
            ) : (
                <AgentTable agents={agents} fetchAgents={fetchAgents}/>
            )}
        </>
    );
}

export default AgentList;