import {categoriesResponse} from "../Categorie.ts";
import {useNavigate} from "react-router-dom";


export default function CategoryImage(){
    const navigate = useNavigate()
    // const pathCategory = useParams().category
    // const [error, setError] = useState<string>("")
    // const [filteredMeals, setFilteredMeals] = useState<Meal[]>([])
    //
    // const mealsData= props.meals.filter(
    //     (meal:Meal) => meal.strCategory === pathCategory
    // )
    // useEffect(() => {
    //     if (mealsData) {
    //         setFilteredMeals(mealsData)
    //         setError("")
    //     } else {
    //         setError("NOT FOUND!")
    //     }
    //
    // }, []);
    return (
        // images.map((src,index)=>(
        //         <div className="custom-image" style={{paddingTop: "90%"}}>
        //             <img src={src} alt="" key={index}/>
        //         </div>
        //     )
        // )
        <>
            {
                categoriesResponse.categories.map((category,index)=>
                    <div className="custom-image" style={{paddingTop: "90%"}}>
                        <img
                            onClick={()=>navigate("/category/"+category.strCategory)}
                            src={category.strCategoryThumb}
                            alt=""
                            key={index}/>
                    </div>
                )
            }

        </>
    )
}