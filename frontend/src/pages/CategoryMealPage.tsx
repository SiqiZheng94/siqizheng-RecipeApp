import {Meal} from "../Meal.ts";
import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
type CategoryMealPageProps = {
    meals:Meal[]
}

export default function CategoryMealPage(props:CategoryMealPageProps) {
    const pathCategory = useParams().category
    const [error, setError] = useState<string>("")
    const [filteredMeals, setFilteredMeals] = useState<Meal[]>([])
    const navigate = useNavigate()


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
    }, []);

    return (
        <>
            <div><h1>{pathCategory}</h1></div>
                <div className={"meal-container"}>
                    {filteredMeals.map((meal: Meal) => (
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
                    {error}
                </div>
        </>
    )
}