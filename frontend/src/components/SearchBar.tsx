import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Meal } from '../Meal';
import '../styles/searchBar.scss';

type SearchBarProps = {
    setMeals: React.Dispatch<React.SetStateAction<Meal[]>>;
};

export default function SearchBar({ setMeals }: SearchBarProps) {
    const [input, setInput] = useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        fetchMeals();
    };

    const fetchMeals = () => {
        const endpoint = input ? `/api/meals/name/${input}` : '/api/meals';
        axios.get(endpoint)
            .then(response => {
                setMeals(response.data);
            })
            .catch(error => console.log(error.message));
    };

    const clearInput = () => {
        setInput('');
    };

    useEffect(() => {
        fetchMeals();
    }, [input]);

    return (
        <form className="search-bar" onSubmit={handleSubmit}>
            <input type="text" value={input} onChange={(e) => setInput(e.target.value)} />
            {input && <button type="button" onClick={clearInput}>Clear</button>}
        </form>
    );
}