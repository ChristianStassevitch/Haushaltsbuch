import java.util.ArrayList;
import java.util.Scanner;

class Buchung
{
    String buchungszweck;
    double betrag;
}

public class Main
{
    public static void main(String[] args)
    {

        int kontobestand = 0;

        ArrayList<Buchung> buchungList = new ArrayList<Buchung>();

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext())
        {
            String scannerInput = scanner.nextLine();
            System.out.println(scannerInput);

            String[] splitted = scannerInput.split(" ");
            String auftragsart = splitted[0];

            Buchung currentBuchung = new Buchung();

            double betrag;

            if(auftragsart.equals("übersicht"))
            {
                System.out.println("Kassenbestand: " + kontobestand + " EUR");

                for(int i=0;i<buchungList.size();i++)
                {
                    System.out.println(buchungList.get(i).buchungszweck + ": " + buchungList.get(i).betrag + " EUR");
                }
                continue;
            }
            try
            {
                betrag = Double.parseDouble(splitted[1]);
                currentBuchung.betrag = betrag;
            }
            catch (Exception e)
            {
                betrag = Double.parseDouble(splitted[2]);
                currentBuchung.betrag = betrag;
            }

            try
            {
                betrag = Double.parseDouble(splitted[2]);
                if(auftragsart.equals("auszahlung"))
                {
                    currentBuchung.buchungszweck = splitted[3];
                }
            }
            catch (Exception e)
            {
                try
                {
                    if(auftragsart.equals("auszahlung"))
                    {
                        currentBuchung.buchungszweck = splitted[2];
                    }
                }
                catch(Exception l)
                {

                }
            }

            if(auftragsart.equals("einzahlung"))
            {
                kontobestand += betrag;
                System.out.println("Kassenbestand: " + kontobestand + " EUR");

            }
            else if (auftragsart.equals("auszahlung"))
            {
                kontobestand -= betrag;
                System.out.println("Kassenbestand: " + kontobestand + " EUR");
                buchungList.add(currentBuchung);
            }

            else
            {
                System.out.println("Bitte valides Kommando(einzahlung, auszahlung, übersicht) eingeben");
            }

        }
    }
}