import java.util.ArrayList;

public class Board {
    
    Piece[][] board = new Piece[8][8];
    Piece[][] boardTemp = new Piece[8][8];

    //creer un tableau 
    public Board(){
        for (int i=0; i<=7; i++){
            for (int v=0; v<=7; v++){
                //premiere ligne
                if(i==0){
                    board[0][0] = new Piece(false,2);
                    board[0][1] = new Piece(false,4);
                    board[0][2] = new Piece(false,3);
                    board[0][3] = new Piece(false,5);
                    board[0][4] = new Piece(false,6);
                    board[0][5] = new Piece(false,3);
                    board[0][6] = new Piece(false,4);
                    board[0][7] = new Piece(false,2);
                } else if (i==7){
                    board[7][1] = new Piece(true,4);
                    board[7][2] = new Piece(true,3);
                    board[7][3] = new Piece(true,5);
                    board[7][4] = new Piece(true,6);
                    board[7][5] = new Piece(true,3);
                    board[7][6] = new Piece(true,4);
                    board[7][7] = new Piece(true,2);
                    board[7][0] = new Piece(true,2);
                } else if (i==1){
                    board[i][v] = new Piece(false,1);
                } else if (i==6){
                    board[i][v] = new Piece(true,1);
                } else {
                    board[i][v] = new Piece(0);
                }
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece getBoard(int x, int y) {
        return this.board[x][y];
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public void setBoard(int x, int y, Piece p) {
        this.board[x][y] = p;
    }

    public void displayBoard(){

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_WHITE = "\u001B[37m";
        
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

        for (int i=0; i<8; i++)
        {
            System.out.print(i);
            for(int v=0; v<8; v++)
            {
                if (i%2 == 0)
                {
                    if (v%2==0)
                    {
                        System.out.print(ANSI_PURPLE_BACKGROUND);
                    } else 
                    {
                        System.out.print(ANSI_CYAN_BACKGROUND);
                    }
                } else 
                {
                    if (v%2==0)
                    {
                        System.out.print(ANSI_CYAN_BACKGROUND);
                    } else 
                    {
                        System.out.print(ANSI_PURPLE_BACKGROUND);
                    }
                }

                if (this.getBoard(i, v).type == 0)
                {
                    System.out.print("      ");
                } else {
                    //si p fou + noir
                    if (this.getBoard(i, v).type == 3)
                    {   
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+"Bishop");
                        } else 
                        {
                            System.out.print(ANSI_WHITE+"Bishop");
                        } 
                    }else if(this.getBoard(i, v).type == 6)
                    {
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+" King ");
                        } else 
                        {
                            System.out.print(ANSI_WHITE+" King ");
                        }   
                    } else if(this.getBoard(i, v).type == 2)
                    {
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+" Rook ");
                        } else 
                        {
                            System.out.print(ANSI_WHITE+" Rook ");
                        } 
                    }else if(this.getBoard(i, v).type == 5)
                    {
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+"Queen ");
                        }
                        else 
                        {
                            System.out.print(ANSI_WHITE+"Queen ");
                        }
                    } else if (this.getBoard(i, v).type == 1)
                    {
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+" Pawn ");
                        } 
                        else 
                        {
                            System.out.print(ANSI_WHITE+" Pawn ");
                        } 
                    } else if (this.getBoard(i, v).type == 4)
                    {
                        if (!this.getBoard(i, v).isWhite)
                        {
                            System.out.print(ANSI_BLACK+"Knight");
                        } else 
                        {
                            System.out.print(ANSI_WHITE+"Knight");
                        } 
                    }
                }
                System.out.print(ANSI_RESET+" ");    
            } 
            System.out.print(ANSI_RESET+"\n");
        } 


        System.out.print(" ");
        for(int i=0; i<8;i++){
            System.out.print("   "+i+"   ");
        }
        System.out.println();
    }

    public boolean isValidMove(int x1,int y1, int x2, int y2, Boolean whiteturn){
        //un coup est valide si:
            //x1 y1 == bonne couleur
            //x2 y2 pas out of bounds // deja fait

            //il faut v??rifier si le coup correspond au coup possible de la bonne classe 
            //il faut v??rifier si il n'y a pas un alli?? ou enemi entre x1 x2 et y1 y2
            //il faut v??rifier que le roi n'est pas echec

            //ou alors, je fais un tableau par piece, qui contient chaqun de ses moves possibles ce qui me permet de return true si le roi est echec
            //aussi, si la liste de chaque piece x couleur est vide, alors il y a check mate
            // for(int i=0; i<this.board[x1][y1].getCoupsPossibles().size(); i+=2){
            //     if (x2==this.board[x1][y1].getCoupsPossibles().get(i) && y2==this.board[x1][y1].getCoupsPossibles().get(i+1)){
            //         alors = true;
            //     }
            // }

            // if(alors==false){
            //     return(true);
            // }







            if (this.getBoard(x1, y1).getIsWhite() != whiteturn){
                return(true);
            }
            //
            //System.out.println("le coup est de la bonne couleur");

            for(int i = 0; i<=7; i++){
                for(int v=0; v<=7; v++){
                    if (this.getBoard(i,v).getType() != 0){
                        this.getBoard()[i][v].setCoupsPossibles(this.getBoard(), i, v);
                    }
                }
            }
            

            //System.out.println(this.getBoard(x1, y1).getCoupsPossibles()+"");
            //System.out.println(this.getBoard(x1, y1).getCoupsPossibles().size());
             for (int i=0; i < this.getBoard(x1, y1).getCoupsPossibles().size(); i=i+2){
                 if (this.getBoard(x1, y1).getCoupsPossibles().get(i)==x2 && this.getBoard(x1, y1).getCoupsPossibles().get(i+1)==y2){
                    //test
                    return(sample(x1, y1, x2, y2, whiteturn));
                 }
             }

             
            
        return true;
    }
    public boolean sample(int x1,int y1, int x2, int y2, Boolean whiteturn){

            //on copie le tableau offi
            for(int i = 0; i<=7; i++){
                for(int v=0; v<=7; v++){
                    if (this.getBoard(i,v).getType() != 0){
                        boardTemp[i][v] = new Piece(this.getBoard(i,v).getIsWhite(),this.getBoard(i,v).getType());
                    } else {
                        boardTemp[i][v] = new Piece(0);
                    }
                }
            }
            //on effectue la modif

            boardTemp[x2][y2] = new Piece(this.getBoard(x1,y1).getIsWhite(),this.getBoard(x1,y1).getType(),true); //on cree un nv obj a la pos x2 y2
            boardTemp[x1][y1] = new Piece(0); // on cree un nv obj a la pos x1 y2

            //on regarde chaque coup possible
            for (Piece[] row : boardTemp){
                for (Piece p : row){
                    p.setCoupsPossibles(boardTemp, x1,y1);
                } 
            } //on a set tous les coups possibles

            //pour chaque piece on regarde chaque coup si ??a correspond au roi
            for(int i = 0; i<=7; i++){
                for(int v=0; v<=7; v++){
                    if (this.getBoard(i,v).getType() != 0){
                        boardTemp[i][v].setCoupsPossibles(boardTemp, i, v);
                        //System.out.println(boardTemp[i][v].getCoupsPossibles());
                        for (int k=0; k < boardTemp[i][v].getCoupsPossibles().size(); k=k+2){
                            //System.out.println("test");
                            int ex = boardTemp[i][v].getCoupsPossibles().get(k);
                            int ey = boardTemp[i][v].getCoupsPossibles().get(k+1);
                            if (boardTemp[ex][ey].getType() == 6 && boardTemp[ex][ey].getIsWhite() == whiteturn){
                                return(true);
                            }
                        }
                    } 
                }
            }

            //sample permet de savoir si ton roi est mis en echec
            //obj trouver une piece qui met un roi en echec l'enemi, dire :
            //Si le pion qui met echec est : tour,reine, fou, pion, roi => regarder si le roi peut sortir de la nezo
            //sinon si une piece poss??de un coup sur sa ldv.
            return(false);
    }



    public void validMove(int x1,int y1,int x2,int y2){
        this.setBoard(x2,y2,new Piece(this.getBoard(x1,y1).getIsWhite(),this.getBoard(x1,y1).getType(),true)); //on cree un nv obj a la pos x2 y2
        this.setBoard(x1,y1,new Piece(0)); // on cree un nv obj a la pos x1 y2
        //this.setKingCheck();
    }

    private void setKingCheck() {

        for(int i = 0; i<=7; i++){
            for(int v=0; v<=7; v++){
                if (this.getBoard(i,v).getType() != 0){
                    board[i][v].setCoupsPossibles(board, i, v);
                    //System.out.println(board[i][v].getCoupsPossibles());
                    for (int k=0; k < board[i][v].getCoupsPossibles().size(); k=k+2){

                        //System.out.println("test");
                        int ex = board[i][v].getCoupsPossibles().get(k);
                        int ey = board[i][v].getCoupsPossibles().get(k+1);
                        if (board[ex][ey].getType() == 6 && board[ex][ey].getIsWhite() != board[i][v].getIsWhite()){
                            //alors le roi enemie est mis en echec il faut check quels sont les moves possibles
                            if (board[ex][ey].getIsWhite()){
                                System.out.println("le roi blanc est en echec");
                            } else {
                                System.out.println("le roi noir est en echec");
                            }
                            board[ex][ey].setIsCheck(true);
                            
                            } //sinon on ajoute si il peut manger le pion directos

                            //sinon on regarde si le roi peut bouger
                            for(int l =0; l<=7; l++){ 
                                for(int m =0; m<=7; m++){
                                    if (board[l][m].getIsWhite() == board[i][v].getIsWhite()){


                                        board[l][m].setCoupsPossibles(this.board,l,m);
                                        ArrayList<Integer> valtest = board[l][m].getCoupsPossibles();
                                        ArrayList<Integer> valcheck = board[l][m].getCoupsPossibles();
                                        board[l][m].CoupsPossibles.clear();
                                        for ( int n=0; n < valtest.size(); k=k+2 ){
                                            for ( int o=0; o < valcheck.size(); k=k+2 ){
                                                if (board[i][v].getType() != 4 && valtest.get(n)==valcheck.get(o) && valtest.get(n+1)==valcheck.get(o+1)){ //si on peut se mettre sur la ldv alors on reset la pos et on ajoute le point
                                                    board[l][m].CoupsPossibles.add(valtest.get(n));
                                                    board[l][m].CoupsPossibles.add(valtest.get(n+1));
                                                }
                                                if (ex==valtest.get(n) && ey==valtest.get(n+1)){ //si on peut se mettre sur la ldv alors on reset la pos et on ajoute le point
                                                    board[l][m].CoupsPossibles.add(valtest.get(n));
                                                    board[l][m].CoupsPossibles.add(valtest.get(n+1));
                                                }
                                            }
                                        }
                                    }                          
                                }
                        }             
                    }
                }
            } 
        }
    }
}

