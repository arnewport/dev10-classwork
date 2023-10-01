import { useEffect, useState } from "react";

import AgentTable from "./AgentTable";

function AgentList() {

    const [agents, setAgents] = useState([]);
    const [loading, setLoading] = useState(true); // Added loading state

    useEffect(() => {
        const fetchAgents = async () => {
            const response = await fetch("http://localhost:8080/api/agent");
            if (response.ok) {
                setAgents(await response.json());
            } else {
                setAgents([]);
            }
            setLoading(false); // Set loading to false when API call is complete
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
            {loading ? ( // Display a loading indicator while loading
                <div>
                </div>
            ) : agents.length === 0 ? (
                <div className="alert alert-warning py-4">
                    No agents found.<br />
                    Do you want to add an agent?
                </div>
            ) : (
                <AgentTable agents={agents} />
            )}
        </>
    );
}

export default AgentList;