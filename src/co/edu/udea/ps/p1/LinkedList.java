package co.edu.udea.ps.p1;

public class LinkedList {

    private Node cabeza, ultimo;

    public LinkedList() {
        this.cabeza = new Node(0);
    }

    public Node primero(){
        return cabeza.getSiguiente();
    }

    public boolean vacia(){
        return primero() == null;
    }

    public void agregarNumero(double numero){
        Node nuevo = new Node(numero);
        if(vacia()){
            ultimo = nuevo;
            cabeza.setSiguiente(ultimo);
            cabeza.setNumero(cabeza.getNumero() + 1);
        }
        else{
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
            cabeza.setNumero(cabeza.getNumero() + 1);
        }
    }

    public double ultimoNumero(){
        double retorno = 0;
        if(!vacia())
        {
            retorno = ultimo.getNumero();
        }
        return retorno;
    }

    public double getSumatoria(){
        double sumatoria = 0;
        if(!vacia()){
            Node recorrer = primero();
            do {
                sumatoria = sumatoria + recorrer.getNumero();
                recorrer = recorrer.getSiguiente();
            }while(recorrer != null);
        }
        return sumatoria;
    }

    public int cantidadNumeros(){
        return (int) cabeza.getNumero();
    }
}
