public class App {
    public static void main(String[] args) throws Exception {
        
        Email email1 = new Email("francisco@algo.com");
        Email email2 = new Email("alexandre@algo.com");

        String texto = "Quão o céu está azul hoje.";

        email1.escrever(texto);
        email1.enviar(email2);

        email1.escrever(texto, Formatacao.CAMEL_CASE);
        email1.enviar(email2);

        email1.escrever(texto, Formatacao.MAIUSCULO);
        email1.enviar(email2);

        email1.escrever(texto, Formatacao.MINUSCULO);
        email1.enviar(email2);

        email1.escrever(texto, Formatacao.SEM_ACENTOS);
        email1.enviar(email2);

        for (String string : email2.getMensagensRecebidas()) {
            System.out.println(string);
        }
    }
}
