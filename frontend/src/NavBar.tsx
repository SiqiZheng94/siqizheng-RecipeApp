import {useState} from "react";
import Sidebar from "./Sidebar.tsx";

export default function NavBar() {

    const [showSidebar, setShowSidebar] = useState(false);
    const links= [
        {
            name: "Home",
            path: "/"
        },
        {
            name: "Recipes",
            path: "/recipes"
        },
        {
            name: "Settings",
            path: "/settings"
        }
    ]

    return (
        <>
            <div className="navbar container">
                <a href={"#!"} className={"logo"}>L<span>o</span>go</a>
                <div className={"nav-links"}>
                    {
                        links.map(link => (
                            <a href="#!" key={link.name}>{link.name}</a>
                        ))
                    }
                    {/*<a href={"#!"}>Home</a>*/}
                    {/*<a href={"#!"}>Recipes</a>*/}
                    {/*<a href={"#!"}>Settings</a>*/}
                </div>
                <div onClick={() => setShowSidebar(!showSidebar)}
                     className={showSidebar ? "sidebar-btn active" : "sidebar-btn"}>
                    <div className={"bar"}></div>
                    <div className={"bar"}></div>
                    <div className={"bar"}></div>
                </div>
            </div>
            <Sidebar />
        </>
    );
}
