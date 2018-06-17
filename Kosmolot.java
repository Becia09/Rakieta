import java.util.Scanner;
import static java.lang.Math.abs;

public class Kosmolot
{
    public static void shiedlOff(int sizeRocket)
    {
        String tabRocket[] = new String[sizeRocket];
        String line = "";
        int countStar = 1;
        int countSpace = sizeRocket-1;

        for (int i = 0; i < sizeRocket; i++)
        {
            for (int j = 0; j < sizeRocket; j++)
            {
                for (int g = 0; g < countStar; g++)
                {
                    line += "*";
                }

                if (j != sizeRocket - 1)
                {
                    for (int g = 0; g < countSpace; g++)
                    {
                        line += " ";
                    }
                }
            }
            countStar++;
            countSpace--;
            tabRocket[i] = line;
            line = "";
        }

        for (int i = 0; i < tabRocket.length; i++)
        {
            System.out.println(tabRocket[i]);
        }
        for (int i = tabRocket.length - 2; i >= 0; i--)
        {
            System.out.println(tabRocket[i]);
        }
    }

    public static void shiedlOn(int sizeRocket)
    {
        String tabRocket[] = new String[sizeRocket];
        String line = "";
        int countStar = 1;
        int countSpace = sizeRocket-1;

        for (int i = 0; i < sizeRocket; i++)
        {
            for (int j = 0; j < sizeRocket; j++)
            {
                for (int g = 0; g < countStar; g++)
                {
                    if (j == 0 && g == 0)
                    {
                        line += ">";
                    }
                    else if(g == countStar - 1 && i != sizeRocket - 1)
                    {
                        line += "\\";
                    }
                    else if (i == sizeRocket - 1 && g == countStar - 1 && j == sizeRocket - 1)
                    {
                        line += ">";
                    }
                    else
                    {
                        line += "*";
                    }
                }

                if (j != sizeRocket - 1)
                {
                    for (int g = 0; g < countSpace; g++)
                    {
                        line += " ";
                    }
                }
            }
            countStar++;
            countSpace--;
            tabRocket[i] = line;
            line = "";
        }

        for (int i = 0; i < tabRocket.length; i++)
        {
            System.out.println(tabRocket[i]);
        }
        for (int i = tabRocket.length - 2; i >= 0; i--)
        {
            tabRocket[i] = tabRocket[i].replaceAll("\\\\","/");
            System.out.println(tabRocket[i]);
        }
    }

    public static int parserInt(String number)
    {
        int result = 0;

        try {
            result = Integer.parseInt (number);
        } catch(NumberFormatException e) {
            System.out.println ("Podano nieliczbową wartosc");
            System.exit(0);
        }

        if (result < 1 || result > 75) {
            System.out.println("Podana wartosc jest za duza lub za mała");
            System.exit(0);
        }

        return result;
    }
    public static char parserChar(String character)
    {
        if (character.length() != 1)
        {
            System.out.println("za dużo lub za mało znaków");
            System.exit(0);
        }
        char result = ' ';

        try {
            result = character.charAt(0);
        } catch(NumberFormatException e) {
            System.out.println ("Wyjątek");
            System.exit(0);
        }

        if (result != 'N' && result != 'Y')
        {
            System.out.println ("Podano niepoprawną wartosc opancerzenia");
            System.exit(0);
        }

        return result;
    }

    public static void main (String[] args)
    {
        System.out.println ("Podaj rozmiar rakiety i czy jest opancerzona (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("wczytano: " + str + ".");
        System.out.println("dlugosc str: " + str.length());

        String tabString[] = str.split(" ");

        System.out.println("rozmiar tablicy: " + tabString.length);

        if (tabString.length != 2)
        {
            System.out.println("Niewlasciwa ilosc elementów");
            System.exit(0);
        }

        int sizeRocket;
        char shield_on;

        sizeRocket = parserInt(tabString[0]);
        shield_on = parserChar(tabString[1]);

        //---------------------------------------------------------------klasa rakieta
        System.out.println(sizeRocket + " - rozmiar rakiety\n" + shield_on + " - opancerzenie");
        System.out.println(sizeRocket + " " + shield_on);

        if (shield_on == 'N')
        {
            shiedlOff (sizeRocket);
        }
        else
        {
            shiedlOn(sizeRocket);
        }
    }
}


/*
slownik:
szerokosc      - width
wysokosc       - height
kąt nachylenia - slope angle
wiersz         - verse
*/