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
import RecipeDetailsPage from "./pages/RecipeDetailsPage.tsx";


function App() {
    const [meals, setMeals] = useState<Meal[]>([])
    const [isLoading, setIsLoading] = useState<boolean>(true)
    const fetchData = () =>
        axios.get("/api/meals")
            .then(response => {
                setMeals(response.data)
                console.log(meals)
                setIsLoading(false)
            })
            .catch(error =>
                console.log(error.message))
    useEffect(() => {
            fetchData()
        }, []
    )
    return (
        <div className={"App"}>
            <header>
                <Navbar/>
            </header>
            <main>
                <div className={"container main"}>
                    <Routes>
                        <Route path="/" element={<WelcomePage/>}/>
                        <Route path="/meals" element={<MealPage meals={meals}/>}/>
                        <Route path="/category/:category" element={
                            isLoading ? (<p>Loading...</p>):
                            <CategoryMealPage meals={meals}/>}/>
                        <Route path="/recipe/:id" element={
                            isLoading ? (<p>Loading...</p>):
                            <RecipeDetailsPage meals={meals}/>}/>
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
    )
}
export default App;
