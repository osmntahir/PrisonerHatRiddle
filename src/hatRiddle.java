
public class hatRiddle {
    private String[] peopleHats = new String[10];
    private String[] predictedHats = new String[10];
    private String[] hats = new String[2];


    public hatRiddle() {
        hats[0] = "White";
        hats[1] = "Black";

        for (int i = 0; i < 10; i++) {
            peopleHats[i] = hats[(int) (Math.random() * 2)];
        }
    }

    void guess()
    {
        int[] blackHatCnts = new int[10];
        int blackHatCntInIndex = 0;
        for (int i = 10-1; i > 0; i--) {
            if(peopleHats[i].equals(hats[1])) {
                blackHatCntInIndex++;
            }
            blackHatCnts[i-1] = blackHatCntInIndex;
        }

        // Predicting by using the counts
        boolean isEven = false;
        for (int i = 0; i < blackHatCnts.length; i++) {
            int blackHatCnt = blackHatCnts[i];
            if(i == 0) {
                predictedHats[i] = hats[(int) (Math.random() * 2)];
            } else {
                if((blackHatCnt % 2 == 0) && isEven) {
                    predictedHats[i] = hats[0];
                } else if(!(blackHatCnt % 2 == 0) && !isEven) {
                    predictedHats[i] = hats[0];
                } else {
                    predictedHats[i] = hats[1];
                }
            }
            isEven = blackHatCnt % 2 == 0;
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

