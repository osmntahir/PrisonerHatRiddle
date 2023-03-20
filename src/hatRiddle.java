public class hatRiddle {
    private String[] peopleHats = new String[10];
    private String[] predictedHats = new String[10];
    private String[] hats = new String[2];

    public hatRiddle() {
        hats[0] = "beyaz";
        hats[1] = "siyah";

        for (int i = 0; i < 10; i++) {
            peopleHats[i] = hats[(int) (Math.random() * 2)];
        }
    }

    void guess() {
        // simdiye kadar ki tahmin edilen siyah sapka sayisi
        int totalblackhats = 0;
        // insanlarin onundeki siyah sapka sayisi
        int nextnumberofBlackHats=0;

        for (int i =0 ; i <10;i++)
        {
            for (int j=i+1; j<10;j++)
            {
                if (peopleHats[j].equals(hats[1]))
                {
                    nextnumberofBlackHats++;
                }
            }
            // ilk eleman
            if (i==0)
            {
                if ((nextnumberofBlackHats)%2==0)
                {
                    predictedHats[0]=hats[0];
                }
                else {
                    predictedHats[0]=hats[1];
                }
            }
            // son eleman
            else if(i==9)
            {
                if (predictedHats[0].equals(hats[1]))
                {
                    if (totalblackhats%2==0)
                    {
                        predictedHats[i]=hats[1];
                    }
                    else
                    {
                        predictedHats[i]=hats[0];
                    }
                }
                else
                {
                    if (totalblackhats%2==0)
                    {
                        predictedHats[i]=hats[0];
                    }
                    else
                    {
                        predictedHats[i]=hats[1];
                    }
                }
            }
            // ara durum
            else
            {
                if (predictedHats[0].equals(hats[1]))
                {
                    if ((nextnumberofBlackHats+totalblackhats)%2==0)
                    {
                        predictedHats[i]=hats[1];
                        totalblackhats++;
                    }
                    else
                    {
                        predictedHats[i]=hats[0];
                    }
                }
                else
                {
                    if ((nextnumberofBlackHats+totalblackhats)%2==0)
                    {
                        predictedHats[i]=hats[0];
                    }
                    else
                    {
                        predictedHats[i]=hats[1];
                        totalblackhats++;
                    }
                }
            }
            nextnumberofBlackHats=0;

        }

       
    }
    public void print()
    {
        for (int i = 0 ; i < 10 ;i++)
        {
            System.out.print(peopleHats[i] + "  ");
        }
        System.out.println();

        for (int i = 0 ; i < 10 ;i++)
        {
            System.out.print(predictedHats[i] + "  ");
        }

    }

}

