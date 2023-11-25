public class Loops
{
    //Problem 6: Pi
    public static double estimatePi(int n) {
        System.out.println("Enter a number.");
        while(n>=1) {
            double pi=0;
            double fraction=1;

            if(n%2==0) {
                pi=pi+4*(1-fraction);
            }

            else if(n%2==1) {
                pi=pi+4*(1+fraction);
            }
            System.out.println(pi);
        }

        //Modulus 2
        return n;
    }

    // public static int sumEveryOther(int n) {
        // do {
            // int original1=n;
            // int original2=n;

            // n=n%10;
            // original1=original1/10;
            // original2=original1/10;
            // int sum=n;

            // original1=original1%10;
            // original2=original2/10;
            // sum=sum+original1;

            // original2=original2%10;
            // original2=original2/10;
            // sum=sum+original2;
        // } while()
        // }

        // // public static void print(int n) {
        // // for(int rows=1; rows<=4; rows++) {
        // // for(String i="*"; ; i+="*") {
        // // System.out.println(i);
        // // break;
        // // }
        // // }
    }
