import {Meal} from "../Meal.ts";
import axios from "axios";
import {useEffect, useState} from "react";


export default function CategoryMealPage() {
    const [categoryMeals, setCategoryMeals] = useState<Meal[]>([])
    const fetchData = ()=>{
        axios.get("/api/meals/category/beef")
            .then(response=>
                setCategoryMeals(response.data)
            )
            .catch(error =>
                console.log(error.message))
    }
    useEffect(() => {
        fetchData()
    }, []);

    return (
        <div className={"meal-container"}>
            {categoryMeals.map((meal: Meal) => (
                    <div className={"meal-card"} key={meal.idMeal}>
                        {meal.strMealThumb && (
                            <img className={"meal-picture"}
                                 src={meal.strMealThumb}
                                 alt={meal.strMeal}
                            />
                        )}
                        <p className={"meal-introduction"}>{meal.strMeal}</p>
                    </div>
                )
            )}
        </div>
    )
}