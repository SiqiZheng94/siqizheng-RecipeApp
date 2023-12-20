import React, {useState} from 'react';
import axios from 'axios';
import '../styles/addRecipe.scss';

interface FormValues {
    strMeal: string;
    strCategory?: string;
    strMealThumb: string;
    strInstructions: string;
    strIngredient1: string;
    strMeasure1: string,
    strIngredient2: string,
    strMeasure2: string,
    strIngredient3: string,
    strMeasure3: string,
}

const AddRecipes: React.FC = () => {
    const [formData, setFormData] = useState<FormValues>({
        strMeal: '',
        strCategory: '',
        strMealThumb: '',
        strInstructions: '',
        strIngredient1: '',
        strMeasure1: '',
        strIngredient2: '',
        strMeasure2: '',
        strIngredient3: '',
        strMeasure3: '',
    });

    // Handler für Formulareingaben
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const {name, value} = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
        console.log(formData);
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            // Sende Daten an das Backend
            const response = await axios.post("/api/meals/add", formData);
            setFormData({
                strMeal: '',
                strCategory: '',
                strMealThumb: '',
                strInstructions: '',
                strIngredient1: '',
                strMeasure1: '',
                strIngredient2: '',
                strMeasure2: '',
                strIngredient3: '',
                strMeasure3: '',
            })
            console.log(response.data);
        } catch (error) {
            console.error('Fehler beim Senden der Daten:', error);
        }
    };

    return (
        <div className={"add-recipe"}>
            <form>
                <h2>Add your own recipe</h2>
                <br/>
                <label htmlFor="strMeal">Meal Name:</label>
                <input
                    type="text"
                    id="strMeal"
                    name="strMeal"
                    value={formData.strMeal}
                    onChange={handleInputChange}
                    required
                    placeholder={"Meal Name required..."}
                />
                <label htmlFor="strCategory">Category:</label>
                <input
                    type="text"
                    id="strCategory"
                    name="strCategory"
                    value={formData.strCategory}
                    onChange={handleInputChange}
                    required
                    placeholder={"Category required..."}
                />
                <label htmlFor="strInstructions">Recipe:</label>
                <textarea
                    id="strInstructions"
                    name="strInstructions"
                    value={formData.strInstructions}
                    onChange={handleInputChange}
                    required
                    placeholder={"Recipe required..."}
                />
                <label htmlFor="strIngredient1">Ingredient 1:</label>
                <input
                    type="text"
                    id="strIngredient1"
                    name="strIngredient1"
                    value={formData.strIngredient1}
                    onChange={handleInputChange}
                    required
                    placeholder={"Ingredient1 required..."}
                />
                <label htmlFor="strMeasure1">Measure 1:</label>
                <input
                    type="text"
                    id="strMeasure1"
                    name="strMeasure1"
                    value={formData.strMeasure1}
                    onChange={handleInputChange}
                    required
                    placeholder={"Measure1 required..."}
                />
                <label htmlFor="strIngredient2">Ingredient 2:</label>
                <input
                    type="text"
                    id="strIngredient2"
                    name="strIngredient2"
                    value={formData.strIngredient2}
                    onChange={handleInputChange}
                    required
                    placeholder={"Ingredient2 required..."}
                />
                <label htmlFor="strMeasure2">Measure 2:</label>
                <input
                    type="text"
                    id="strMeasure2"
                    name="strMeasure2"
                    value={formData.strMeasure2}
                    onChange={handleInputChange}
                    required
                    placeholder={"Measure2 required..."}
                />
                <label htmlFor="strIngredient3">Ingredient 3:</label>
                <input
                    type="text"
                    id="strIngredient3"
                    name="strIngredient3"
                    value={formData.strIngredient3}
                    onChange={handleInputChange}
                    placeholder={"Ingredient3 optional..."}
                />
                <label htmlFor="strMeasure3">Measure 3:</label>
                <input
                    type="text"
                    id="strMeasure3"
                    name="strMeasure3"
                    value={formData.strMeasure3}
                    onChange={handleInputChange}
                    placeholder={"Measure3 optional..."}
                />
                <label htmlFor="strMealThumb">Meal link Image:</label>
                <input
                    type="text"
                    id="strMealThumb"
                    name="strMealThumb"
                    // accept="image/*"
                    value={formData.strMealThumb}
                    onChange={handleInputChange}
                    placeholder={"Meal link Image optional..."}
                />
                <br/>
                <button type="button" onClick={handleSubmit}>
                    Submit
                </button>
            </form>
        </div>
    );
};

export default AddRecipes;