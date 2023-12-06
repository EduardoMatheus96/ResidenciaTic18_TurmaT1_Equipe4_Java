package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FalhaDistribuicao extends Falha {
    private List<Reparo> reparos;

    public FalhaDistribuicao(Imovel imovel, String descricao, LocalDate previsao) {
        super(imovel, descricao, previsao);
        this.reparos = new ArrayList<>();
    }

    public void adicionarReparo(Reparo reparo) {
        reparos.add(reparo);
    }
}
