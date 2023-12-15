import {useState} from "react";

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
                <a href={"#!"} className={"logo"}>Best<span>Recipe</span>App</a>
                <div className={"nav-links"}>
                    <div className={"nav-links"}>

                    </div>
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
        </>
    );
}