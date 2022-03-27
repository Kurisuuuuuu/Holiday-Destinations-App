package au.edu.unsw.infs3634.holidaydestinations;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class Destination {

    // Declared variables
    private String url;
    private String name;
    private String location;
    private String timeZone;
    private String rating;
    private String description;

    // Constructor method
    public Destination(String url, String name, String location, String timeZone, String rating, String description) {

        this.url = url;
        this.name = name;
        this.location = location;
        this.timeZone = timeZone;
        this.rating = rating;
        this.description = description;
    }

    // Getters and setters
    public String getUrl() { return url; }

    public void setUrl(String photo) { this.url = url; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    // Getter method that declares and returns the destinations objects in an ArrayList
    public static ArrayList<Destination> getDestinations() {

        ArrayList<Destination> destinations = new ArrayList<>();

        destinations.add(new Destination("Shibuya+Scramble+Crossing/@35.6594988,139.6983444,17z/data=!3m2!4b1!5s0x60188b57f6921dc9:0x89a02b53bee315f8!4m5!3m4!1s0x60188b3a075fea37:0x1e7b55e1adeda43c!8m2!3d35.6594945!4d139.7005331",
                "Shibuya Crossing", "Shibuya City, Tokyo", "GMT+9", "4.2",
                "The Shibuya Crossing may be one of the most famous crossings in the world. Located at the center of Shibuya City in Tokyo, crossing stops all vehicles from every direction to allow the large influx of pedestrians to cross at once, creating the iconic 'scramble."));

        destinations.add(new Destination("Kabukicho,+Shinjuku+City,+Tokyo+160-0021,+Japan/@35.695547,139.7009607,17z/data=!3m1!4b1!4m5!3m4!1s0x60188cd84e865c35:0x33418e00dfeefac!8m2!3d35.6960834!4d139.7026251",
                "Kabuchiko", "Shinjuku Ward, Tokyo", "GMT+9", "3.8",
                "Known as Tokyo's red-light district, Kabuchiko consists of a variety of adult-oriented entertainment such as casinos, pubs, clubs and massage parlours. This entertainment district can be considered a highlight of Tokyo nightlife. The area is also know to be quite dangerous, infamous for the business conducted in the area by the Japanese mafia, the 'Yakuza'."));

        destinations.add(new Destination("Akihabara,+Taito+City,+Tokyo+110-0006,+Japan/@35.7021768,139.7723633,17z/data=!3m1!4b1!4m5!3m4!1s0x60188ea73ea6f4ff:0x5eb9f1e50fe061e3!8m2!3d35.7022589!4d139.7744733",
                "Akihabara", "Chiyoda Ward, Tokyo", "GMT+9", "4.9",
                "Also known as the 'Electric City', Akihabara is a shopping district located in the Chiyoda Ward of Tokyo, famous for its electronic stores, arcades, maid cafes, and multi-level anime, manga and video game department stores. This miniature city is the prime destination for otaku goods and entertainment."));

        destinations.add(new Destination("Mount+Fuji/@35.3606422,138.7186086,15z/data=!3m1!4b1!4m5!3m4!1s0x6019629a42fdc899:0xa6a1fcc916f3a4df!8m2!3d35.3606255!4d138.7273634",
                "Mount Fuji", "Fuji-Hakone-Izu National Park", "GMT+9", "4.6",
                "Mount Fuji is one of Japan's most highly recognisable landmarks. Located about 100km southwest of Tokyo, it is the largest mountain in the country, and an active volcano. Visitors can choose to climb the mountain, and can expect many shops and food stalls on their way up."));

        destinations.add(new Destination("Hiroshima+Peace+Memorial+Museum/@34.3915071,132.4509691,17z/data=!3m1!4b1!4m5!3m4!1s0x355aa212cbda2bb7:0xf13067716a928180!8m2!3d34.3915779!4d132.4528755",
                "Hiroshima Peace Memorial", "Hiroshima", "GMT+9", "4.2",
                "The Hiroshima Peach Memorial consists of a park and museum. Here the victims of the atomic bombing of the city in World War II is remembered. The museum houses many artefacts left from the incident, and documents the history of the bombing."));

        destinations.add(new Destination("Tsushima,+Nagasaki,+Japan/@34.405938,129.0516745,10z/data=!3m1!4b1!4m5!3m4!1s0x35699de2b389dd29:0x1da9474c7b7ce790!8m2!3d34.2027806!4d129.2875205",
                "Tsushima Island", "Tsushima Island", "GMT+9", "4.4",
                "Tsushima is the name of a small Japanese island archipelago situated west of Japan, not too far from South Korea. This was the site of the two historic Mongol invasion in 13th century, both of which ended when the Mongols were wiped out in a hurricane"));

        destinations.add(new Destination("Dotombori/@34.6687278,135.4991084,17z/data=!3m1!4b1!4m5!3m4!1s0x6000e713818af9fd:0xb8bb1326b48ba590!8m2!3d34.6687234!4d135.5012971",
                "Dotonbori", "Chuo Ward, Osaka", "GMT+9", "4.1",
                "Dotonbori or Dotombori, is quite possibly Osaka's most famouse tourist destination. Spanning the Dotonbori canal, this entertainment district is host to a wide array of shops, restaurants, bars, entertainment facilities, and Osaka's most beautiful view."));

        destinations.add(new Destination("Osaka+Castle/@34.6862033,135.5234029,18z/data=!4m9!1m2!2m1!1sosaka+castle!3m5!1s0x6000e0cd5c283afd:0xf01d07d5ca11e41!8m2!3d34.6869673!4d135.5259154!15sCgxvc2FrYSBjYXN0bGVaDiIMb3Nha2EgY2FzdGxlkgEGY2FzdGxl",
                "Osaka Castle", "Chuo Ward, Osaka", "GMT+9", "4.5",
                "Osaka Castle and its museum are both famous Japanese tourist destinations, both for their architecture and history. There's a rumour that there's a second castle underneath it that houses traps, tigers, ninjas, and ninjas with machine guns, but don't believe that."));

        destinations.add(new Destination("Kinkaku-ji/@35.0393744,135.7270544,17z/data=!3m1!4b1!4m5!3m4!1s0x6001a820c0eb46bd:0xee4272b1c22645f!8m2!3d35.03937!4d135.7292431",
                "Kinkaku-ji", "Kita Ward, Kyoto", "GMT+9", "4.8",
                "Kyoto is known as the 'Old Imperial Capital' of Japan, and Kinkaku-ji is one such monument from this era. Also called the 'Golden Pavilion', this Zen Buddhist temple is considered one of the most famous in the world."));

        destinations.add(new Destination("Tokyo+Tower/@35.6585848,139.7432442,17z/data=!3m2!4b1!5s0x60188bbd90bf26cf:0x4ceb5b05598646d0!4m5!3m4!1s0x60188bbd9009ec09:0x481a93f0d2a409dd!8m2!3d35.6585805!4d139.7454329",
                "Tokyo Tower", "Minato City, Tokyo", "GMT+9", "3.9",
                "One of Tokyo's most iconic sights, the Tokyo Tower stands above the Tokyo skyline and is recognisable from miles away. This monument symbolises the rebirth of Japan following World War II."));

        destinations.add(new Destination("Shurijo+Castle/@26.2170497,127.7172946,17z/data=!3m1!4b1!4m5!3m4!1s0x34e56bfe6cf4db67:0xc0899fbab29e4f8b!8m2!3d26.2170449!4d127.7194833",
                "Shuri Castle", "Naha, Okinawa", "GMT+9", "3.9",
                "Currently a world heritage site, Shuri Castle, or Shurijo, is a highly culturally important castle on the Japanese island of Okinawa. After being destroyed in World War II, it was rebuilt as a university campus."));

        return destinations;
    }

    // Method that returns destination names that fit the string inputted
    public static Destination findDestination (String name) {

        ArrayList<Destination> destinations = Destination.getDestinations();
        for (Destination destination : destinations) {

            if (destination.getName().equals(name)) {

                return destination;
            }
        }

        return null;
    }
}
