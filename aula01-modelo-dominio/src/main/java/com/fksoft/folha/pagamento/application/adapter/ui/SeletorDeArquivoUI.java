package com.fksoft.folha.pagamento.application.adapter.ui;

import com.fksoft.folha.pagamento.application.FolhaDePagamentoService;
import com.fksoft.folha.pagamento.application.adapter.repository.FolhaDePagamentoRepositoryXLS;

import javax.swing.*;
import java.io.File;

public class SeletorDeArquivoUI extends JFrame {

    private final FolhaDePagamentoService folhaDePagamentoService;

    public SeletorDeArquivoUI(FolhaDePagamentoService folhaDePagamentoService) {
        this.folhaDePagamentoService = folhaDePagamentoService;
        abrirSeletorDeArquivos();
    }

    private void abrirSeletorDeArquivos() {
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FolhaDePagamentoRepositoryXLS.getInstancia().setArquivo(file);
            folhaDePagamentoService.sincronizar();
            JOptionPane.showMessageDialog(null, "Arquivo sincronizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao sincronizar arquivo!");
        }
    }

}
