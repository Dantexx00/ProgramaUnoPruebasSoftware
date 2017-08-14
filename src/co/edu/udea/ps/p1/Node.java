package co.edu.udea.ps.p1;

public class Node {

    private double numero;
    private Node siguiente;

    public Node(double numero) {
        this.numero = numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }

    public double getNumero() {
        return numero;
    }

    public Node getSiguiente() {
        return siguiente;
    }
}
