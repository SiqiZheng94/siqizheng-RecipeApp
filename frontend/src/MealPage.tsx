import {Meal} from "./Meal.ts";

type MealPageProps={
    meals:Meal[],
}
export default function MealPage(props:MealPageProps){

    return (
        <>
            <h1>Welcome to the Meal App</h1>
            <div  className={"container"}>
                {props.meals.map((meal:Meal) => (


                            <div className={"meal-card"}>
                                {meal.strMealThumb && (
                                    <img className={"meal-picture"}
                                        src={meal.strMealThumb}
                                        alt={meal.strMeal}
                                    />
                                )}
                                <p className={"meal-introduction"} s>{meal.strMeal}</p>
                            </div>


                    )
                )}
            </div>

        </>
    )
}