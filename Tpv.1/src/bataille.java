/**
 *
 */

import java.util.Random;
public class bataille {
    public static int [][] grilleOrdi = new int [10][10];
    public static int [][] grilleJeu = new int [10][10];

    //verification des parametres...
    public static boolean posOk(int [][]grille, int l, int c, int d, int t){
        //out of index a faire
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
        int l = randRange(0, 10);
        int c = randRange(0, 10);
        int d = randRange(1, 3);

        int x = 2;
        int lngr = 5;
        boolean ok = true;

        //En verticale
        System.out.println("La ligne est: "+ (l + 1) + "\nColonne: " + (c + 1) + "\nDirection: " +d);
        bato(l,c, d, 5);
        /*do{
            for(int indice = 0; indice < lngr; indice++){
                ok = posOk(grilleOrdi,ligne, colonne, direction, x);
            }
           if(ok == false ){
                ligne = randRange(0, 10);
                colonne = randRange(0, 10);
                direction = randRange(1, 3);
            }
        }while(!ok);*/
//        //Si à la verticale
//        for(int i = 0; i < lngr; i++){
//            grilleOrdi[ligne + i][colonne] = 5;
//        }

//        ligne = randRange(0, 10);
//        colonne = randRange(0, 10);
//        direction = randRange(1, 3);
    }

    public static void bato(int ligne, int colonne, int direction , int lngr){
        boolean ok = true;

        do{
            //for(int indice = 0; indice < lngr; indice++){
                ok = posOk(grilleOrdi,ligne, colonne, direction, 5);
            //}
            if(ok == false ){
                ligne = randRange(0, 10);
                colonne = randRange(0, 10);
                direction = randRange(1, 3);
            }
        }while(!ok);
        //Si à la verticale
        if(direction == 1){
            for(int i = 0; i < lngr; i++){
                grilleOrdi[ligne + i][colonne] = 5;
            }
        }
        else{
            for(int i = 0; i < lngr; i++){
                grilleOrdi[ligne][colonne + i] = 5;
            }
        }
   }

    public static Random rand = new Random();
    public static int randRange(int a, int b){
        return rand.nextInt(b-a) + a;
    }

    public static void AfficherGrille(int [][]grille){
        int compteur = 0;
        System.out.print("    A B C D E F G H I J\n");
        for(int ligne = 0; ligne < 10; ligne++){

            System.out.print(compteur/10 + 1 + "  ");

            for(int colonne = 0; colonne < 10; colonne++){
                System.out.print(" "+ grille[ligne][colonne]);
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

