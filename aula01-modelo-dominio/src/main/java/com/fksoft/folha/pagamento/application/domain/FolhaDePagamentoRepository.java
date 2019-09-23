package com.fksoft.folha.pagamento.application.domain;

import java.io.IOException;
import java.util.List;

public interface FolhaDePagamentoRepository {

    void salvar(FolhaDePagamento folhaDePagamento) throws IOException;

    List<FolhaDePagamento> buscarTudo() throws IOException;

}
