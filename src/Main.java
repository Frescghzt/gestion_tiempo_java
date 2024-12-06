import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //creacion scanner
        Scanner input = new Scanner(System.in);
        ArrayList<Datos> materiasUsar = new ArrayList<>();

        //bienvenida programa
        System.out.println(" ██████╗ ███████╗███████╗████████╗██╗ ██████╗ ███╗   ██╗    ██████╗ ███████╗    ████████╗██╗███████╗███╗   ███╗██████╗  ██████╗ ");
        System.out.println("██╔════╝ ██╔════╝██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║    ██╔══██╗██╔════╝    ╚══██╔══╝██║██╔════╝████╗ ████║██╔══██╗██╔═══██╗");
        System.out.println("██║  ███╗█████╗  ███████╗   ██║   ██║██║   ██║██╔██╗ ██║    ██║  ██║█████╗         ██║   ██║█████╗  ██╔████╔██║██████╔╝██║   ██║");
        System.out.println("██║   ██║██╔══╝  ╚════██║   ██║   ██║██║   ██║██║╚██╗██║    ██║  ██║██╔══╝         ██║   ██║██╔══╝  ██║╚██╔╝██║██╔═══╝ ██║   ██║");
        System.out.println("╚██████╔╝███████╗███████║   ██║   ██║╚██████╔╝██║ ╚████║    ██████╔╝███████╗       ██║   ██║███████╗██║ ╚═╝ ██║██║     ╚██████╔╝");
        System.out.println(" ╚═════╝ ╚══════╝╚══════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝    ╚═════╝ ╚══════╝       ╚═╝   ╚═╝╚══════╝╚═╝     ╚═╝╚═╝      ╚═════╝ ");
        
        //pedida de semestre y aclaracion
        System.out.println("Ingrese el semestre en el que se encuentra");
        System.out.println("En este momento nos encontramos en fase de desarrollo por lo cual solo puede ingresar 1 o 2");

        //verifica que el semestre este en el rango
        int semestre;
        int diaActual = 0;
        while (true) {
            try {
                semestre= Integer.parseInt(input.nextLine());
                if (semestre> 0 && semestre < 3 ) {
                    break;
                }else{
                    System.out.println("Ingrese una entrada valida");
                }
            } catch (Exception error) {
                System.out.println("Ingrese una entrada valida");
            }
        }
        List<Datos> resultados = Datos .consultaPorSemestre(semestre);
        if (resultados.isEmpty()) {
            System.out.println("yaper");   
        }else{
            ArrayList<Datos> materias = new ArrayList<>(resultados);
            
            
        while (true) {
            try {
                System.out.println("Ingrese el dia en el que nos encontramos");
                diaActual = input.nextInt();
                if (diaActual>0 && diaActual<32) {
                    break;
                }else{
                    System.out.println("Ingrese un dato en el rango correcto");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un dato valido");
            }
        }

        boolean materiasa = true;
        while (materiasa) {
        System.out.println("¿Que materia decea ingresar?");
        int i = 1;
        int codeMateriasElegir=0;
        for(Datos dato : materias){
            System.out.println(i+" "+dato.getNombre());
            i++;
        } 
        try {
            codeMateriasElegir = input.nextInt();
            if (codeMateriasElegir>0 && codeMateriasElegir < materias.size()) {
                
            }
        } catch (Exception e) {
            System.out.println("Ingrese un dato valido");
        }
        Datos objetoSeleccionado = materias.remove(codeMateriasElegir-1);
        materiasUsar.add(objetoSeleccionado);
        
            
            try {
                System.out.println("¿Desea ingresar otra materia (y/n)?");
            input.nextLine();
            String ingresar = input.nextLine();
            if (!ingresar.equalsIgnoreCase("y")) {
                break;
            }
            
            } catch (Exception e) {
            System.out.println("Ingrese un caracter valido ");
            }
        }
        final int DIAMAXMES = 31;
        int examen;
        for(Datos numerito : materiasUsar){
            
            
            while (true) {
                try {
                    System.out.println("Para la materia "+numerito.getNombre()+" ingrese que dia tiene el examen");
                    examen= input.nextInt();
                    numerito.setDiaExamen(examen);
                    if (numerito.getDiaExamen() > diaActual && numerito.getDiaExamen() <= DIAMAXMES) {
                        break;   
                    }else{
                        System.out.println("Ingrese un dato valido");
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese un dato valido");
                }
            }

        }
        }

        int horasEstudioDia ;
        while (true) {
            System.out.println("Ingrese la cantidad de horas que va a estudiar al dia");
            try {
                horasEstudioDia = input.nextInt();
                if (horasEstudioDia > 0 && horasEstudioDia <25) {
                    break;
                }else{
                    System.out.println("Ingrese un rango valido");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un dato valido");
            }

        }

        Collections.sort(materiasUsar,Comparator.comparingInt(Datos::getDiaExamen));
        int tamañoMateria = materiasUsar.size()-1;
        Datos ultimo = materiasUsar.get(tamañoMateria);
        int diasEstudio = ultimo.getDiaExamen()-diaActual;
        int horasEstudioTotal = diasEstudio*horasEstudioDia;
        int creditosTotales = 0;
        for(Datos kiki : materiasUsar){
            creditosTotales += kiki.getCreditos();
        }
        double temporal; 
        for (Datos ksrp : materiasUsar ){
            temporal = (double)ksrp.getCreditos()/creditosTotales;
            System.out.println(temporal);
            ksrp.setPorsentaje(temporal);
            
        }
        for(Datos ksrp : materiasUsar){
            temporal = ksrp.getPorsentaje()*horasEstudioTotal;
            ksrp.setHorasSemanales(temporal);
        }
        
        int tiempito;
        for(Datos ksrp : materiasUsar){
            System.out.print("\033[H\033[2J");
            tiempito = (int)ksrp.getHorasSemanales();
            System.out.println("Para la materia "+ksrp.getCodigo()+" " +ksrp.getNombre());
            System.out.println("Se recomienda que a la semana se estudien "+tiempito);
            System.out.println("quieres ver el metodo de estudio principal (y/n)");
            input.nextLine();
            String xd = input.nextLine();
            if (xd.equals("y")) {
                while (true) {
                    System.out.println("Te recomendamos que como metodo de estudio uses ");
                    System.out.println(ksrp.getMetodo_estudio());
                    System.out.println("deceas seguir(y)");
                    String quesero = input.nextLine();
                    if (quesero.equals("y")) {
                        break;
                    }
                }
            }
            System.out.println("deceas ver un metodo de estudio alternativo");
            xd = input.nextLine();
            if (xd.equals("y")) {
                while (true) {
                    System.out.println("Si no te sientes comodo con este metodo de estudio puedes usar este");
            System.out.println(ksrp.getMetodo_estudio_alternativo());
                    System.out.println("deceas seguir(y)");
                    String quesero = input.nextLine();
                    if (quesero.equals("y")) {
                        break;
                    }
            }
            System.out.println("deceas ver herramientas que te pueden ayudar");
            xd = input.nextLine();
            if (xd.equals("y")) {
                while (true) {
                    System.out.println("Algunas herramientas que pueden facilitar y optimizar tu proceso de estudio son las siguientes:");
                    System.out.println(ksrp.getHerramienta_de_estudio());
                    System.out.println("deceas seguir(y)");
                    String quesero = input.nextLine();
                    if (quesero.equals("y")) {
                        break;
                    }
                }
            
            }
            System.out.println("decea ver la siguiente materia(y)");
            xd=input.nextLine();
            
    } 
      
}
input.close();
}
}