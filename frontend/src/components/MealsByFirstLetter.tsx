import React, {useEffect, useState} from 'react';
import {Link, useNavigate} from 'react-router-dom';
import {Meal} from "../Meal.ts";

const MealsByFirstLetter: React.FC = () => {
    const navigate = useNavigate();

    const [selectedLetter, setSelectedLetter] = useState<string | null>(null);
    const [meals, setMeals] = useState<Meal[]>([]);
    const [selectedMeal, setSelectedMeal] = useState<Meal | null>(null);
    const handleLetterSelected = (letter: string) => {
        fetch(`/api/meals/letter/${letter}`)
            .then((response) => response.json())
            .then((data) => setMeals(data));
        setSelectedLetter(letter);
    };

    const openLettersPage = () => {
        navigate(`/meals/letter`)
        console.log("click")
    }
    // const openMealInNewTab = (youtubeLink: string) => {
    //     window.open(youtubeLink, '_blank');
    //
    // };
    useEffect(() => {
        if (selectedLetter) {
            fetch(`/api/meals/letter/${selectedMeal}`)
                .then((response) => response.json())
                .then((data) => setMeals(data));
        }
    }, []);

    const handleMealClick = (selectedMeal: Meal) => {
        // Set the selected meal when a meal is clicked
        setSelectedMeal(selectedMeal);
    };

    const letters = Array.from('ABCDEFGHIJKLMNOPQRSTVWXYZ');

    return (
        <div className={"container main"}>
            <button onClick={openLettersPage}>Navigate to Letters</button>
            <div className="meal-browser">
                <div className={"meal-letters"}>
                    {letters.map((letter) => (
                        <Link to={`/meals/letter/${letter}`} key={letter}>
                            <button onClick={() => handleLetterSelected(letter)}>{letter}</button>
                        </Link>
                    ))}
                </div>
                {selectedLetter && (
                    <div>
                        <h2>Meals with letter {selectedLetter}</h2>
                        <ul>
                            {meals.map((meal) => (
                                <Link to={`/recipe/${meal._id}`} key={meal.idMeal}>
                                    <li key={meal.idMeal} onClick={() => handleMealClick(meal)}>
                                        <a href={meal.strYoutube}>
                                            {meal.strMeal}
                                        </a>
                                    </li>
                                </Link>
                            ))}
                        </ul>
                    </div>
                )}
                {selectedMeal && (
                    <div className={"meal-browser"}>
                        <h2>Details for <strong>{selectedMeal.strMeal}</strong></h2>
                        <img src={selectedMeal.strMealThumb} alt={selectedMeal.strMeal}/>
                        <p className={"meal-browser"}><b>Instructions: </b> <br/>{selectedMeal.strInstructions}</p>
                        <p><b>Category: </b>{selectedMeal.strCategory}</p>
                        <p><b>Tags: </b> {selectedMeal.strTags}</p>
                        <p><b>Area: </b> {selectedMeal.strArea}</p>
                    </div>
                )}
            </div>
        </div>
    );
};
export default MealsByFirstLetter;