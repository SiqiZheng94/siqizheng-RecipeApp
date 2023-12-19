import React, { useState } from 'react';
import axios from 'axios';

// Interface für die Formulardaten
interface FormValues {
    strMeal: string;
    strDrinkAlternate: string;
    strArea: string;
    strCategory: string;
    strInstructions: string;
}
const AddRecipes: React.FC = () => {
    // Zustand für die Formulardaten
    const [formData, setFormData] = useState<FormValues>({
        strMeal: '',
        strDrinkAlternate: '',
        strArea: '',
        strCategory: '',
        strInstructions: '',
    });

    // Handler für Formulareingaben
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    // Handler für das Absenden des Formulars
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            // Sende Daten an das Backend
            const response = await axios.post('/api/meals/add', formData);
            // Verarbeite die Antwort, falls erforderlich
            console.log(response.data);
        } catch (error) {
            console.error('Fehler beim Senden der Daten:', error);
        }
    };

    return (
        <div>
            <h2>Rezept hinzufügen</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Meal Name:
                    <input type="text" name="name" value={formData.strMeal} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Beschreibung:
                    <textarea name="description" value={formData.strArea} onChange={handleInputChange} />
                </label>
                <label>
                    Beschreibung:
                    <textarea name="description" value={formData.strCategory} onChange={handleInputChange} />
                </label>
                <label>
                    Beschreibung:
                    <textarea name="description" value={formData.strDrinkAlternate} onChange={handleInputChange} />
                </label>
                <label>
                    Beschreibung:
                    <textarea name="description" value={formData.strInstructions} onChange={handleInputChange} />
                </label>
                <br />
                {/* Füge hier weitere Formularelemente hinzu, falls erforderlich */}
                <button type="submit">Rezept hinzufügen</button>
            </form>
        </div>
    );
};

export default AddRecipes;