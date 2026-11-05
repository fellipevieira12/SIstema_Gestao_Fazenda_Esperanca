# Registo de Uso de IA Generativa - Entrega 1

**Nome do Aluno:** Fellipe Augusto Arêas Vieira
**Projeto:** Sistema de Gestão Fazenda (Cooperativa Vale Verde)
**Ferramenta de IA Utilizada:** Google Gemini

## 1. Mapeamento de Uso
A Inteligência Artificial foi utilizada como ferramenta de apoio à prototipagem para gerar a estrutura inicial e a marcação semântica das 4 páginas HTML exigidas nesta entrega (`index.html`, `talhoes.html`, `equipe.html` e `frota.html`). A IA auxiliou na aplicação correta das tags do HTML5 (header, nav, main, section, article, footer), na implementação do checklist de acessibilidade (atributos aria, escopo de tabelas) e na construção das tabelas e formulários iniciais.

## 2. Prompts Utilizados
Durante o processo de desenvolvimento, foram fornecidos prints da estrutura de pastas do projeto em Java e introduzidos os seguintes comandos principais na ferramenta:
1. "preciso de ajudar para fazer esse trabalho, ja tenho uma projeto comecado, vou te mandar como esta modularizado [imagem do PDF da entrega]"
2. "[imagem da árvore de pastas do VS Code com os ficheiros CSV e classes Java]"
3. "vou fazer com esse praticamente do zero, nao tem nada de html [imagem da árvore de pastas]"
4. "esta bom, mas muito simples teria como melhorar um pouco?"
5. "me explique [imagem com regras de submissão do GitHub]"

## 3. Revisão Técnica (Modificações Realizadas no Código Gerado)
Abaixo detalho 3 intervenções técnicas que realizei manualmente no código gerado pela IA para o adaptar à realidade arquitetural do meu projeto:

* **Modificação 1: Adaptação dos atributos dos Formulários (Módulo Talhões)**
  * **O que a IA gerou:** Um formulário no ficheiro `talhoes.html` com atributos `name` e `id` genéricos nos inputs (ex: `nomeTalhao`, `hectares`).
  * **O que foi alterado:** Ajustei os valores do atributo `name` de todos os formulários para corresponderem exatamente aos nomes dos atributos definidos na minha classe `Talhao.java` no back-end.
  * **Por que foi alterado (Justificativa):** Para garantir que, nas próximas entregas, a extração de dados do formulário e a sua serialização (gravação) para o ficheiro `talhoes.csv` ocorra sem erros de mapeamento entre o front-end e o back-end em Java.

* **Modificação 2: Alinhamento das Tabelas com os Ficheiros CSV (Módulo Equipe e Frota)**
  * **O que a IA gerou:** Tabelas HTML estáticas de demonstração para listar funcionários e tratores, com colunas e dados fictícios de exemplo.
  * **O que foi alterado:** Modifiquei os cabeçalhos (`<th>`) e a estrutura do corpo da tabela (`<tbody>`) para refletirem estritamente as colunas existentes nos meus ficheiros de persistência `funcionarios.csv` e `frota.csv` localizados na pasta `banco/`.
  * **Por que foi alterado (Justificativa):** A semântica da tabela tem de estar preparada para a futura injeção dinâmica de dados. Se o front-end tiver colunas diferentes da base de dados (CSV), o sistema de leitura em Java irá quebrar a formatação visual quando os dados reais forem carregados.

* **Modificação 3: Ajuste da Semântica e Hierarquia de Headings para Acessibilidade**
  * **O que a IA gerou:** O ficheiro `index.html` utilizava a tag `<aside>` e a tag `<details>` de forma isolada, gerando um salto na estrutura lógica de acessibilidade caso um leitor de ecrã lesse os cabeçalhos.
  * **O que foi alterado:** Reorganizei a hierarquia dos títulos, garantindo que o `<h3>` dentro do `<aside>` dependesse estruturalmente do `<h2>` da secção principal correspondente, e adicionei atributos `aria-label` mais descritivos nos landmarks de navegação.
  * **Por que foi alterado (Justificativa):** Para cumprir estritamente o critério do checklist de acessibilidade do projeto, que exige uma hierarquia lógica de cabeçalhos sem saltos e navegação semântica previsível para dispositivos de assistência.