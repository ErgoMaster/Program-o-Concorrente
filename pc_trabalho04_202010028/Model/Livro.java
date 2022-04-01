package Model;

import java.util.Stack;

public class Livro {
    private int id;

    public Livro(Stack<Livro> pilha) {
        id = pilha.size() + 1;
    }

    public int getID() { return id; }
}
