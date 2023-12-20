import {Meal} from "../Meal.ts";
import {useNavigate} from "react-router-dom";
import {useState} from "react";
type MealContainerProps = {
    meals: Meal[],
}
export default function MealContainer(props:MealContainerProps){
    const navigate = useNavigate()
    const [meals, setMeals] = useState(props.meals);
    return (
        <div className={"meal-container"}>

            {meals.map((meal: Meal) => (
                    <div className={"meal-card"} key={meal.idMeal} onClick={()=>navigate("/recipe/"+meal._id)}>
                        {meal.strMealThumb && (
                            <img className={"meal-picture"}
                                 src={meal.strMealThumb}
                                 alt={meal.strMeal}
                            />
                        )}

                        <div className={"two-buttons"}>
                            <button><span>Edit</span></button>
                            <button><span>Delete</span></button>
                        </div>
                        <p className={"meal-introduction"}>{meal.strMeal}</p>
                    </div>
                )
            )}
        </div>
    )
}