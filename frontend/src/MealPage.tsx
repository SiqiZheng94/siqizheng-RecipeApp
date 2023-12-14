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

                        <div key={meal.idMeal}>
                            {meal.strMealThumb && (
                                <img
                                    src={meal.strMealThumb}
                                    alt={meal.strMeal}
                                    style={{ maxWidth: "200px", maxHeight: "200px" }}
                                />
                            )}
                            <div>{meal.strMeal},{meal.strCategory}</div>
                        </div>

                    )
                )}
            </ul>

        </>
    )
}