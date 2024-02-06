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
        <html>
        <body>
        <div className="wrapper">
            <header>
                <Navbar/>
            </header>
            <div className={"App"}>
                <main>
                    <div className={"container main"}>
                        <Routes>
                            <Route path="/" element={<HomePage/>}/>
                            <Route path="/meals" element={
                                isLoading ? (
                                        <div className="loading-animation">Loading...</div>
                                    ) :
                                <AllMealPage meals={meals} getMeals={fetchData}/>}/>
                            <Route path="/add-recipe" element={<AddRecipe/>}/>
                            <Route path="/category/:category" element={
                                isLoading ? (
                                        <div className="loading-animation">Loading...</div>
                                    ) :
                                    <CategoryMealPage meals={meals}/>}/>
                            <Route path="/recipe/:id" element={
                                isLoading ? (
                                        <div className="loading-animation">Loading...</div>
                                    ) :
                                    <RecipeDetailsPage meals={meals} getMeals={fetchData}/>}/>
                            <Route path="/recipe/edit/:id" element={
                                isLoading ? (
                                        <div className="loading-animation">Loading...</div>
                                    ) :
                                    <RecipeEditPage meals={meals} getData={fetchData}/>}/>
                            <Route path="/meals/letter/:letter" element={
                                <FirstLetterMealPage/>}/>
                        </Routes>
                    </div>
                    <MealsByFirstLetter/>
                </main>
            </div>
            <div className="push"></div>
        </div>
        <footer className={"ff"}>
                <Footer/>
        </footer>
        </body>
        </html>
    )
}

export default App;
