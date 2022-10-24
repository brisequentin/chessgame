import java.util.Scanner;

class Main {
    //We create scanner so we can read input.
    static Scanner entree = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("1 - New game");
        if (entree.nextInt()==1)
        {
            Board board = new Board();
            entree.nextLine();
            System.out.println("Please, Enter the name of your game :");
            String nameGame = entree.nextLine();
            System.out.println("Please, Enter the name of your player 1 :");
            String nameP1 = entree.nextLine();
            System.out.println("Please, Enter the name of your player 2 :");
            String nameP2 = entree.nextLine();
            System.out.println("name of the game : "+nameGame+" name of player 1 : "+nameP1+" name of player 2 : "+nameP2);
            
            boolean whiteturn = true;
            boolean loop = true;
            //boucle de jeu.
            while (loop){
                Boolean replay = true;
                board.displayBoard();
                int a  = 0;
                System.out.println();
                if (whiteturn){
                    while(replay){
                        
                        System.out.println("White turn : "+nameP1+" enter x");
                        int x1 = entree.nextInt();
                        System.out.println("White turn : "+nameP1+" enter y");
                        int y1 = entree.nextInt();
                        System.out.println("White turn : Where to move now ? enter x");
                        int x2 = entree.nextInt();
                        System.out.println("White turn : enter y");
                        int y2 = entree.nextInt();
                        replay = board.isValidMove(x1, y1, x2, y2,whiteturn);

                        if (replay == false){
                            board.validMove(x1, y1, x2, y2);
                            whiteturn=true;
                        }

                        if (a==3){
                            System.out.println("Victoire Black");
                            loop=false;
                            replay=false;
                        } else {
                            a +=1;
                        }
                    }
                    
                }else{
                    while(replay){
                        System.out.println("Black turn : "+nameP2+" enter x");
                        int x1 = entree.nextInt();
                        System.out.println("Black turn : "+nameP2+" enter y");
                        int y1 = entree.nextInt();
                        System.out.println("Black turn : Where to move now ? enter x");
                        int x2 = entree.nextInt();
                        System.out.println("Black turn : enter y");
                        int y2 = entree.nextInt();
                        replay = board.isValidMove(x1, y1, x2, y2,whiteturn);
                        if (replay == false){
                            board.validMove(x1, y1, x2, y2);
                            whiteturn=true;

                        }

                        if (a==3){
                            loop=false;
                            replay=false;
                            System.out.println("Victoire White");
                        } else {
                            a +=1;
                        }
                    }

                }
            }
            
        } else {

        }
    }
}

