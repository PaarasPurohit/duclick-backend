package com.nighthawk.spring_portfolio.mvc.planet;

import java.util.HashMap;
import java.util.Map;
class PlanetDescriptionStorage {
    private static Map<String, String> planetDescriptions = new HashMap<>();

    static {
        planetDescriptions.put("sun", "The Sun is the star at the center of our so  lar system. It's a giant, hot ball of gas that powers our world with light and heat through nuclear fusion. The Sun has a dynamic surface marked by sunspots and can produce powerful storms and solar flares.");
        planetDescriptions.put("mercury", "Mercury is the closest planet to the Sun and is known for its extreme temperature variations, with scorching hot days and frigid nights due to its lack of atmosphere. It's a rocky, cratered world, and its surface resembles the Moon's.");
        planetDescriptions.put("venus", "Venus is often referred to as Earth's 'sister planet' because of its similar size and composition, but it has a hellish environment with a thick, toxic atmosphere that traps heat, making it the hottest planet in the solar system.");
        planetDescriptions.put("earth", "Our home planet, Earth, is the only known celestial body to support life. It has a diverse environment, with oceans, continents, and a life-sustaining atmosphere, and it's the third planet from the Sun.");
        planetDescriptions.put("moon", "Earth's natural satellite, the Moon, orbits our planet, and its surface is marked by impact craters and volcanic plains. It influences tides on Earth and is the target of historical lunar missions, including NASA's Apollo program. The Moon's study continues to inspire scientific exploration and potential future missions.");
        planetDescriptions.put("mars", "Often called the 'Red Planet' due to its rusty appearance, Mars is the fourth planet from the Sun. It has a thin atmosphere and is known for its striking features, including the largest volcano in the solar system, Olympus Mons.");
        planetDescriptions.put("asteroid", "The asteroid belt is a region located between the orbits of Mars and Jupiter. It contains numerous asteroids, which are rocky and metallic objects. The largest asteroid is Ceres, which is also classified as a dwarf planet.");
        planetDescriptions.put("jupiter", "Jupiter is the largest planet in the solar system and is a gas giant. It's famous for its immense Great Red Spot, a massive storm. Jupiter has a strong magnetic field and many moons, including the Galilean moons.");
        planetDescriptions.put("saturn", "Saturn is known for its stunning system of rings, made up of ice and rock particles. It's a gas giant like Jupiter and has a multitude of moons, with Titan being one of the most intriguing due to its thick atmosphere and liquid lakes.");
        planetDescriptions.put("uranus", "Uranus is a unique planet because it rotates on its side, possibly due to a past collision. It's an ice giant with a bluish tint and a system of rings. Uranus has a smaller number of moons compared to some of the other gas giants.");
        planetDescriptions.put("neptune", "Neptune is the farthest known planet from the Sun and is another ice giant. It has a dynamic atmosphere with dark storm systems, including the Great Dark Spot. Triton, one of Neptune's moons, is notable for its retrograde orbit.");
        planetDescriptions.put("pluto", "Pluto was considered the ninth planet until reclassification as a dwarf planet. Located in the Kuiper Belt, it's a small, icy world with a complex orbit and multiple moons, including Charon.");
        planetDescriptions.put("belt", "The Kuiper Belt is a region of the solar system extending beyond Neptune. It's home to various icy objects and small worlds, including Pluto, Haumea, Makemake, and Eris. These objects are often referred to as Trans-Neptunian Objects.");
    }

    public static String getDescription(String planetId) {
        return planetDescriptions.get(planetId);
    }
}
