import {useEffect, useState} from 'react'
import './App.css'
import MealPage from "./MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";



function App() {
const [meals,setMeals]=useState<Meal[]>([])
const fetchData=() =>
    axios.get("/api/meals")
        .then(response => {
            setMeals(response.data)
            console.log(meals)
        })
        .catch(error =>
            console.log(error.message))
    useEffect(() => {
        fetchData()
        },[]
    )
  return (
    <>
      <MealPage meals={meals}/>
    </>
  )
}

export default App
