import {useEffect, useState} from 'react'
import AllMealPage from "./pages/AllMealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";

import "./styles/index.scss";

import Navbar from "./components/Navbar.tsx";
import HomePage from "./pages/HomePage.tsx";
import MealsByFirstLetter from "./components/MealsByFirstLetter.tsx";
import {Route, Routes} from "react-router-dom";
import Footer from "./components/Footer.tsx";
import CategoryMealPage from "./pages/CategoryMealPage.tsx";
import RecipeDetailsPage from "./pages/RecipeDetailsPage.tsx";

import FirstLetterMealPage from "./pages/FirstLetterMealPage.tsx";

import AddRecipe from "./pages/AddRecipe.tsx";
import RecipeEditPage from "./pages/RecipeEditPage.tsx";




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
                        <Route path="/" element={<HomePage/>}/>
                        <Route path="/meals" element={<AllMealPage meals={meals} getMeals={fetchData}/>}/>

                        <Route path="/add-recipe" element={<AddRecipe/>}/>

                        <Route path="/category/:category" element={
                            isLoading ? (<p>Loading...</p>) :
                                <CategoryMealPage meals={meals}/>}/>
                        <Route path="/recipe/:id" element={
                            isLoading ? (<p>Loading...</p>):
                            <RecipeDetailsPage meals={meals} getMeals={fetchData}/>}/>
                        <Route path="/recipe/edit/:id" element={
                            isLoading ? (<p>Loading...</p>):
                                <RecipeEditPage meals={meals} getData={fetchData}/>}/>
                        <Route path="/meals/letter/:letter" element={
                            <FirstLetterMealPage/>}/>
                    </Routes>
                </div>
            <MealsByFirstLetter/>
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
