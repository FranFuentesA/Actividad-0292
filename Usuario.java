
import java.util.ArrayList;
public class Usuario
{

    //nombre del usuario
    private String nombreCompleto;
    //proteinas  ingeridas por el usuario
    private float proteinasIngeridas;
    //carbohidratos   ingeridas por el usuario
    private float carbohidratosIngeridos;
    //grasas ingeridas por el usuario
    private float grasasIngeridas;
    //calorias totales ingeridas por el usuario
    private float caloriasIngeridas;

    private Alimento masCalorias;

    private String nombreAlimento;
    //Coleccion de alimentos ingeridos por usuario
    private ArrayList<Alimento> listaAlimentos;

    /**
     *Constructor de la clase usuario
     */
    public Usuario (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;   
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        listaAlimentos = new ArrayList<Alimento>();
    }

    /**
     * Metodo utilizado para dar de comer al usuario
     */
    public void comer(Alimento alimentoQueCome, float gramosDelAlimento)
    {
        proteinasIngeridas = proteinasIngeridas + (alimentoQueCome.getProteinas() / 100 * gramosDelAlimento);
        carbohidratosIngeridos = carbohidratosIngeridos + (alimentoQueCome.getCarbohidratos() / 100 * gramosDelAlimento);
        grasasIngeridas = grasasIngeridas + (alimentoQueCome.getGrasas() / 100 * gramosDelAlimento);
        caloriasIngeridas = caloriasIngeridas + (alimentoQueCome.getCalorias() / 100 * gramosDelAlimento);

        if (masCalorias != null) {
            if (masCalorias.getCalorias() <= alimentoQueCome.getCalorias()){
                masCalorias = alimentoQueCome;
            }
        }
        else{
            masCalorias = alimentoQueCome;
        }
        listaAlimentos.add(alimentoQueCome);
    }

    /**
     * Metodo que muestra la informacion de lo ingerido por el usuario.
     */
    public void muestraDatos()
    {
        float totalNutrientes = (proteinasIngeridas + grasasIngeridas + carbohidratosIngeridos) / 100;
        String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasIngeridas;
        String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " +             carbohidratosIngeridos;
        String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasIngeridas;
        if (proteinasIngeridas > 0) {
            datosProteinas = datosProteinas + " (" + proteinasIngeridas / totalNutrientes + "%)";
        }
        if (carbohidratosIngeridos > 0) {
            datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosIngeridos / totalNutrientes + "%      )";
        }
        if (grasasIngeridas > 0) {
            datosGrasas = datosGrasas + " (" + grasasIngeridas / totalNutrientes + "%)";
        }
        System.out.println("Nombre:                                    " + nombreCompleto);
        System.out.println(datosProteinas);    
        System.out.println(datosCarbohidratos);
        System.out.println(datosGrasas);
        System.out.println("Calorias totales ingeridas:                " + caloriasIngeridas);  
    }

    /**
     * Metodo que devuelve el nombre de usuario
     */
    public String getNombreCompleto() 
    {
        return nombreCompleto;
    }

    /**
     * Metodo que devuelve las calorias que ha ingerido el usuario
     */
    public float getCaloriasIngeridas() 
    {
        return caloriasIngeridas;
    }

    /**
     * Metodo que compara dos usuarios y muestra cual a consumido mas calorias, o si han consumido las mismas
     */
    public void comparaCalorias (Usuario otroUsuario)
    {
        if (caloriasIngeridas > otroUsuario.getCaloriasIngeridas()){
            System.out.println(nombreCompleto + " ha consumido más calorias que "+ otroUsuario.getNombreCompleto()+ "(" + caloriasIngeridas + " frente a " + otroUsuario.getCaloriasIngeridas() + ")");
        }

        else if (caloriasIngeridas < otroUsuario.getCaloriasIngeridas()){
            System.out.println(otroUsuario.getNombreCompleto()+ " ha consumido más calorias que "+ nombreCompleto + "(" + caloriasIngeridas + " frente a " + otroUsuario.getCaloriasIngeridas() + ")");
        }

        else {
            System.out.println(nombreCompleto + " ha consumido las mismas calorias que " + otroUsuario.getNombreCompleto() + "(" + caloriasIngeridas + " frente a " + otroUsuario.getCaloriasIngeridas() + ")");
        }
    }

    /**
     * 
     */
    public void AlimetoMasCalorico(){
        if (masCalorias != null) {
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: " + masCalorias.getNombre() + "(" +  masCalorias + " calorias por cada 100 gramos" + ")");
        } else {
            System.out.println("No ha consumido ningun alimento"); 

        }
    }

    /**
     * Metodo que permite visualizar los datos de los alimentos que ha ingerido el usuario y mostrar por pantalla indicando su posicion.
     */
    public void mostrarDatosNutricionales(int index)    {

        if ((index >= 1) && (index <= listaAlimentos.size()))
        {
            int cambioPosicion = index - 1;
            Alimento alimentoIndice = listaAlimentos.get(cambioPosicion);
            alimentoIndice.muestraDatos();
        } else {
            System.out.println("Indice no valido");
        }
    }

    /**
     * Metodo que permite pasar como parametro el nombre de un alimento e indique si el usuario ha comido ese alimento mas de una vez
     */
    public void comprobarAlimento(String nAlimento)
    {
        int contador = 0;
        for (Alimento alimentoX : listaAlimentos){
            if (alimentoX.getNombre().contains(nAlimento) ){         
                System.out.println("Ha comido " + nAlimento);  
                contador++;
            }
        }
        if (contador > 1 ) {
            System.out.println("Un total de " + contador + " veces");
        } else if (contador >0 && contador < 2) {
            System.out.println("Ha consumido el alimento solo una vez");
        } else if (contador == 0) {
            System.out.println("No ha consumido alimentos");
        }

    }
}
