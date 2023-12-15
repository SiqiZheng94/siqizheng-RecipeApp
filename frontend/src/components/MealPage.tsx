import {Meal} from "../Meal.ts";

type MealPageProps = {
    meals: Meal[],
}
export default function MealPage(props: MealPageProps) {

    return (
        <div className={"meal-container"}>
            {props.meals.map((meal: Meal) => (
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