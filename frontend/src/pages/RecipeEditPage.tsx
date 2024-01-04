import React, { useEffect, useState } from "react";
import {useNavigate, useParams} from "react-router-dom";
import axios from 'axios';
import { Meal } from "../Meal.ts";

type RecipeEditPageProps = {
    meals: Meal[];
    getData:()=>void
}

export default function RecipeEditPage(props: RecipeEditPageProps) {
    const { id: pathId } = useParams();
    const [selectedMeal, setSelectedMeal] = useState<Meal | null>(null);
    const [error, setError] = useState<string>("");
    const navigate = useNavigate()



    const handleEdit = (field: keyof Meal, event: React.FocusEvent<HTMLElement>) => {
        const editedContent = event.currentTarget.textContent;
        if (editedContent !== null && selectedMeal) {
            setSelectedMeal(prevMeal => {
                if (prevMeal === null) return null;
                return { ...prevMeal, [field]: editedContent };
            });
        }
    };

    const handleSubmit = async () => {
        if (selectedMeal) {
            try {
                await axios.put(`/api/meals/update`, selectedMeal)
                    .then(props.getData)
                console.log('Update successful');
                navigate("/recipe/"+selectedMeal._id)


            } catch (err) {
                setError("Failed to update the recipe.");
                console.error('Error updating the meal:', err);
            }
        }
    };

    useEffect(() => {
        const mealData = props.meals.find(meal => meal._id === pathId);
        if (mealData) {
            setSelectedMeal(mealData);
        } else {
            setError("Recipe not found.");
        }
    }, [pathId, props.meals]);

    if (!selectedMeal) return <div>Loading...</div>;

    return (
        <div className={"recipe-details"}>
            <h1 contentEditable={true} onBlur={(e) => handleEdit('strMeal', e)} dangerouslySetInnerHTML={{ __html: selectedMeal?.strMeal || "" }}></h1>
            <img src={selectedMeal?.strMealThumb} alt="recipe image" />
            <div contentEditable={true} onBlur={(e) => handleEdit('strMealThumb', e)} dangerouslySetInnerHTML={{ __html: selectedMeal?.strMealThumb || "" }}></div>
            <div contentEditable={true} onBlur={(e) => handleEdit('strInstructions', e)} dangerouslySetInnerHTML={{ __html: selectedMeal?.strInstructions || "" }}></div>

            <div className="ingredient-list">
                <div className="column">
                    <ul>
                        {/* Loop through ingredients and measures */}
                        {Array.from({ length: 20 }).map((_, index) => {
                            const ingredientField = `strIngredient${index + 1}` as keyof Meal;

                            return (
                                <React.Fragment key={index}>
                                    {selectedMeal && selectedMeal[ingredientField] && selectedMeal[ingredientField]?.trim() !== "" && (
                                        <li contentEditable={true} onBlur={(e) => handleEdit(ingredientField, e)} dangerouslySetInnerHTML={{ __html: selectedMeal[ingredientField] || "" }}></li>
                                    )}
                                </React.Fragment>
                            );
                        })}
                    </ul>
                </div>
                <div className="column">
                        <ul>
                            {/* Loop through ingredients and measures */}
                            {Array.from({ length: 20 }).map((_, index) => {
                                const measureField = `strMeasure${index + 1}` as keyof Meal;

                                return (
                                    <React.Fragment key={index}>
                                        {selectedMeal && selectedMeal[measureField] && selectedMeal[measureField]?.trim() !== "" && (
                                            <li contentEditable={true} onBlur={(e) => handleEdit(measureField, e)} dangerouslySetInnerHTML={{ __html: selectedMeal[measureField] || "" }}></li>
                                        )}
                                    </React.Fragment>
                                );
                            })}
                        </ul>
                </div>
            </div>


            {error && <p>{error}</p>}
            <button className="submit" onClick={handleSubmit}>Submit</button>
        </div>
    );
}