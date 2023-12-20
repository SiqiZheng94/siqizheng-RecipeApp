import {Meal} from "../Meal.ts";
import {useNavigate} from "react-router-dom";
import SearchBar from '../components/SearchBar';
import { useState } from 'react';

type MealPageProps = {
    meals: Meal[],
}
export default function AllMealPage(props: MealPageProps) {
    const navigate = useNavigate()
    const [meals, setMeals] = useState(props.meals);

    return (
        <div><SearchBar setMeals={setMeals} />
        <div className={"meal-container"}>

            {meals.map((meal: Meal) => (
                    <div className={"meal-card"} key={meal.idMeal} onClick={()=>navigate("/recipe/"+meal._id)}>
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
        </div>
    )
}