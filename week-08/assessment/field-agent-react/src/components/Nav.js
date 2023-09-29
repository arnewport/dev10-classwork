import { Link, NavLink } from "react-router-dom";

function Nav() {

    return (
        <div className="d-flex align-items-center">
            <ul className="nav my-4">
                <li className="nav-item">
                    <NavLink id="linkAgents" to="/agents" className="nav-link">Agents</NavLink>
                </li>
                <li className="nav-item">
                    <NavLink id="linkAgencies" to="/agencies" className="nav-link">Agencies</NavLink>
                </li>
            </ul>
            <div className="d-flex flex-grow-1 justify-content-end">
                <Link id="btnAdd" to="/agents/add" className="btn btn-primary">Add Agent</Link>
            </div>
        </div>
    );
}

export default Nav;