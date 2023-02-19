/**
 *
 */

import java.util.Random;
public class bataille {
    public static int [][] grilleOrdi = new int [10][10];
    public static int [][] grilleJeu = new int [10][10];

    public static boolean posOk(int [][]grille, int l, int c, int d, int t){
        int valeurTab = 0;

        if(d ==1){
            if(c > 5){
                for(int indiceLigne = 0; indiceLigne < l; indiceLigne++){
                    for(int indiceColonne = c; indiceColonne > (c-t);indiceColonne-- ){
                        valeurTab+= grille[indiceLigne][indiceColonne];
                    }
                }
            }
            else{
                for(int indiceLigne = 0; indiceLigne < l; indiceLigne++){
                    for(int indiceColonne = c; indiceColonne < (c+t);indiceColonne++  ){
                        valeurTab+= grille[indiceLigne][indiceColonne];
                    }
                }
            }
        }
        else{
            if(l > 5){
                for(int indiceLigne = l; indiceLigne > (l-t); indiceLigne--){
                    for(int indiceColonne = 0; indiceColonne < c; indiceColonne++){
                        valeurTab+= grille[indiceLigne][indiceColonne];
                    }
                }
            }
            else{
                for(int indiceLigne = l; indiceLigne > (l+t); indiceLigne++){
                    for(int indiceColonne = 0; indiceColonne < c; indiceColonne++){
                        valeurTab+= grille[indiceLigne][indiceColonne];

                    }
                }
            }
        }
        System.out.println(valeurTab);
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
        //En verticale
        System.out.println("L: "+ (l ) + " C: " + (c ) + " D: " +d);

        bato(l,c, d, 5);
        l = randRange(0, 10);
        c = randRange(0, 10);
        d = randRange(1, 3);

        System.out.println("L: "+ (l ) + " C: " + (c ) + " D: " +d);

        bato(l,c, d, 4);
        l = randRange(0, 10);
        c = randRange(0, 10);
        d = randRange(1, 3);

        System.out.println("L: "+ (l ) + " C: " + (c ) + " D: " +d);
        bato(l,c, d, 3);
//        l = randRange(0, 10);
//        c = randRange(0, 10);
//        d = randRange(1, 3);
//        bato(l,c, d, 3);
//        l = randRange(0, 10);
//        c = randRange(0, 10);
//        d = randRange(1, 3);
//        bato(l,c, d, 2);
//        l = randRange(0, 10);
//        c = randRange(0, 10);
//        d = randRange(1, 3);
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
                System.out.println("La ligne est: "+ (ligne + 1) + "\nColonne: " + (colonne + 1) + "\nDirection: " +direction);
            }
        }while(ok != true);
        //Si à la verticale

        if(direction == 1){
            if(colonne > 5){
                for(int i = 0; i < lngr; i++){
                    grilleOrdi[ligne][colonne - i] = lngr;
                }
            }
            else{
                for(int i = 0; i < lngr; i++){
                    grilleOrdi[ligne][colonne + i] = lngr;
                }
            }

        }
        else{
            if(ligne > 5){
                for(int i = 0; i < lngr; i++){
                    grilleOrdi[ligne - i][colonne ] = lngr;
                }
            }
            else{
                for(int i = 0; i < lngr; i++){
                    grilleOrdi[ligne + i][colonne ] = lngr;
                }
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

