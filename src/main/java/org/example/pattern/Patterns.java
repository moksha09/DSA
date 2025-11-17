package org.example.pattern;

public class Patterns {
    public static void main(String[] args){
    pattern13(4);
    }

    /**
     *  ####
     *  ####
     *  ####
     *  ####
     * @param n = 4
     */
    static void pattern1(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=n; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /**
     *   #
     *   ##
     *   ###
     *   ####
     *   #####
     *   ######
     */

    static void pattern2(int n){
        for(int row=1; row<=n; row++){
            // for every row how many columns are need - row number of columns for each row
            for(int col=1; col<=row; col++){
                System.out.print("# ");
            }
            // when one row is printed you need a new line
            System.out.println();
        }
    }

    /**
     * ####  n-row+1 = 4-1+1
     * ###   4-2+1 - 3
     * ##    4-3+1
     * #     4-4+1
     *
     * @param n
     */

    static void pattern3(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=n-row+1; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /**
     *  1
     *  1 2
     *  1 2 3
     *  1 2 3 4
     *  1 2 3 4 5
     * @param n
     */
    static void pattern4(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /**
     *  #       row=1, col=1
     *  ##      row=2, col=2
     *  ###
     *  ####
     *  #####   row=5, col=5
     *  ####
     *  ###
     *  ##
     *  #
     *
     * @param n
     */
    static void pattern5(int n){
        // dividing the pattern into 2 parts
        for(int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        for(int row=1; row<=n-1; row++){
            for(int col=1; col<=n-row; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /**
     *     #
     *    ##
     *   ###
     *  ####
     * @param n
     */
    static void pattern6(int n){
        for(int row=1; row<=n; row++){
            //print the spaces first
            for(int col1=1; col1<=n-row;col1++){
                System.out.print(" ");
            }
            // then print the symbol
            for(int col2=1; col2<=row;col2++){
                System.out.print("#");
            }
            System.out.println();

        }
    }

    /**
     * ####
     *  ###
     *   ##
     *    #
     * @param n
     */
    static void pattern7(int n){
        for(int row=1; row<=n; row++){
            // first print the white space column pattern
            for(int col1=0; col1<row; col1++){
                System.out.print(" ");
            }
            // then print the symbol pattern
            for(int col2=1; col2<=n-row+1; col2++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     *    #     row=1, col1 = 3" ", col2 = 1"#", col3 = 3" "
     *   ###
     *  #####
     * #######
     *
     * @param n=4
     */
    static void pattern8(int n){
        for(int row=1; row<=n; row++){
            for(int col1=1; col1<=n-row; col1++){
                System.out.print(" ");
            }
            for(int col2=1; col2<=(row*2)-1; col2++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     *  #######
     *   #####
     *    ###
     *     #
     *
     * @param n=4
     */
    static void pattern9(int n){
        for(int row=1; row<=n; row++){
            for(int col1=1; col1<row; col1++){
                System.out.print(" ");
            }
            for(int col2=1; col2<=2*(n-row)+1; col2++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     *     #
     *    # #
     *   # # #
     *  # # # #
     *
     * @param n=4
     */
    static void pattern10(int n){
        for(int row=1; row<=n; row++){
            for(int col1=1; col1<=n-row; col1++){
                System.out.print(" ");
            }
            for(int col2=1; col2<=row; col2++){
                System.out.print("# ");
            }
            System.out.println();

        }

    }

    /**
     *     #
     *    # #
     *   #   #
     *  #     #
     * #########
     * @param n= 5
     */
    static void pattern13(int n){
        int count=0;
        for(int row=1; row<=n; row++){
            for(int col1=1; col1<=n-row; col1++){
                System.out.print(" ");
            }
            System.out.print("#");

            for(int col2=1; col2<=count; col2++){
                System.out.print(" ");
            }
            if(row>1) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

}
