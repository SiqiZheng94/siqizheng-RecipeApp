import axios from "axios";
import {useEffect, useState} from "react";
import {Categorie} from "../Categorie.ts";

type CustomeImageProps = {
    categories:Categorie[]
}

export default function CustomImage(props:CustomeImageProps){
    const [categories, setCategories] = useState<Categorie[]>([])
    const fetchCategories=()=>{
        axios.get("www.themealdb.com/api/json/v1/1/categories.php")
            .then(response=> {
                setCategories(response.data)
                console.log("response.data::::::"+response.data)
            })
    }
    useEffect(() => {
        fetchCategories()
    }, []);
    return (
        // images.map((src,index)=>(
        //         <div className="custom-image" style={{paddingTop: "90%"}}>
        //             <img src={src} alt="" key={index}/>
        //         </div>
        //     )
        // )
        <>

            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_1.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_2.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_3.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_4.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_5.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_6.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_7.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_8.jpg"} alt=""/>
            </div>
            <div className="custom-image" style={{paddingTop: "90%"}}>
                <img src={"/img/gallery/img_9.jpg"} alt=""/>
            </div>

        </>
    )
}