package com.fksoft.folha.pagamento.application.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FuncionarioTest.class,
        SalarioTest.class,
        PlanoDeSaudeTest.class,
        INSSTest.class,
        IRRFTest.class,
        FolhaDepagamentoTest.class
})
public class DomainTestSuite {
}
