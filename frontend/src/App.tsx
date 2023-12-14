import {useEffect, useState} from 'react'
import MealPage from "./MealPage.tsx";
import {Meal} from "./Meal.ts";
import axios from "axios";
import Navbar from "./components/Navbar.tsx";
import HeroSection from "./components/HeroSection.tsx";



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
      <div className={"App"}>
          <Navbar/>
          <div className={"container main"}>
              <HeroSection/>
          </div>
          <MealPage meals={meals}/>
      </div>
  )

}

export default App;
