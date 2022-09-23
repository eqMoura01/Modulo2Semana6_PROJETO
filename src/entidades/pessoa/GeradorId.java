package entidades.pessoa;

public class GeradorId {
    private static int id = 0;

    public static int gerarId() {
        return id++;
    }
}
