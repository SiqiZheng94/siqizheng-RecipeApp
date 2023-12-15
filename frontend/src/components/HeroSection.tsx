import CustomImage from "./CustomImage.tsx";
import { useNavigate } from 'react-router-dom';


const images = [
    "/img/gallery/img_1.jpg",
    "/img/gallery/img_2.jpg",
    "/img/gallery/img_3.jpg",
    "/img/gallery/img_4.jpg",
    "/img/gallery/img_5.jpg",
    "/img/gallery/img_6.jpg",
    "/img/gallery/img_7.jpg",
    "/img/gallery/img_8.jpg",
    "/img/gallery/img_9.jpg"
]
export default function HeroSection(){
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
            <div className={"col gallery"}>
                {images.map((src,index)=>(
                    <CustomImage pt={"90%"} imgSrc={src} key={index} />
                ))}
            </div>
        </div>
    )
}