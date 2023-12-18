import React, {useState} from 'react';
import {Link} from 'react-router-dom';
import "../../src/styles/mealsByFirstLetterStyle.scss";
import {Meal} from "../Meal.ts";

const MealsByFirstLetter: React.FC = () => {
    const [selectedLetter, setSelectedLetter] = useState<string | null>(null);
    const [meals, setMeals] = useState<Meal[]>([]);
    const [selectedMeal, setSelectedMeal] = useState<Meal | null>(null);
    const handleLetterSelected = (letter: string) => {
        fetch(`/api/meals/letter/${letter}`)
            .then((response) => response.json())
            .then((data) => setMeals(data));
        setSelectedLetter(letter);
    };

    // const openMealInNewTab = (youtubeLink: string) => {
    //     window.open(youtubeLink, '_blank');
    //
    // };

    const handleMealClick = (selectedMeal: Meal) => {
        // Set the selected meal when a meal is clicked
        setSelectedMeal(selectedMeal);
    };

    const letters = Array.from('ABCDEFGHIJKLMNOPQRST');

    return (
        <div className={"container main"}>
            <div className="meal-browser">
                <div className={"meal-letters"}>
                    {letters.map((letter) => (
                        <Link to={`/meals/${letter}`} key={letter}>
                            <button onClick={() => handleLetterSelected(letter)}>{letter}</button>
                        </Link>
                    ))}
                </div>
                {selectedLetter && (
                    <div>
                        <h2>Meals with letter {selectedLetter}</h2>
                        <ul>
                            {meals.map((meal) => (
                                <li key={meal.idMeal} onClick={() => handleMealClick(meal)}>
                                    <a href={meal.strYoutube}>
                                        {meal.strMeal}
                                    </a>
                                </li>
                            ))}
                        </ul>
                    </div>
                )}
                {selectedMeal && (
                    <div className={"meal-browser"}>
                        <h2>Details for <strong>{selectedMeal.strMeal}</strong></h2>
                        <img src={selectedMeal.strMealThumb} alt={selectedMeal.strMeal}/>
                        <p className={"meal-browser"}><b>Instructions: </b> <br/>{selectedMeal.strInstructions}</p>
                        <p><b>Category:  </b>{selectedMeal.strCategory}</p>
                        <p><b>Tags: </b>  {selectedMeal.strTags}</p>
                        <p><b>Area: </b>  {selectedMeal.strArea}</p>
                    </div>
                )}
            </div>
        </div>
    );
};
export default MealsByFirstLetter;