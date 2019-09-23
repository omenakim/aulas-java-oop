package com.fksoft.folha.pagamento.application;

import com.fksoft.folha.pagamento.application.domain.FolhaDePagamento;
import com.fksoft.folha.pagamento.application.domain.FolhaDePagamentoRepository;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FolhaDePagamentoServiceImpl implements FolhaDePagamentoService {

    private final Logger logger = Logger.getLogger(getClass());
    private final FolhaDePagamentoRepository folhaDePagamentoRepository;

    public FolhaDePagamentoServiceImpl(FolhaDePagamentoRepository folhaDePagamentoRepository) {
        this.folhaDePagamentoRepository = folhaDePagamentoRepository;
    }

    public void sincronizar()  {

        try {

            logger.info("Lendo as linhas da Planilha");
            List<FolhaDePagamento> folhas = folhaDePagamentoRepository.buscarTudo();
            for (FolhaDePagamento folha : folhas) {
                logger.info("Salvando dados atualizados na linha: " + folha.getId());
                folhaDePagamentoRepository.salvar(folha);
            }

        } catch (FileNotFoundException ex) {
            logger.error("Arquivo não encontrado");
        } catch (IOException e) {
            logger.error("Erro ao ler arquivo");
            e.printStackTrace();
        }

    }

}
