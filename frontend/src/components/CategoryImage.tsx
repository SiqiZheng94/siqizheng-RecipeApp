import {Category} from "../Category.ts";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {useEffect, useState} from "react";


export default function CategoryImage(){
    const navigate = useNavigate()
    const [categories, setCategories] = useState<Category[]>([])
    const fetchCategoryData = ()=>{
        axios.get("/api/meals/categorylist")
            .then(response=>{
                setCategories(response.data)
            })
            .catch(error=>
            console.log(error.message))
    }
    useEffect(() => {
        fetchCategoryData()
    }, []);


    return (
        <>
        {
            categories.map((category,index)=>
                <div className="custom-image" style={{paddingTop: "90%"}} key={index}>
                    <img
                        onClick={()=>navigate("/category/"+category.strCategory)}
                        src={category.strCategoryThumb}
                        alt=""
                    />
                </div>
            )
        }
        </>
    )
}