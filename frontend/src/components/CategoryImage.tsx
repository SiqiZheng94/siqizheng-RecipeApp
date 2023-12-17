import {categoriesResponse} from "../Categorie.ts";
import {useNavigate} from "react-router-dom";


export default function CategoryImage(){
    const navigate = useNavigate()

    return (
        <>
            {
                categoriesResponse.categories.map((category,index)=>
                    <div className="custom-image" style={{paddingTop: "90%"}}>
                        <img
                            onClick={()=>navigate("/category/"+category.strCategory)}
                            src={category.strCategoryThumb}
                            alt=""
                            key={index}
                        />
                    </div>
                )
            }

        </>
    )
}