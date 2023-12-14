import {useEffect, useState} from 'react'
import MealPage from "./MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";
import NavBar from "./NavBar.tsx";
import "../../../style/src/index.scss";


function App() {
    const [meals, setMeals] = useState<Meal[]>([])
    const fetchData = () =>
        axios.get("/api/meals")
            .then(response => {
                setMeals(response.data)
                console.log(meals)
            })
            .catch(error =>
                console.log(error.message))
    useEffect(() => {
            fetchData()
        }, []
    )
    return (
        <>
            <NavBar/>
            <MealPage meals={meals}/>

        </>
    )
}

export default App;
