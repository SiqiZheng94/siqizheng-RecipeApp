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
            {
                isLoading ? (
                    <div className="loading-animation">Loading...</div>
                ) : (
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
                                        <p className={"meal-introduction"}>{meal.strMeal}</p>
                                    </div>
                                )
                            )}
                        </div>
                        :
                        <div className={"oops"}>
                            <img src="https://cdn.pixabay.com/photo/2016/06/03/08/18/oops-1432954_960_720.png"/>
                            <p>
                                There are no recipes with the first letter {pathLetter}.
                            </p></div>)
            }
        </>

    )
}