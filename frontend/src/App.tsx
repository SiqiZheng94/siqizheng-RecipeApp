import {useEffect, useState} from 'react'
import MealPage from "./components/MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";

import "./styles/index.scss";

import Navbar from "./components/Navbar.tsx";
import HeroSection from "./components/HeroSection.tsx";
import MealsByFirstLetter from "./components/MealsByFirstLetter.tsx";
import {Route, Routes} from "react-router-dom";


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
        <div className={"App"}>
            <Navbar/>
            <div className={"container main"}>
                <HeroSection/>
            </div>
            <MealsByFirstLetter/>
        </div>
        <Routes>
            <Route path="/meals" element={<MealPage meals={meals}/>}/>
        </Routes>
        </>
    )
}
export default App;
