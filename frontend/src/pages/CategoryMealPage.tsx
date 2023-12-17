import {Meal} from "../Meal.ts";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
type CategoryMealPageProps = {
    meals:Meal[]
}

export default function CategoryMealPage(props:CategoryMealPageProps) {
    const pathCategory = useParams().category
    const [error, setError] = useState<string>("")
    const [filteredMeals, setFilteredMeals] = useState<Meal[]>([])


    const mealsData= props.meals.filter(
        (meal:Meal) => meal.strCategory === pathCategory
    )
    useEffect(() => {
        if (mealsData) {
            setFilteredMeals(mealsData)
            setError("")
        } else {
            setError("NOT FOUND!")
        }
        // console.log("test:"+props.meals)
    }, []);

    return (
        <>
            <div><h1>{pathCategory}</h1></div>
                <div className={"meal-container"}>
                    {filteredMeals.map((meal: Meal) => (
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
                    {error}
                </div>
        </>
    )
}