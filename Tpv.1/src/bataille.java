/**
 *
 */

import java.util.Random;
public class bataille {
    public static int [][] grilleOrdi = new int [10][10];
    public static int [][] grilleJeu = new int [10][10];

    //verification des parametres...
    public static boolean posOk(int [][]grille, int l, int c, int d, int t){
        int valeurTab = 0;

        for(int indice = 0;indice < t; indice++){
            if(d == 1){
                for(int indiceLigne = 0; indiceLigne < l; indiceLigne++){
                    for(int indiceColonne = 0; indiceColonne < c + indice;indiceColonne++){
                        valeurTab =  grille[indiceLigne][indiceColonne];
                    }
                }
            }
            else{
                for(int indiceLigne = 0; indiceLigne < l + indice; indiceLigne++){
                    for(int indiceColonne = 0; indiceColonne < c;indiceColonne++){
                        valeurTab = grille[indiceLigne][indiceColonne];
                    }
                }
            }
        }

        if(valeurTab == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void initGrilleOrdi(){
        int ligne = randRange(0, 10);
        int colonne = randRange(0, 10);
        int direction = randRange(1, 3);
        int x = 2;
        /*
        ligne = randRange(0, 10);
            colonne = randRange(0, 10);
            direction = randRange(1, 3);
         */

        if(posOk( grilleOrdi,ligne, colonne, direction, x) == true){
            grilleOrdi [ligne][colonne] = 1;
            ligne+= 1;
            colonne+= 1;
        }
        else{
            ligne = randRange(0, 10);
            colonne = randRange(0, 10);
        }


    }

    public static Random rand = new Random();
    public static int randRange(int a, int b){
        return rand.nextInt(b-a) + a;
    }

    public static void AfficherGrille(int [][]grille){
        int compteur = 0;
        System.out.print(" A B C D E F G H I J\n");
        for(int ligne = 0; ligne < 10; ligne++){

            //System.out.print(compteur/10);

            for(int colonne = 0; colonne < 10; colonne++){
                System.out.print(" "+grille[ligne][colonne]);
                compteur+= 1;
                if(compteur % 10 == 0){
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args){
        initGrilleOrdi();
        AfficherGrille(grilleOrdi);
    }


}

