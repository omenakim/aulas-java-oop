package com.fksoft.folha.pagamento.adapter.repository;

import com.fksoft.folha.pagamento.application.domain.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FolhaDePagamentoRepositoryXLS implements TodasAsFolhasDePagamentos {

    private static FolhaDePagamentoRepositoryXLS instancia;
    private File arquivo;

    private FileInputStream arquivoEntrada;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet1;

    private FolhaDePagamentoRepositoryXLS() {
    }

    public static FolhaDePagamentoRepositoryXLS getInstancia() {
        if (instancia == null)
            instancia = new FolhaDePagamentoRepositoryXLS();
        return instancia;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public void salvar(FolhaDePagamento folhaDePagamento) throws IOException {

        abrirPlanilha();

        final Funcionario funcionario = folhaDePagamento.getInfoFuncionario();
        final PlanoDeSaude planoDeSaude = folhaDePagamento.getPlanoDeSaude();
        final IRRF irrf = folhaDePagamento.getIrrf();
        final INSS inss = folhaDePagamento.getInss();

        final Integer numeroDaLinha = folhaDePagamento.getId().intValue();
        final String[] celulas = {
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getCargo(),
                String.valueOf(folhaDePagamento.getSalario().getSalarioBruto()),
                String.valueOf(planoDeSaude.getValorDoDesconto()),
                String.valueOf(irrf.getAliquota()),
                String.valueOf(irrf.getValorDoDesconto()),
                String.valueOf(irrf.getParcelaDedutivel()),
                String.valueOf(inss.getAliquota()),
                String.valueOf(inss.getValorDoDesconto()),
                String.valueOf(folhaDePagamento.getTotalDeDescontos()),
                String.valueOf(folhaDePagamento.getSalario().getSalarioLiquido()),
        };

        final Row row = sheet1.getRow(numeroDaLinha + 1);

        for (int i = 0; i < celulas.length; i++) {
            Cell cell = row.createCell(i);
            if (verificarNumerico(celulas[i]))
                cell.setCellValue(Double.parseDouble(celulas[i]));
            else
                cell.setCellValue(celulas[i]);
        }

        escreverNaPlanilha();
        fecharPlanilha();

    }

    public List<FolhaDePagamento> buscarTudo() throws IOException {

        abrirPlanilha();

        List<FolhaDePagamento> folhas = new ArrayList<>();
        List<String[]> linhas = new ArrayList<>();

        final Iterator<Row> rows = sheet1.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() != 0) {
                final String[] celulas = new String[12];
                for (int i = 0; i < celulas.length; i++) {
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        cell.setCellType(CellType.STRING);
                        celulas[i] = cell.getStringCellValue();
                    } else {
                        celulas[i] = "";
                    }
                }
                linhas.add(celulas);
            }
        }

        for (int i = 0; i < linhas.size(); i++) {
            String[] celulas = linhas.get(i);
            folhas.add(new FolhaDePagamento(
                    new Long(i),
                    new Funcionario(
                            celulas[0],
                            celulas[1],
                            celulas[2]
                    ),
                    new Salario(Double.parseDouble(celulas[3]))
            ));
        }

        fecharPlanilha();

        return folhas;
    }

    private void abrirPlanilha() throws IOException {
        arquivoEntrada = new FileInputStream(arquivo);
        workbook = new HSSFWorkbook(arquivoEntrada);
        sheet1 = workbook.getSheetAt(0);
    }

    private void fecharPlanilha() throws IOException {
        if (arquivoEntrada == null)
            throw new IllegalStateException("Arquivo de Entrada está nulo");
        arquivoEntrada.close();
    }

    private void escreverNaPlanilha() throws IOException {
        if (workbook == null)
            throw new IllegalStateException("Workbook está nulo");
        FileOutputStream arquivoDeSaida =
                new FileOutputStream(arquivo);
        workbook.write(arquivoDeSaida);
        arquivoDeSaida.close();
    }

    public static boolean verificarNumerico(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
