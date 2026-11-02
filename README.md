# PROMPT DE CRIACAO DOS DELEGATES
```text
Aja como um Arquiteto de Software Java Especialista. Refatore/Crie a classe Delegate fornecida com base no Controller do Spring Boot anexado, seguindo estritamente as regras abaixo:

1. ESTRUTURA E TESTABILIDADE:
- Utilize injeção via construtor (oferecendo um construtor default instanciando HttpClient e Gson, e outro construtor recebendo HttpClient e Gson para facilitar testes unitários/mocks).
- Utilize a biblioteca Lombok com @Slf4j para geração de logs.

2. MÉTODOS E ASSINATURA:
- Espelhe todos os endpoints expostos no Controller no Delegate correspondente.
- Todos os métodos devem retornar o próprio registro generificado `ApiResponse<T>` correspondente ao retornado pelo backend.
- Para desserializar listas, generics ou wrappers como `ApiResponse<List<DTO>>` ou `ApiResponse<DTO>`, utilize `com.google.code.gson.reflect.TypeToken`.

3. LOGS E TEMPO DE EXECUÇÃO:
- Centralize a execução das requisições em um método privado genérico (`executarRequisicao`).
- Registre log INFO no início e no fim de cada método/serviço, informando o nome do serviço chamado, o status HTTP retornado e o tempo decorrido em milissegundos.

4. TRATAMENTO DE EXCEÇÕES:
- Envolva as requisições em um bloco try-catch.
- Em caso de exceção de I/O ou conexão, registre log ERROR com a stacktrace/mensagem e retorne uma instância do `ApiResponse` padrão contendo status 500 e a mensagem de falha de comunicação.

5. TESTES UNITARIOS:
- A codificação da classe dever ser feita de maneira a possibilitar a criação de testes unitarios com 100% de cobertura.
- Crie a classe de testes unitários.

Entregue apenas o código Java totalmente pronto e funcional para produção.
```
---

# PROMPT DE CRIACAO DOS TESTES
```text
Aja como um Arquiteto de Software Java Especialista e Desenvolvedor Sênior. Crie a classe de teste unitário utilizando JUnit 5 e Mockito para a classe Java fornecida, garantindo 100% de cobertura de código.

Siga estritamente as regras abaixo:

1. CONFIGURAÇÃO E MOCKING:
- Utilize JUnit 5 (@ExtendWith(MockitoExtension.class)) e anotações do Mockito (@Mock, @InjectMocks) para isolar todas as dependências externas da classe testada.
- Garanta a cobertura de todos os construtores da classe (tanto o construtor padrão quanto os construtores com injeção de dependências).

2. CASOS DE USO E SUCESSO:
- Crie métodos de teste para cada método público da classe.
- Simule os retornos das dependências utilizando when(...).thenReturn(...) cobrindo os caminhos felizes (sucesso).
- Utilize assertivas robustas (JUnit Assertions) para validar os resultados obtidos, objetos retornados e estados esperados.
- Utilize verify(...) para garantir que as dependências essenciais foram chamadas corretamente durante a execução.

3. TRATAMENTO DE EXCEÇÕES E CENÁRIOS DE ERRO:
- Crie testes específicos para validar cenários de exceções (tanto exceções de negócio customizadas quanto falhas inesperadas, como RuntimeException).
- Utilize assertThrows quando o método testado precisar lançar uma exceção, ou valide o comportamento de fallback/retorno de erro caso a classe trate a exceção internamente.

Entregue apenas o código Java da classe de teste limpo, estruturado, semântico e pronto para execução.
```
---

# PROMPT DE CRIACAO DOS TESTES DE INTEGRAÇÃO DOS DELEGATES
```text
Aja como um Arquiteto de Software Java Especialista e Desenvolvedor Sênior. Crie a classe de teste de integração para o Delegate fornecido, garantindo 100% de cobertura de todos os métodos públicos, construtores e cenários de tratamento de erro.

Siga estritamente as regras abaixo:

1. AMBIENTE DE TESTE COM HTTP SERVER NATIVO:
- Utilize o HttpServer nativo do Java (`com.sun.net.httpserver.HttpServer`) atrelado a uma porta aleatória (0) para simular requisições HTTP reais de ponta a ponta sem depender de uma API externa ativa.
- Suba e encerre o servidor embutido usando o ciclo de vida do JUnit 5 (`@BeforeEach` / `@AfterEach`).
- Injetar ou configurar a URL base dinâmica do servidor embutido no construtor do Delegate durante o teste.

2. COBERTURA TOTAL DOS MÉTODOS (100%):
- Crie um método de teste específico para cada operação do Delegate (ex: salvar, atualizar, deletar, buscarPorId, buscarPorNome, listarTodas, buscas por filtro/paginadas, etc.).
- Simule os payloads de resposta utilizando `JsonUtils.toJson()` e o padrão `ApiResponse`.
- Valide assertivamente o sucesso das operações (status HTTP 200, 201, etc.) e a exatidão dos dados retornados.

3. CENÁRIOS DE EXCEÇÃO E FALLBACK:
- Cubra o comportamento de erro do Delegate simulando retornos com códigos de erro HTTP ou quedas de comunicação (bloco catch/fallback).

Entregue apenas o código Java da classe de teste de integração limpo, padronizado, semanticamente correto e pronto para execução.

```
---

# PROMPT DE CRIACAO DOS JSPs
```text
Por favor, desenvolva o código da página JSP para a entidade [INSERIR_NOME_DO_PO_AQUI] seguindo rigorosamente as diretrizes e padrões arquiteturais do nosso projeto (Struts 1.3.10 + Apache Tiles):

1. Estrutura e Template:
   - A página será renderizada dentro do Template.jsp utilizando a tag <tiles:insert name="body" />.
   - Siga rigorosamente o padrão de CSS e estilização já incluído no template existente.

2. Divisão de Layout (HEADER, BODY e FOOTER):
   - HEADER: Deve conter o título da tela, derivado exatamente do nome da classe PO sem o sufixo "PO" (Ex: ClientePO -> Título: "Cliente").
   - BODY: 
     * No topo do BODY, exiba os 4 campos de auditoria em formato não editável (Labels: "Criado por:", "Criado em:", "Alterado por:", "Alterado em:").
     * Os campos de dados da entidade devem seguir estritamente o formato "LABEL CAMPO" (Ex: Nome: [campo aqui]).
     * Organização dos campos: em formato in-line (um na frente do outro) para monitores grandes, adaptando-se de forma responsiva para telas médias e pequenas (empilhados em coluna).
   - FOOTER:
     * Localização exclusiva para os botões de ação na seguinte ordem/padrão: Cadastrar, Alterar, Pesquisar, Excluir, Novo e Cancelar.

3. Tratamento de Mensagens:
   - As mensagens de SUCESSO e ERRO devem ser exibidas utilizando class="alert" integradas com as tags do Struts (org.apache.struts.action.ActionMessages).

Por favor, forneça o código completo e limpo do arquivo JSP correspondente.

```
---