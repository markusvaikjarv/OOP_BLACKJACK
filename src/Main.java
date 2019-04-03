import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Blackjack - OOP Projekt");

        Kaardipakk manguPakk = new Kaardipakk(); //mängija kaardid
        manguPakk.koostaTaisPakk();
        manguPakk.sega();

        Kaardipakk mangijaKaardid = new Kaardipakk();

        double mangijaRaha = 1000.0;

        Kaardipakk diileriKaardid = new Kaardipakk(); //Diileri kaardid

        Scanner sisend = new Scanner(System.in);


        while (mangijaRaha > 0) { //Mäng kestab nii kaua, kuni mängijal on raha

            //Võtan kasutajalt panuse
            System.out.println("Sul on " + mangijaRaha + "€. Sisesta oma panus:");
            double panus = sisend.nextDouble();
            boolean lopp = false; //tähistab mängu lõppu

            //Kontrollin, et mängija liiga palju ei panustanud
            if (panus > mangijaRaha) {
                System.out.println("Panus asetamiseks ei ole piisavalt raha");
                break;
            }


            //Mõlemad võtavad 2 kaarti
            System.out.println("Jagan kaarte");
            mangijaKaardid.votaKaart(manguPakk);
            mangijaKaardid.votaKaart(manguPakk);

            diileriKaardid.votaKaart(manguPakk);
            diileriKaardid.votaKaart(manguPakk);


            while (true) {
                System.out.println("Sinu kaardid:" + mangijaKaardid.toString());
                System.out.println("Hetkene punktiarv: " + mangijaKaardid.kaardiVaartus());
                System.out.println("Diileri kaardid: " + diileriKaardid.getKaart(0).toString() + " ning teine kaart on peidetud");


                System.out.println("Sisesta number: ");
                System.out.println("                1, kui soovid veel ühe kaardi võtta");
                System.out.println("                2, kui soovid pidama jääda");
                int vastus = sisend.nextInt(); //ootab kuni kasutaja oma valiku sisestab

                if (vastus == 1) {

                    mangijaKaardid.votaKaart(manguPakk);
                    System.out.println("Võtsid kaardi:" + mangijaKaardid.getKaart(mangijaKaardid.pakiSuurus() - 1).toString());

                    if (mangijaKaardid.kaardiVaartus() > 21) { //mängija kaotab kui punkte on rohkem kui 21
                        System.out.println("Läksid lõhki. Punktiarv: " + mangijaKaardid.kaardiVaartus());
                        mangijaRaha -= panus;

                        lopp = true;

                        break;
                    }
                }

                //Kui valik on 2, siis väljutakse tsüklist
                if (vastus == 2) {
                    break;
                }

            }

            System.out.println("Diileri kaardid:" + diileriKaardid.toString());
            //kontrollin kas diileril on rohkem punkte
            if ((diileriKaardid.kaardiVaartus() > mangijaKaardid.kaardiVaartus()) && !lopp) {
                System.out.println("Diiler võitis. Diileril on punkte: " + diileriKaardid.kaardiVaartus() + " ning sinul: " + mangijaKaardid.kaardiVaartus());
                mangijaRaha -= panus;
                lopp = true;
            }
            //kui diileril on 17, siis ta enam juurde ei võta
            while ((diileriKaardid.kaardiVaartus() < 17) && !lopp) {
                diileriKaardid.votaKaart(manguPakk);
                System.out.println("Diiler võttis kaardi: " + diileriKaardid.getKaart(diileriKaardid.pakiSuurus() - 1).toString());
            }
            System.out.println("Diileri punktiarv: " + diileriKaardid.kaardiVaartus());

            //kui diileril on rohkem kui 21 punkti, siis ta kaotab
            if ((diileriKaardid.kaardiVaartus() > 21) && !lopp) {
                System.out.println("Diiler läks lõhki. Sinu võit!");
                mangijaRaha += panus;
                lopp = true;
            }
            //Mäng läheb viiki, kui mängijal ja diileril sama palju punkte
            if ((diileriKaardid.kaardiVaartus() == mangijaKaardid.kaardiVaartus()) && !lopp) {
                lopp = true;
            }
            //Kontrollin kes võidab
            if ((mangijaKaardid.kaardiVaartus() > diileriKaardid.kaardiVaartus()) && !lopp) {
                System.out.println("Sinu võit.");
                mangijaRaha += panus;
                lopp = true;
            } else if (!lopp) { //Diiler võidab
                System.out.println("Diileri võit.");
                mangijaRaha -= panus;
            }

            //Kaardid pannakse tagasi valikusse
            mangijaKaardid.paneKoikPakki(manguPakk);
            diileriKaardid.paneKoikPakki(manguPakk);
            System.out.println("___________________________________________________");

        }

        //Mängu lõpp
        System.out.println("\nKaotasid kogu oma raha. Sulgen programmi ...");

        sisend.close();

    }


}