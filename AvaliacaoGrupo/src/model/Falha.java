import java.time.LocalDate;

public class Falha {
    private Imovel imovel;
    private String descricao;
    private LocalDate previsao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Falha(Imovel imovel, String descricao, LocalDate previsao) {
        this.imovel = imovel;
        this.descricao = descricao;
        this.previsao = previsao;
    }
}