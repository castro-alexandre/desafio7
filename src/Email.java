import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Email {
    
    public static List<Email> listaEmails = new ArrayList<>();

    private String nome;
    private List<String> mensagensRecebidas;
    private String mensagem;

    public Email(String nome) {
        this.nome = nome;
        this.mensagensRecebidas = new ArrayList<>();
        listaEmails.add(this);
    }

    public boolean enviar(Email email) {
        if (!this.mensagem.isEmpty() && listaEmails.contains(email)) {
            email.getMensagensRecebidas().add(this.mensagem);            
        }
        return false;
    }

    public void lerEmailsRecebidos() {
        for (String mensagem : this.mensagensRecebidas) {
            System.out.println(mensagem);
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getMensagensRecebidas() {
        return this.mensagensRecebidas;
    }

    public void setMensagensRecebidas(List<String> mensagensRecebidas) {
        this.mensagensRecebidas = mensagensRecebidas;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void escrever(String mensagem) {
        this.mensagem = mensagem;
    }

    public void escrever(String mensagem, Formatacao formatacao) {
        if (formatacao.equals(Formatacao.MAIUSCULO)) {
            this.mensagem = mensagem.toUpperCase();
        }
        if (formatacao.equals(Formatacao.MINUSCULO)) {
            this.mensagem = mensagem.toLowerCase();
        }
        if (formatacao.equals(Formatacao.CAMEL_CASE)) {
            String a[] = mensagem.split("\s");
            String resultado = "";
            for (String string : a) {
                String primLetra = string.substring(0,1).toUpperCase();
                resultado += primLetra + string.substring(1);
            }
            this.mensagem = resultado;
        }
        if (formatacao.equals(Formatacao.SEM_ACENTOS)) {
            String nfdNormalizedString = Normalizer.normalize(mensagem, Normalizer.Form.NFD); 
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            this.mensagem = pattern.matcher(nfdNormalizedString).replaceAll("");
        }
    }
}
