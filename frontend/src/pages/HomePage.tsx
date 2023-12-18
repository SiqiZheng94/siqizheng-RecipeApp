import CategoryImage from "../components/CategoryImage.tsx";
import { useNavigate } from 'react-router-dom';

export default function HomePage(){
    const navigate=useNavigate()
    const openMealPage = ()=>{
        navigate("/meals")
        console.log("click")
    }

    return (
        <div className={"section hero"}>
            {/*The page consists of two columns*/}
            <div className={"col1 typography"}>
                <h1 className="title">What Are We About</h1>
                <p className="info">FoodiesHub is a place where you can please your soul and tummy with delicious food recepies of all cuisine. And our service is absolutely free. So start exploring now.</p>
                <button className="btn" onClick={openMealPage}>explore now</button>
            </div>
            <div className={"col2 gallery"}>
                <CategoryImage/>
            </div>
        </div>
    )
}