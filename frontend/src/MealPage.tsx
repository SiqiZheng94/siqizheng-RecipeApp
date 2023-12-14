import {Meal} from "./Meal.ts";

type MealPageProps={
    meals:Meal[],
}
export default function MealPage(props:MealPageProps){

    return (
        <>
            <h1>Welcome to the Meal App</h1>
            <ul>
                {props.meals.map((meal:Meal) => (
                    <li key={meal.idMeal}>{meal.strMeal},{meal.strCategory}
                        {meal.strMealThumb && (
                            <img
                                src={meal.strMealThumb}
                                alt={meal.strMeal}
                                style={{ maxWidth: "100px", maxHeight: "100px" }}
                            />
                        )}</li>
                    )
                )}
            </ul>

        </>
    )
}