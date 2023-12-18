import "../styles/sidebar.scss";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link, useLocation} from "react-router-dom";


function Sidebar({links}) {
    const location = useLocation();
    return (
        <div className={"sidebar"}>
            {links.map(link => (
                    <Link key={link.name} to={link.path}
                          className={location.pathname == link.path ? "sidebar-link active" : "sidebar-link"}>
                        <FontAwesomeIcon icon={link.icon}/>

                        key={link.name}</Link>
                )
            )}

        </div>
    );
}

export default Sidebar;