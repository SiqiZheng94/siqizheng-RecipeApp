import {Meal} from "../Meal.ts";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

type RecipeDetailsPageProps = {
    meals:Meal[]
}
export default function RecipeDetailsPage(props:RecipeDetailsPageProps){
    const pathId = useParams().id
    const [selectedMeal, setSelectedMeal] = useState<Meal>()
    const [error, setError] = useState<string>("")
    const mealData = props.meals.find(
        (meal:Meal) => meal._id === pathId
    )
    useEffect(() => {
        if (mealData){
            setSelectedMeal(mealData)
            setError("")
        }
        else {
            setError("NOT FOUND!")
        }
    }, []);
    return (
            <div>
                <p>{selectedMeal?.strMeal}</p>
                <img src={selectedMeal?.strMealThumb} alt="recipe image"/>
                {error}
            </div>
    )
}