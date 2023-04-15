import java.util.ArrayList;
import java.util.List;

public class StudentsData {

    public static void main(String[] args) {
        String input = "1#Malcolm Barnes#9#velit.aliquam@outlook.couk#375-3721 Elementum_ Road#Adana#United Kingdom$" +
                "2#Devin Crane#0#eu.sem@outlook.edu#217-4777 Lorem_ Rd.#South Australia#Ukraine$" +
                "3#Isaiah Jacobson#10#class.aptent@icloud.net#339-2256 Sagittis Rd.#Oslo#Netherlands$" +
                "4#Cedric Burris#2#vitae.dolor.donec@aol.net#P.O. Box 990_ 8379 Vel Avenue#Hà Giang#Brazil$" +
                "5#Mark Delgado#2#quis.massa.mauris@aol.com#Ap 494-9054 Sed St.#Sokoto#Peru$" +
                "6#Fritz Howe#8#nunc.in@hotmail.couk#480-6041 Nam Ave#Sokoto#Peru$" +
                "7#Walker Tate#4#arcu.et@outlook.couk#2696 Vulputate Ave#Puntarenas#Spain$" +
                "8#Wallace Fischer#6#viverra.donec@hotmail.org#634-7895 Viverra. Ave#South Kalimantan#Turkey$" +
                "9#Wayne Frost#9#felis.ullamcorper@hotmail.org#Ap 873-7960 Aliquet St.#Tennessee#India$" +
                "10#Celeste Lynn#3#consequat.purus@icloud.com#Ap 908-7270 In Avenue#British Columbia#Belgium$" +
                "11#Gemma Estrada#7#eu.dolor@protonmail.couk#Ap 730-224 Magnis Ave#Sonora#New Zealand$" +
                "12#Chaney Greene#6#fermentum.convallis.ligula@icloud.ca#3300 Dapibus Rd.#South Island#Ukraine$" +
                "13#Solomon Cantrell#7#nec.metus@yahoo.com#900-5262 Quisque St.#East Region#China$" +
                "14#Hope Huber#1#felis.nulla.tempor@aol.ca#865-1277 Id Street#East Region#China$" +
                "15#Edward Woodard#1#vitae.nibh@aol.ca#3257 Rutrum Rd.#Principado de Asturias#France$" +
                "16#Kitra Dotson#3#mi.aliquam.gravida@yahoo.net#4776 Sodales Street#Viken#Belgium$" +
                "17#Conan Stanley#2#class.aptent@protonmail.couk#P.O. Box 485 8710 Lobortis Rd.#Viken#Belgium$" +
                "18#Portia Garcia#6#in.tincidunt.congue@yahoo.edu#P.O. Box 507 7725 Tellus. Av.#Saint Petersburg City#Brazil$" +
                "19#Britanney Nunez#4#montes@aol.net#Ap 184-2135 Sagittis St.#Saint Petersburg City#Brazil$" +
                "20#Alea Sherman#7#vestibulum.massa@icloud.com#P.O. Box 733 5369 Ornare_ Ave#Thái Bình#Canada$" +
                "21#Brynn Sweeney#1#quisque.ac@aol.couk#2344 Ac Street#Viken#Mexico$" + "22#Ila Carr#10#leo@icloud.net#629-144 Est. Ave#Staffordshire#Canada$" +
                "23#Vivian Henderson#7#nunc@outlook.edu#9422 Amet_ Rd.#Jigawa#Canada$" + "24#Kristen Bray#4#ipsum@aol.ca#5415 Consequat Street#Luik#Netherlands$" +
                "25#Mollie Schmidt#6#luctus.sit@outlook.edu#2213 Dictum Rd.#Cheshire#Peru$" + "26#Lillian Huber#1#risus.donec@outlook.net#P.O. Box 743_ 7082 Ut Avenue#Bourgogne#Ireland$" +
                "27#Merritt Christensen#5#sit.amet.metus@google.ca#Ap _728-7344 Pede. Road#Gelderland#Russian Federation$" +
                "28#Uriel Beck#7#aliquam.fringilla@protonmail.edu#368-263 A_ Av.#Gelderland#Russian Federation$" +
                "29#Martha Sharp#0#lobortis.class@hotmail.edu#914-413 Velit Ave#North-East Region#Netherlands$" +
                "30#Julian Castillo#3#id@outlook.edu#Ap _772-5501 Erat_ Rd.#Lakshadweep#Italy$" +
                "31#Idona Webster#5#et@protonmail.couk#174-3527 Tempus Avenue#Eastern Cape#New Zealand$" +
                "32#Portia Harris#9#leo.elementum@protonmail.couk#724-9322 Amet_ Ave#Noord Holland#Poland$" +
                "33#Joelle Hinton#1#blandit@google.edu#Ap _697-7153 Ut St.#Piura#Poland$" + "34#Janna Curry#5#molestie.pharetra@yahoo.edu#Ap _210-7638 Nunc Avenue#Flintshire#Germany$" +
                "35#Leroy Atkinson#2#a.nunc@hotmail.couk#Ap _655-5992 Turpis. Street#Nunavut#Australia$" + "36#Stacy Stuart#5#dolor.fusce@icloud.couk#312 In Av.#Kharkiv oblast#Norway$" +
                "37#Joy Mejia#9#nec.ligula.consectetuer@icloud.couk#Ap _324-7069 In_ Rd.#Kharkiv oblast#Norway$" +
                "38#Robin Byrd#8#sed@hotmail.ca#Ap _707-4461 Adipiscing Avenue#Leinster#Nigeria$" +
                "39#Priscilla Oliver#0#phasellus.elit.pede@aol.couk#3088 Egestas. Road#North Island#Philippines$" +
                "40#Macy Lucas#6#justo.nec@outlook.ca#Ap _275-4387 Neque St.#North Island#Philippines$" +

                "41#Maxwell Atkinson#3#in.faucibus.orci@google.net#7695 Ante. Ave#Newfoundland and Labrador#China$" +
                "42#Deborah Weber#4#cras.vulputate@hotmail.ca#P.O. Box 227_ 3215 Egestas Rd.#Lagos#United Kingdom$" +
                "43#Asher Sampson#3#sed.sapien@yahoo.com#357-9720 Nisi St.#Calabria#Canada$" +
                "44#Fritz Mason#7#aliquam.tincidunt@aol.org#Ap _168-3089 Nonummy Avenue#Luxemburg#Ireland$" +
                "45#Drew Lester#5#ultrices@hotmail.org#Ap _531-2307 Mauris Rd.#Nordland#Australia$" +
                "46#Victor Branch#1#praesent.luctus@aol.couk#P.O. Box 844_ 2641 Curabitur Avenue#Nordland#Australia$" +
                "47#Jamalia Glenn#0#ultrices.duis.volutpat@outlook.org#147-9058 Tristique St.#North Jeolla#Russian Federation$" +
                "48#Debra Velez#4#consequat.lectus@yahoo.com#530-743 Rutrum Road#Sinaloa#Spain$" +
                "49#Arthur Lyons#2#conubia.nostra@google.com#P.O. Box 184_ 7637 Iaculis Rd.#Meghalaya#Turkey$" +
                "50#Steel Bradshaw#5#dolor.fusce@google.net#Ap _244-4361 Aliquam Street#Victoria#France$" +
                "52#Kim Dennis#6#amet@icloud.com#Ap _870-3406 Nec Road#West Region#Colombia$" +
                "53#Rose Dominguez#0#est.congue@yahoo.edu#9208 Eu Road#West Region#Colombia$" +
                "54#Candace Lancaster#0#primis.in.faucibus@yahoo.net#654-6713 Nec_ Av.#West Region#Colombia$" +
                "55#Mark Mays#0#velit.sed@hotmail.net#624-4965 Nisi. Ave#Ankara#Ireland$" +
                "56#Athena Mccall#3#a.dui@hotmail.edu#305-5528 Dolor_ Av.#Ceuta#South Africa$" +
                "57#Barrett Valencia#10#pede@yahoo.org#Ap _679-461 Nulla Ave#Mykolaiv oblast#Peru$" +
                "58#Daniel Cantu#8#feugiat.nec@protonmail.couk#958 Vulputate Rd.#Murcia#Pakistan$" +
                "59#Aquila Sexton#9#eget@aol.edu#Ap _675-8281 Lorem Avenue#North Island#India$" +
                "60#Dawn Owen#4#vulputate.nisi@outlook.edu#4490 Risus. Avenue#Lakshadweep#Canada$" +
                "61#Steven Warner#5#justo@outlook.net#5510 Enim. Av.#Trentino-Alto Adige#Ukraine$" +
                "62#Jack Keller#6#facilisis.non@icloud.ca#838-4631 Nam Ave#North Island#Singapore$" +
                "63#Ashton Mcclure#9#ultricies.ligula@hotmail.net#330-4040 Natoque Av.#Sokoto#Vietnam$" +
                "64#Autumn Hart#6#morbi@protonmail.com#3712 Ut Street#Limpopo#Costa Rica$" +
                "65#Kenneth Mccormick#7#at.velit@outlook.net#P.O. Box 155_ 1042 Faucibus Av.#Mpumalanga#Vietnam$" +
                "66#Rhiannon Shepard#8#tempus@protonmail.net#254-3275 Id Ave#Kogi#Indonesia$" +
                "67#Hermione Franklin#9#ante.dictum@yahoo.ca#Ap _862-4027 Feugiat Rd.#Comunitat Valenciana#Colombia$" +
                "68#Deirdre Dotson#4#sit@aol.edu#614 A_ Rd.#Cornwall#Italy$" +
                "69#Cheryl Nichols#7#nam.porttitor@protonmail.net#Ap _720-5778 Suspendisse Ave#Cornwall#Italy$" +
                "70#Rogan Collier#3#ut.tincidunt@protonmail.edu#233-4874 Molestie Street#Connacht#India$" +
                "71#Janna Ayala#9#egestas.blandit.nam@yahoo.com#Ap _396-204 Praesent Street#South Island#Singapore$" +
                "72#Declan Thornton#0#donec.tempus@outlook.net#145-5160 Elit St.#Zakarpattia oblast#France$" +
                "73#Calista Gross#7#euismod.urna.nullam@yahoo.net#Ap _879-4354 Purus. Ave#Zakarpattia oblast#France$" +
                "74#Cameran Pierce#1#fames.ac@outlook.edu#Ap _703-5544 Erat Av.#Western Australia#Nigeria$" +
                "75#Keegan Gonzales#3#ultrices.duis@icloud.ca#P.O. Box 691_ 4982 Hendrerit Av.#Antalya#Philippines$" +
                "76#Yardley Cherry#4#arcu.sed@outlook.com#4985 Augue Ave#Antalya#Philippines$" +
                "77#Roary Nichols#6#quisque.purus.sapien@yahoo.couk#Ap _794-6411 Lorem_ Rd.#Kano#India$" +
                "78#Jordan Payne#9#nullam.feugiat.placerat@outlook.net#531-9901 Duis Road#North West#China$" +
                "79#Maggy Mcmahon#2#sem@outlook.org#262-2915 Pellentesque St.#South Island#Chile$" +
                "80#Maxine Mccarty#0#tincidunt.donec.vitae@hotmail.ca#Ap _931-3237 Quisque Rd.#Limpopo#Singapore$" +
                "81#Bruce Maddox#2#quisque.purus@protonmail.couk#7781 Ante Ave#Puno#Netherlands$" +
                "82#Ezra Levy#9#donec.non@google.edu#P.O. Box 695_ 3244 At_ Street#Arunachal Pradesh#France$" +
                "83#Nasim Lambert#0#cursus@aol.couk#Ap _645-301 Rhoncus. Rd.#Nordland#Chile$" +
                "84#Walter Barnes#6#auctor.odio@yahoo.edu#Ap _331-9939 Nibh Av.#Manitoba#South Korea$" +
                "85#Jenna Lambert#7#sagittis.felis.donec@outlook.com#Ap _560-6484 Nibh Street#Northern Cape#New Zealand$" +

                "86#Abraham Townsend#3#facilisis.non@google.org#523-8558 Lectus Avenue#Lancashire#India$" +
                "87#Ima Mcdonald#2#cubilia@outlook.com#597-1226 Non_ Rd.#Donetsk oblast#United Kingdom$" +
                "88#Len Rosa#0#eu.odio.phasellus@icloud.ca#8262 Interdum. Ave#Vinnytsia oblast#Pakistan$" +
                "89#Kelly Kane#8#quisque.imperdiet@hotmail.couk#Ap _167-1479 Enim. Av.#Nordland#Brazil$" +
                "90#Ferris Bishop#7#egestas@google.couk#371-6964 Placerat Avenue#Mississippi#Ireland$" +
                "91#Kenyon Fields#7#sem@aol.edu#486-6311 Amet Av.#Papua#Ireland$" +
                "92#Kane Wise#10#in.tempus@outlook.org#837-8715 Aliquam Street#South Chungcheong#Russian Federation$" +
                "93#Alyssa Wilkinson#8#aliquet.proin@outlook.org#P.O. Box 175_ 9681 Pellentesque Av.#Coquimbo#Sweden$" +
                "94#Isaac Booth#3#eleifend.egestas.sed@yahoo.edu#386-2660 In Ave#Vienna#United Kingdom$" +
                "95#Glenna Short#10#convallis.in.cursus@icloud.ca#602-2298 Eros St.#Maine#Chile$" +
                "96#Abraham Stephenson#6#lobortis.tellus@outlook.org#P.O. Box 111_ 9940 Sed Street#Azad Kashmir#Turkey$" +
                "97#Martin Lucas#4#sapien.molestie@yahoo.net#854-9670 Suspendisse Av.#Coquimbo#Norway$" +
                "98#Jaden Rivas#6#nec@google.org#Ap _483-2209 Malesuada. Avenue#Georgia#Mexico$" +
                "99#Zahir Mueller#7#eget@hotmail.com#8467 Vitae Rd.#Georgia#Mexico$" +
                "100#Hilel Hodges#1#interdum@hotmail.edu#1313 Purus. Ave#Magdalena#United States$";

        // Parse the input string and store the data in a list
        List<String[]> studentDataList = new ArrayList<>();
        String[] studentData = input.split("\\$");
        for (String data : studentData) {
            studentDataList.add(data.split("#"));
        }

        // Print the header
        System.out.println("--------------------------");
        System.out.println("Current Student List");
        System.out.println("--------------------------");
        System.out.println("id\tname\t\tGrade\temail\t\t\t\taddress\t\t\t\tregion\t\tcountry");

        // Print the student data
        for (String[] student : studentDataList) {
            System.out.printf("%s\t%s\t\t%s\t%s\t%-30s\t%-15s\t%s\n",
                    student[0], student[1], student[2], student[3], student[4].replace("_", " "),
                    student[5], student[6]);
        }
    }
}
