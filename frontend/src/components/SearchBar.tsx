import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { Meal } from '../Meal';
import '../styles/searchBar.scss';

type SearchBarProps = {
    setMeals: React.Dispatch<React.SetStateAction<Meal[]>>;
};

export default function SearchBar({ setMeals }: SearchBarProps) {
    const [input, setInput] = useState('');

    const fetchMeals = useCallback(() => {
        const endpoint = input ? `/api/meals/name/${input}` : '/api/meals';
        axios.get(endpoint)
            .then(response => {
                setMeals(response.data);
            })
            .catch(error => console.log(error.message));
    }, [input, setMeals]);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        fetchMeals();
    };

    useEffect(() => {
        fetchMeals();
    }, [fetchMeals]);

    const clearInput = () => {
        setInput('');
    };

    return (
        <form className="search-bar" onSubmit={handleSubmit}>
            <input type="text" className="search-bar-input" value={input} onChange={(e) => setInput(e.target.value)} placeholder="Find your favorite meal 🔎" />
            {input && <button className="search-bar-button" type="button" onClick={clearInput}>Clear</button>}
        </form>
    );
}