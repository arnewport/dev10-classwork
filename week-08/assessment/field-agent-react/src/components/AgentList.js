import { useEffect, useState } from "react";

import AgentTable from "./AgentTable";

function AgentList() {

    const [agents, setAgents] = useState([]);

    useEffect(() => {
        const fetchAgents = async () => {
            const response = await fetch("http://localhost:8080/api/agent");
            if (response.ok) {
                setAgents(await response.json());
            } else {
                setAgents([]);
            }
        };

        fetchAgents();
    }, []);

    useEffect(() => {
        // Define the event handler
        const handleReload = () => {
            // Implement your reload logic here
            window.location.reload();
        };
    
        // Add an event listener to the window
        window.addEventListener('reload-parent', handleReload);
    
        // Clean up the event listener when the component unmounts
        return () => {
            window.removeEventListener('reload-parent', handleReload);
        };
      }, []);

    return (
        <>
            {agents.length == 0 ?
                <div className="alert alert-warning py-4">
                    No agents found.<br />
                    Do you want to add an agent?
                </div>
                : <AgentTable agents={agents} />}
        </>
    );
}

export default AgentList;