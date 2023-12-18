import {useEffect, useState} from 'react'
import MealPage from "./components/MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";

import "./styles/index.scss";
import Navbar from "./components/Navbar.tsx";
import HeroSection from "./components/HeroSection.tsx";
import Footer from "./components/Footer.tsx";
import MealsByFirstLetter from "./components/MealsByFirstLetter.tsx";
import Home from "./components/Home.tsx";
import Recipes from "./components/Recipes.tsx";
import Settings from "./components/Settings.tsx";
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
                <header>
                    <Navbar/>
                </header>
                <main>
                    <div className={"container main"}>
                        <HeroSection/>
                    </div>
                    <div className={"container-meals-by-first-litter"}>
                        <MealsByFirstLetter/>
                    </div>
                </main>
                <footer>
                    <div className={"container"}>
                        <Footer/>
                    </div>
                </footer>
            </div>
            <Routes>
                <Route path="/meals" element={<MealPage meals={meals}/>}/>
                <Route path="/home" element={<Home/>}/>
                <Route path="/recipe" element={<Recipes/>}/>
                <Route path="/settings" element={<Settings/>}/>
            </Routes>

        </>
    )
}

export default App;
