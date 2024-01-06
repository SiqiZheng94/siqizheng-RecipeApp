import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faGithub, faLinkedin} from "@fortawesome/free-brands-svg-icons";

function Footer() {
    return (
        <div className="footer container">
            <div className="footer-section f1">
                <p className="title">BestRecipeApp.com</p>
                <p>BestRecipeApp is a place where you can please your soul and tummy with delicious food recipes of all cuisine.</p>
                <p>&copy; 2024 | All Rights Reserved</p>
            </div>
            <div className="footer-section f2">
                <p className="title">Contact Us</p>
                <p>example@bestrecipe.com</p>
                <p>+49-30-12345678</p>
                <p>45884 Gelsenkirchen</p>
            </div>
            <div className="footer-section f3">
                <p className="title">Socials</p>
                <p>
                    <a href={"https://github.com/SiqiZheng94/recipe-app-siqizheng"}>Github</a>
                    <span> </span>
                    <FontAwesomeIcon icon={faGithub}/>
                </p>
                <p>
                    <a href={"https://www.linkedin.com/in/zhengsiqi/"}>Linkedin</a>
                    <span> </span>
                    <FontAwesomeIcon icon={faLinkedin}/>
                </p>
            </div>
        </div>
    );
}

export default Footer;