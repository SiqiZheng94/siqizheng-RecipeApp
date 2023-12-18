import {Meal} from "../Meal.ts";
import {useNavigate} from "react-router-dom";

type MealPageProps = {
    meals: Meal[],
}
export default function AllMealPage(props: MealPageProps) {
    const navigate = useNavigate()
    return (
        <div className={"meal-container"}>
            {props.meals.map((meal: Meal) => (
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
    )
}