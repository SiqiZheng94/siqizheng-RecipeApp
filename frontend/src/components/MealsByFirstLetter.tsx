import React from 'react';
import {Link} from 'react-router-dom';

const MealsByFirstLetter: React.FC = () => {
    const letters = Array.from('ABCDEFGHIJKLMNOPQRSTVWXYZ');

    return (
        <div className={"browse-meals"}>
            <p>Browse Meals</p>
            <div className={"meal-letters"}>
                    {letters.map((letter) => (
                        <Link to={`/meals/letter/${letter}`} key={letter}>
                             {letter}/
                        </Link>
                    ))}
            </div>
        </div>
    );
};
export default MealsByFirstLetter;