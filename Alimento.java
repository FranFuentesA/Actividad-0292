/**
 * Write a description of class Alimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    //Guarda el nombre del alimento
    private String nombre;
    //Guarda las proteínas del alimento
    private float proteinas;
    //Guarda los carbohidratos del alimento
    private float carbohidratos;
    //Guarda las grasas del alimento
    private float grasas;
    //Guarda las calorias del alimento
    private float calorias;
    /**
     * Constructor for objects of class Alimento
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        calorias = (proteinas * 4) + (carbohidratos * 4) + (grasas * 9);
    }
    
    /**
     * Nos devuelve los gramos de proteinas que tiene el alimento
     */
    public float getProteinas() 
    {
        return proteinas;
    }
    
    /**
     * Nos devuelve los gramos de grasas que tiene el alimento
     */
    public float getGrasas() 
    {
        return grasas;
    }
    
    /**
     * Nos devuelve los gramos de carbohidratos que tiene el alimento
     */
    public float getCarbohidratos() 
    {
        return carbohidratos;
    }
    
    /**
     * Nos devuelve las calorías que tiene el alimento
     */
    public float getCalorias() 
    {
        return calorias;
    }
    /**
     * Nos devuelve las calorías que tiene el alimento
     */
    public String getNombre() 
    {
        return nombre;
    }
    /**
     * Este método nos muestra los valores de los distintos componentes del alimento 
     */
    public void muestraDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Proteinas por cada 100 gramos: " + proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + carbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + grasas);
        System.out.println("Calorias: " + calorias);
        String mayoritario = "proteínas";
        float mayor = proteinas;
        if (carbohidratos == mayor) {
            mayoritario = "carbohidratos, proteínas";
        }
        else if (carbohidratos > mayor) {
            mayor = carbohidratos;
            mayoritario = "carbohidratos";
        }
        if (grasas == mayor) {
            mayoritario = "grasas, " + mayoritario;
        }
        else if (grasas > mayor) {
            mayoritario = "grasas";
        }
        System.out.println("Componente/s mayoritario/s: " + mayoritario);
    }
    
}