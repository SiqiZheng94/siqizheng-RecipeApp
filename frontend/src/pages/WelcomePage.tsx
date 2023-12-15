import CustomImage from "../components/CustomImage.tsx";
import { useNavigate } from 'react-router-dom';
import {useState} from "react";
import {Categorie} from "../Categorie.ts";



// export default function WelcomePage(){
//     const navigate=useNavigate()
//     const openMealPage = ()=>{
//         navigate("/meals")
//         console.log("click")
//     }
//
//     return (
//         <div className={"section hero"}>
//             {/*The page consists of two columns*/}
//             <div className={"col typography"}>
//                 <h1 className="title">What Are We About</h1>
//                 <p className="info">FoodiesHub is a place where you can please your soul and tummy with delicious food recepies of all cuisine. And our service is absolutely free. So start exploring now.</p>
//                 <button className="btn" onClick={openMealPage}>explore now</button>
//             </div>
//             <div className={"col gallery"}>
//                 <CustomImage/>
//             </div>
//         </div>
//     )
// }

type CustomeImageProps = {
    categories:Categorie[]
}

export default function WelcomePage(props:CustomeImageProps){
    const navigate=useNavigate()
    const openMealPage = ()=>{
        navigate("/meals")
        console.log("click")
    }

    return (
        <div className={"section hero"}>
            {/*The page consists of two columns*/}
            <div className={"col typography"}>
                <h1 className="title">What Are We About</h1>
                <p className="info">FoodiesHub is a place where you can please your soul and tummy with delicious food recepies of all cuisine. And our service is absolutely free. So start exploring now.</p>
                <button className="btn" onClick={openMealPage}>explore now</button>
            </div>
            {/*{props.categories.map(category=>(*/}
            {/*    */}
            {/*))}*/}
            <div className={"col gallery"}>
                <CustomImage/>
            </div>
        </div>
    )
}