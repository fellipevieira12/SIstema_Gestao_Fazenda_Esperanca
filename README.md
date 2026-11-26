# Registro de Uso de IA Generativa - Entrega 3 (Formulário e Refinamento)

**Nome do Aluno:** Fellipe Augusto Arêas Vieira
**Projeto:** Sistema de Gestão Fazenda Esperança
**Ferramenta de IA Utilizada:** Google Gemini

## 1. Mapeamento de Uso
A Inteligência Artificial foi utilizada como apoio na etapa final de refinamento da interface web, auxiliando na implementação do atalho de acessibilidade (`skip-link`) nas 4 páginas HTML (`index.html`, `talhoes.html`, `equipe.html` e `frota.html`), na aplicação dos atributos nativos de validação de formulários do HTML5 (`pattern`, `type="email"`, `minlength`, `min`, `max`, `step`) e na estilização dos estados de validação (`:user-invalid` e `:valid`) no arquivo `html/css/style.css`.

## 2. Prompts Utilizados
Durante o desenvolvimento da Entrega 3, foram utilizados os seguintes comandos na ferramenta:
1. "do ponto que paramos, o que falta para ficar completo? [anexo: Projeto Integrador_2.pdf]"
2. "2. Adicionar o 'Skip Link' (Acessibilidade) sobre esse, vou te mandar os codigos, poderia aplicar para mim?"
3. "[código do index.html]"
4. "[código do style.css] aonde?"
5. "aplique ela no codigo e mande ele todo arrumado, sem comentarios"
6. "[código do equipe.html]"
7. "[código do frota.html]"
8. "[código do style.css] corrija"
9. "[código do talhoes.html]"
10. "[texto do Registro de Uso de IA da Entrega 2] ajuste"

## 3. Justificativa das Decisões Técnicas (Acessibilidade, Responsividade e Validação)
* **Abordagem Mobile-First:** Mantida a estrutura base voltada para dispositivos móveis (até 480px) com expansão via `@media (min-width: ...)` para tablet (~768px) e desktop (~1200px+), garantindo integridade visual e legibilidade dos formulários em todas as resoluções.
* **Acessibilidade:** Implementado o `skip-link` oculto visualmente (`top: -100px`) e visível ao receber foco via teclado (`Tab`), direcionando diretamente ao `<main id="conteudo-principal">`, somado ao contraste superior a 4.5:1 validado na paleta `:root`.
* **Validação Nativa HTML5:** Utilizados recursos nativos sem dependência de JavaScript (`required`, `type="email"`, `pattern` com regex e `title` descritivo) para bloquear submissões inválidas diretamente pelo navegador.

## 4. Revisão Técnica (Modificações Realizadas no Código Gerado)
Abaixo estão detalhadas 3 modificações técnicas realizadas manualmente nos arquivos gerados pela IA:

- **Modificação 1: Correção do seletor universal de reset no CSS (`*`)**
  - **O que a IA gerou:** Na versão anterior do `style.css`, o bloco de reset global estava definido com um hífen (`- { box-sizing: border-box; ... }`).
  - **O que foi alterado:** Substituí o hífen pelo seletor universal correto `* { box-sizing: border-box; margin: 0; padding: 0; }`.
  - **Por que foi alterado (Justificativa):** O navegador ignorava a regra inválida com hífen, fazendo com que os inputs e containers somassem `padding` e `border` às larguras de 100%, o que causava estouro horizontal (quebra de layout) no breakpoint mobile de 480px.

- **Modificação 2: Inclusão de `input[type="email"]` na regra de estilização dos formulários**
  - **O que a IA gerou:** A regra de estilo base dos campos de formulário no `style.css` contemplava apenas `input[type="text"]`, `input[type="number"]`, `select` e `textarea`.
  - **O que foi alterado:** Adicionei o seletor `input[type="email"]` à regra compartilhada de largura, espaçamento interno (`padding: 0.65rem`) e bordas no `style.css` após criar o campo de e-mail do responsável técnico em `frota.html`.
  - **Por que foi alterado (Justificativa):** Sem a inclusão explícita desse seletor, o campo de e-mail mantinha a aparência padrão do navegador, quebrando a uniformidade visual e a largura do grid de 2 colunas nos breakpoints de tablet e desktop.

- **Modificação 3: Ajuste das expressões regulares (`pattern`) e limites numéricos aos dados reais do sistema**
  - **O que a IA gerou:** Atributos genéricos de validação nos formulários e campos sem restrição de formato ou casas decimais.
  - **O que foi alterado:** Defini o padrão `^OS-[0-9]{4}$` para o código de Ordem de Serviço em `frota.html` e configurei `min="0.5"`, `max="1000"` e `step="0.1"` no campo de hectares em `talhoes.html`, além de vincular feedback visual com `:user-invalid`.
  - **Por que foi alterado (Justificativa):** Para garantir que a validação nativa do navegador impeça entradas incompatíveis com a estrutura de dados do sistema (como áreas negativas ou códigos de ordem fora do padrão operacional da fazenda) antes mesmo de qualquer processamento.