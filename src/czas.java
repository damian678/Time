public class czas
{
    //pola

    private int godz;
    private int minuty;

    //konstruktory klasy

    public czas(int godzina, int minuta)
    {
        int a = 0;
        while (minuta - 60 >= 0)
        {
            minuta = minuta - 60;
            a++;
        }
        this.godz = godzina + a;
        this.minuty = minuta;
    }

    public czas(String napis)
    {
        String j = "";
        String k = "";
        String l = "";
        for (int i = 0; i < napis.length(); i++)
        {
            j = "" + napis.charAt(i);
            if (j.equals(" "))
            {
                k = napis.substring(0, i);
                l = napis.substring(napis.length() - 6, napis.length() - 4);
                break;
            }
        }
        this.godz = Integer.parseInt(k);
        this.minuty = Integer.parseInt(l);
    }

    //metoda dodająca czasy

    public czas dodaj(czas t)
    {
        int a = 0;
        while (minuty + t.minuty - 60 >= 0)
        {
            t.minuty = minuty + t.minuty - 60;
            a++;
        }

        t.godz = godz + t.godz + a;
        return t;
    }

    //metoda odejmująca czasy

    public czas odejmij(czas t)
    {
        int a = 0;
        if (minuty < t.minuty)
        {
            t.minuty = 60 + minuty - t.minuty;
            a++;
        }
        t.godz = godz - t.godz - a;
        return t;
    }

    //metoda mnożąca czas przez liczbę

    public czas pomnoz(int ile)
    {
        czas da = new czas(godz, minuty);
        da.godz = godz * ile;
        da.minuty = minuty * ile;
        int b = 0;
        while (da.minuty - 60 >= 0)
        {
            da.minuty = da.minuty-60;
            b++;
        }
        da.godz = godz * ile + b;
        return da;
    }

    //metoda sumująca czasy w tablicy

    public static czas sumuj(czas[] tab)
    {
        int a = 0;
        czas tab2 = new czas(0, 0);
        for (int i = 0; i < tab.length; i++)
        {
            tab2.godz += tab[i].godz;
            tab2.minuty += tab[i].minuty;
        }
        while (tab2.minuty - 60 >= 0)
        {
            tab2.minuty = tab2.minuty - 60;
            a++;
        }

        tab2.godz += a;
        return tab2;
    }

    //metoda toString

    public String toString()
    {
        return godz + " h" + " " + minuty + " min";
    }

    public static void main(String[] args)
    {
        czas czas1 = new czas(2, 370);
        czas czas2 = new czas(1, 51);

        System.out.println("czas1 = " + czas1);
        System.out.println("czas2 = " + czas2);

        System.out.println("czas1 + czas2 = "+czas1.dodaj(czas2));

        System.out.println("czas1 - czas2 = "+czas1.odejmij(czas2));

        int a=2;
        System.out.println("czas2 * "+a+" = "+czas2.pomnoz(a));

        czas czas3 = new czas("44 h 56 min");
        System.out.println(czas3.godz);
        System.out.println("Konstruktor z łańcuchem: "+czas3);

        czas[] tablicaCzasow = {czas1, czas2, czas2};
        System.out.println("Zsumuj czasy dla czas1 + czas2 + czas2: " + czas.sumuj(tablicaCzasow));
    }
}