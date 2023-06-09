import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner Eingabe = new Scanner(System.in);

        int ErgebnisGanzzahl;
        char Operator = 0;
        double ErgebnisKommazahl;
        double c, d;
        String s;
        boolean neueRechnung = true;
        int[] Historie = new int[10];

        for(int i =0;i<10;i++)
        {
            Historie[i] = -1;
        }

        System.out.println("Hallo User willkommen bei deinem ersten Taschenrechner");

        while (neueRechnung)
        {
            int a, b = 0;
            boolean korrekt = true;
            boolean berechnungFertig = true;


            AusgabeHistorie(Historie);


            do {
                System.out.print("Gib die erste Zahl ein: ");
                a = Eingabe.nextInt();
                if (a == 0) {
                    System.out.println("Die Zahl 0 ist für Division nicht geeignet. Bitte geben sie einen Wert ungleich 0 ein");
                }
            } while (a == 0);

            while (b == 0)
            {
                System.out.print("Geben sie die 2te Zahl ein: ");
                b = Eingabe.nextInt();
                if (b == 0) {
                    System.out.println("Die Zahl 0 ist für Division nicht geeignet. Bitte geben sie einen Wert ungleich 0 ein");
                }
            }

            while (korrekt)
            {
                System.out.print("Rechenoperation auswählen (+ , - , * , / , e = Ende): ");
                s = Eingabe.next();
                Operator = s.charAt(0);
                if (Operator == '+' || Operator == '-' || Operator == '*' || Operator == '/') {
                    korrekt = false;
                } else {
                    System.out.println("Die Eingabe War falsch bitte erneut versuchen");
                }
            }


            if (Operator == '+')  // '+' == 43
            {
                ErgebnisGanzzahl = a + b;
                History(Historie, ErgebnisGanzzahl);
                System.out.println("Das Ergebnis der Summe von a " + a + " und b " + b + " lautet: " + ErgebnisGanzzahl);
            } else if (Operator == '-') {
                ErgebnisGanzzahl = a - b;
                History(Historie, ErgebnisGanzzahl);
                System.out.println("Das Ergebnis der Subtraktion von a " + a + " und b " + b + " lautet: " + ErgebnisGanzzahl);
            } else if (Operator == '*') {
                ErgebnisGanzzahl = a * b;
                History(Historie, ErgebnisGanzzahl);
                System.out.println("Das Ergebnis der Multiplikation von a " + a + " und b " + b + " lautet: " + ErgebnisGanzzahl);
            } else if (Operator == '/' && b != 0) {

                c = Double.valueOf(a);
                d = Double.valueOf(b);

                ErgebnisKommazahl = c / d;
                System.out.println("Das Ergebnis der Division von a " + a + " und b " + b + " lautet: " + ErgebnisKommazahl);
            }

            while (berechnungFertig)
            {
                System.out.print("Möchten Sie eine weitere Berechnung durchführen? (Y//N)");
                s = Eingabe.next();
                Operator = s.charAt(0);
                if (Operator == 'n')
                {
                    System.out.println("Bye have a great time!");
                    berechnungFertig = false;
                    neueRechnung = false;
                }
                else if ( Operator == 'y')
                {
                    System.out.println("Bitte führen Sie eine neue Rechnung durch");
                    berechnungFertig = false;
                }
                else
                {
                    System.out.println("Die Eingabe war falsch bitte erneut versuchen");
                }
            }
        }
    }

    static void History(int history[], int Ergebnis)
    {
        for(int i =0; i<11; i++ )
        {
            if(i==10)
            {
                history[0]=Ergebnis;
                i=0;
                history[1]=-1;   //history[i+1]=-1;
                break;
            }
            else if(history[i]== -1)
            {
                history[i]=Ergebnis;
                if (i<9)
                {
                    history[i+1]=-1;
                }
                break;
            }

        }
    }
    static void AusgabeHistorie(int history[])
    {
        while(true)
        {
            if (history[history.length - 1] == -1)
            {
                int i = 0;
                while (history[i] != -1)
                {
                    System.out.println("Ihr Ergebnis Nr: " + (i + 1) + " lautet: " + history[i]);
                    i++;
                }
                break;
            }
            else
            {
                int i = 0;
                int j = 0;

                do
                {
                    i++;
                }while (history[i] != -1 && i<9);

                while(j<10)
                {
                    if(i+j>9)
                    {
                        if(i+j == 10)
                            System.out.println("Ihr Ergebnis Nr: " +(1)+ " lautet: "+history[0]);
                        if(i+j == 11)
                            System.out.println("Ihr Ergebnis Nr: " +(2)+ " lautet: "+history[1]);
                        if(i+j == 12)
                            System.out.println("Ihr Ergebnis Nr: " +(3)+ " lautet: "+history[2]);
                        if(i+j == 13)
                            System.out.println("Ihr Ergebnis Nr: " +(4)+ " lautet: "+history[3]);
                        if(i+j == 14)
                            System.out.println("Ihr Ergebnis Nr: " +(5)+ " lautet: "+history[4]);
                        if(i+j == 15)
                            System.out.println("Ihr Ergebnis Nr: " +(6)+ " lautet: "+history[5]);
                        if(i+j == 16)
                            System.out.println("Ihr Ergebnis Nr: " +(7)+ " lautet: "+history[6]);
                        if(i+j == 17)
                            System.out.println("Ihr Ergebnis Nr: " +(8)+ " lautet: "+history[7]);
                        if(i+j == 18)
                            System.out.println("Ihr Ergebnis Nr: " +(9)+ " lautet: "+history[8]);
                        if(i+j == 19)
                            System.out.println("Ihr Ergebnis Nr: " +(10)+ " lautet: "+history[9]);
                    }
                    else
                    {
                        System.out.println("Ihr Ergebnis Nr: " +(i+1+j)+ " lautet: "+history[i+j]);
                    }
                    j++;
                }
            }
            break;
        }
    }
}
