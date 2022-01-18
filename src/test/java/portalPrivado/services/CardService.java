package portalPrivado.services;

public class CardService {

    public String getValueCardCol(String col){

        String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"} ;
        int resCol = 0;
        int i;
        System.out.println("largo de columna: "+col.length());
        System.out.println("estamos imprimientod A:"+cols[0]);
        for( i = 0; i<cols.length; i++){
            System.out.println("estamos imprimientod letras:"+cols[i]);
            if(col.contains(cols[i])){
                resCol=i;
                System.out.println("valor de i: "+i);
                System.out.println("valor de i: "+cols[i]);
            }
        }
        System.out.println("valor a retornar: "+resCol);
        return String.valueOf(resCol);
    }
    public String getValueCardFila(String fila){

        String[] filas= {"1", "2", "3", "4", "5"};
        int resFil = 0;
        int j;
        System.out.println("largo de fila: "+fila.length());
        for(j=0; j<filas.length; j++){
            System.out.println("estamos imprimientod numeros:"+filas[j]);
            if(fila.contains(filas[j])){
                resFil=j;
                System.out.println("valor de i: "+j);
                System.out.println("valor de i: "+filas[j]);
            }
        }
        System.out.println("valor a retornar: "+resFil);
        return String.valueOf(resFil);
    }
}
