import {useEffect, useState} from "react";
import {Meal} from "../Meal.ts";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";

export default function FirstLetterMealPage(){
    const navigate = useNavigate()
    const [selectedMeals, setSelectedMeals] = useState<Meal[]>([]);
    const pathLetter = useParams().letter
    const [isLoading, setIsLoading] = useState<boolean>(true)

        const fetchData = ()=>
            axios.get("/api/meals/letter/"+pathLetter)
                .then(response=> {
                    setSelectedMeals(response.data)
                    setIsLoading(false)
                })
                .catch(error=>
                console.log(error.message)
                )
        useEffect(() => {
            fetchData()
        }, [pathLetter]);


    return(
        <>
            {console.log("selectedMeals:", selectedMeals)}

            {
                isLoading ? <p>Loading...</p> : (
                    selectedMeals.length!=0 ?
                        <div className={"meal-container"}>
                            {selectedMeals.map((meal: Meal) => (
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
                        :
                        <div>oops, there are no recipes with the first letter {pathLetter}.</div>)
            }
        </>

    )
}