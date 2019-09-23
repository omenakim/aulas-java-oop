package com.fksoft.folha.pagamento.application.domain;

public class FolhaDePagamento {

    private Long id;
    private Funcionario infoFuncionario;
    private Salario salario;
    private PlanoDeSaude planoDeSaude;
    private IRRF irrf;
    private INSS inss;
    private Double totalDeDescontos;

    public FolhaDePagamento(Long id, Funcionario infoFuncionario, Salario salario) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo.");
        if (infoFuncionario == null)
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        if (salario == null)
            throw new IllegalArgumentException("Salário não pode ser nulo.");
        this.id = id;
        this.infoFuncionario = infoFuncionario;
        this.salario = salario;

        this.calcularDesconto();
    }

    private void calcularDesconto() {
        // Criação de instancias
        planoDeSaude = new PlanoDeSaude();
        inss = new INSS();
        irrf = new IRRF();

        // Comecar os calculos
        planoDeSaude.calcular(salario.getSalarioBruto());
        inss.calcular(salario.getSalarioBruto());
        irrf.calcular(salario.getSalarioBruto() - inss.getValorDoDesconto());

        // Settar salario liquido na instancia de salario
        totalDeDescontos = planoDeSaude.valorDoDesconto + inss.getValorDoDesconto() + irrf.getValorDoDesconto();
        Double valorSalarioLiquido = salario.getSalarioBruto() - totalDeDescontos;
        salario.setSalarioLiquido(valorSalarioLiquido);

    }

    public Long getId() {
        return id;
    }

    public Funcionario getInfoFuncionario() {
        return infoFuncionario;
    }

    public Salario getSalario() {
        return salario;
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public IRRF getIrrf() {
        return irrf;
    }

    public INSS getInss() {
        return inss;
    }

    public Double getTotalDeDescontos() {
        return totalDeDescontos;
    }
}
