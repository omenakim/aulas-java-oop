package com.fksoft.folha.pagamento.application;

import com.fksoft.folha.pagamento.application.domain.FolhaDePagamento;
import com.fksoft.folha.pagamento.application.domain.TodasAsFolhasDePagamentos;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FolhaDePagamentoServiceImpl implements FolhaDePagamentoService {

    private final Logger logger = Logger.getLogger(getClass());
    private final TodasAsFolhasDePagamentos todasAsFolhasDePagamentos;

    public FolhaDePagamentoServiceImpl(TodasAsFolhasDePagamentos todasAsFolhasDePagamentos) {
        this.todasAsFolhasDePagamentos = todasAsFolhasDePagamentos;
    }

    public void sincronizar()  {

        try {

            logger.info("Lendo as linhas da Planilha");
            List<FolhaDePagamento> folhas = todasAsFolhasDePagamentos.buscarTudo();

            for (FolhaDePagamento folha : folhas) {
                logger.info("Salvando dados atualizados na linha: " + folha.getId());
                todasAsFolhasDePagamentos.salvar(folha);
            }

        } catch (FileNotFoundException ex) {
            logger.error("Arquivo não encontrado");
        } catch (IOException e) {
            logger.error("Erro ao ler arquivo");
            e.printStackTrace();
        }

    }

}
