import {useEffect, useState} from 'react'
import MealPage from "./pages/MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";

import "./styles/index.scss";

import Navbar from "./components/Navbar.tsx";
import WelcomePage from "./pages/WelcomePage.tsx";
import MealsByFirstLetter from "./components/MealsByFirstLetter.tsx";
import {Route, Routes} from "react-router-dom";
import Footer from "./components/Footer.tsx";
import CategoryMealPage from "./pages/CategoryMealPage.tsx";


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
                    <Routes>
                        <Route path="/" element={<WelcomePage/>}/>
                        <Route path="/meals" element={<MealPage meals={meals}/>}/>
                        <Route path="/category/Beef" element={<CategoryMealPage/>}/>
                    </Routes>
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
        </>
    )
}
export default App;
