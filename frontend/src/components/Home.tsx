import "../../src/styles/index.scss";
import HeroSection from "./HeroSection.tsx";
function Home() {

    return (
        <div>
            <h1>Home</h1>
            <HeroSection />
            <p>
                Welcome to <b>Recipe-App, </b>where <b>Sergej, Ivan, Siqi,</b> and <b>Marianna</b> come together to
                craft an unparalleled
                culinary experience! Our devoted team of chefs and food enthusiasts has meticulously curated a diverse
                collection of the finest recipes from around the world, ensuring that each dish tells a unique and
                delectable story.

                As you explore Recipe-App, you'll discover a commitment to culinary excellence and a shared love for
                gastronomy. Whether you're a seasoned chef honing your skills or a novice embarking on a culinary
                journey, our extensive selection of recipes caters to every taste and skill level.

                Join our ever-growing community, explore the carefully chosen recipes, and embark on a flavorful
                adventure with us. At <b>Recipe-App, </b>we believe it's not just about food; it's about the people
                behind the
                recipes, the stories they tell, and the joy they bring to your kitchen.

                Come, be a part of our culinary family, where the passion for cooking converges with the art of sharing.
                Immerse your senses, spark your creativity, and experience the dedication of Marianna, Siqi, Ivan, and
                Sergej, that transforms every recipe into a culinary masterpiece at <b>Recipe-App!</b>

            </p>
        </div>
    );
}

export default Home;