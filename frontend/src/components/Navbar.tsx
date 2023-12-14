export default function Navbar (){
    return (
        <div className={"navbar container"}>
            <a href={"#!"} className={"logo"}>Best<span>Recipe</span>App</a>
            <div className={"nav-links"}>
                <a href={"#!"} className={"active"}>Home</a>
                <a href={"#!"}>Recipes</a>
            </div>
        </div>
    )
}