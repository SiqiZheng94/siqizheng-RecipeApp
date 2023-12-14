import {Meal} from "./Meal.ts";
import Navbar from "./components/Navbar.tsx";

type MealPageProps={
    meals:Meal[],
}
export default function MealPage(props:MealPageProps){

    return (
        <>
            <h1>Welcome to the Meal App</h1>
            <Navbar/>
            <div  className={"meal-container"}>
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