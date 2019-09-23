package com.fksoft.folha.pagamento;

import com.fksoft.folha.pagamento.application.FolhaDePagamentoService;
import com.fksoft.folha.pagamento.application.FolhaDePagamentoServiceImpl;
import com.fksoft.folha.pagamento.adapter.repository.FolhaDePagamentoRepositoryXLS;
import com.fksoft.folha.pagamento.adapter.ui.SeletorDeArquivoUI;
import com.fksoft.folha.pagamento.application.domain.TodasAsFolhasDePagamentos;

public class Main {

    public static void main(String[] args) {

        final TodasAsFolhasDePagamentos todasAsFolhasDePagamentos = FolhaDePagamentoRepositoryXLS.getInstancia();
        final FolhaDePagamentoService folhaDePagamentoService = new FolhaDePagamentoServiceImpl(todasAsFolhasDePagamentos);

        new SeletorDeArquivoUI(folhaDePagamentoService);

    }


}
