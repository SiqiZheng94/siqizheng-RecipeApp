import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

interface Meal {
    id: number;
    strMeal: string;
}

const AlphabetLinks: React.FC = () => {
    const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

    return (
        <div>
            {alphabet.split('').map((letter) => (
                <Link key={letter} to={`/meals/${letter}`}>
                    {letter}
                </Link>
            ))}
        </div>
    );
};

const MealsByFirstLetter: React.FC = () => {
    const [letter, setLetter] = useState<string>('');
    const [meals, setMeals] = useState<Meal[]>([]);

    const getMeals = async (): Promise<void> => {
        try {
            const response = await axios.get<Meal[]>(`/api/meals/${letter}`);
            setMeals(response.data);
        } catch (error) {
            console.error('Error fetching meals:', error);
        }
    };

    return (
        <div>
            <AlphabetLinks />
            <label>
                Enter a letter:
                <input
                    type="text"
                    value={letter}
                    onChange={(e) => setLetter(e.target.value)}
                />
            </label>
            <button onClick={getMeals}>Get Meals</button>

            <ul>
                {meals.map((meal) => (
                    <li key={meal.id}>{meal.strMeal}</li>
                ))}
            </ul>
        </div>
    );
};

export default MealsByFirstLetter;