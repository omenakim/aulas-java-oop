package com.fksoft.folha.pagamento;

import com.fksoft.folha.pagamento.application.FolhaDePagamentoService;
import com.fksoft.folha.pagamento.application.FolhaDePagamentoServiceImpl;
import com.fksoft.folha.pagamento.application.adapter.repository.FolhaDePagamentoRepositoryXLS;
import com.fksoft.folha.pagamento.application.adapter.ui.SeletorDeArquivoUI;
import com.fksoft.folha.pagamento.application.domain.FolhaDePagamentoRepository;

public class Aplicacao {

    public static void main(String[] args) {

        final FolhaDePagamentoRepository folhaDePagamentoRepository = FolhaDePagamentoRepositoryXLS.getInstancia();
        final FolhaDePagamentoService folhaDePagamentoService = new FolhaDePagamentoServiceImpl(folhaDePagamentoRepository);

        new SeletorDeArquivoUI(folhaDePagamentoService);

    }


}
