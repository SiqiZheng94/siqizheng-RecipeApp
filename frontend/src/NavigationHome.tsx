import {Link} from "react-router-dom";

function NavigationHome() {
    return (
        <div>
            <Link to={"/home"}>Home</Link>
            <Link to={"/meals"}>MealsComponent</Link>
        </div>
    );
}

export default NavigationHome;