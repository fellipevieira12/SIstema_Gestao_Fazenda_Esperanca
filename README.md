# Registro de Uso de IA Generativa - Entrega 2 (Estilo e Responsividade)

**Nome do Aluno:** Fellipe Augusto Arêas Vieira
**Projeto:** Sistema de Gestão Fazenda Esperança
**Ferramenta de IA Utilizada:** Google Gemini

## 1. Mapeamento de Uso
A Inteligência Artificial foi utilizada como apoio na criação da folha de estilos externa (`html/css/style.css`), auxiliando na definição das variáveis CSS (`:root`), na estruturação dos layouts com Flexbox e CSS Grid, na configuração dos 3 breakpoints de responsividade (mobile, tablet e desktop) e na implementação de estilos de foco para acessibilidade via teclado.

## 2. Prompts Utilizados
Durante o desenvolvimento da Entrega 2, foram utilizados os seguintes comandos na ferramenta:
1. "[imagem com requisitos da Entrega 2 — Estilo e Responsividade]"
2. "o passo 1 tem que ser feito em quais modulos?"
3. "qual o proximo"
4. "Quer que eu prepare o modelo do Registro_Uso_IA.md para a Entrega 2 ou prefere testar primeiro o visual das páginas no navegador? sim"

## 3. Justificativa da Abordagem de Design Responsivo
Foi adotada a abordagem **Mobile-First**, estruturando os estilos base para telas de até 480px (menu empilhado, tabelas com rolagem horizontal e formulários em coluna única) e expandindo progressivamente por meio de `@media (min-width: ...)` para tablet (~768px) e desktop (~1200px+). Essa escolha garante legibilidade e integridade visual em dispositivos móveis sem sobrecarga de regras de sobrescrita.

## 4. Revisão Técnica (Modificações Realizadas no Código Gerado)
Abaixo estão detalhadas 3 modificações técnicas realizadas manualmente nos arquivos gerados pela IA:

* **Modificação 1: Remoção de atributos de estilização inline no HTML (`border="1"`)**
  * **O que a IA gerou:** Na Entrega 1, as tabelas dos arquivos `index.html` e `equipe.html` possuíam o atributo `border="1"` diretamente na tag `<table>`.
  * **O que foi alterado:** Removi o atributo `border="1"` das tags HTML e transferi o controle visual de bordas e espaçamentos exclusivamente para o arquivo `html/css/style.css` usando `border-collapse: collapse` e variáveis CSS.
  * **Por que foi alterado (Justificativa):** Para manter a separação estrita de responsabilidades entre estrutura (HTML) e apresentação (CSS), evitando conflitos de especificidade e garantindo consistência visual em todos os breakpoints.

* **Modificação 2: Ajuste do seletor de Grid na seção principal do Dashboard (`index.html`)**
  * **O que a IA gerou:** Uma regra CSS genérica (`main section:first-child { display: grid; ... }`) aplicada a todas as páginas que importam o `style.css`.
  * **O que foi alterado:** Adicionei uma classe específica (`.grid-dashboard`) apenas na primeira `<section>` do `index.html` e direcionei a regra de CSS Grid de 2 colunas exclusivamente para essa classe no breakpoint de desktop (`min-width: 1200px`).
  * **Por que foi alterado (Justificativa):** Nas páginas `talhoes.html`, `equipe.html` e `frota.html`, a primeira seção contém apenas um formulário ou tabela única; aplicar um grid de 2 colunas genérico deixava metade da largura da tela vazia nesses módulos.

* **Modificação 3: Validação e ajuste de contraste na paleta de cores (`:root`)**
  * **O que a IA gerou:** Um tom de verde claro (`--cor-destaque: #d8f3dc`) utilizado como fundo de itens ativos no menu de navegação (`nav a[aria-current="page"]`) e links no rodapé.
  * **O que foi alterado:** Verifiquei o contraste no WebAIM Contrast Checker e ajustei o texto do item ativo no menu para `--cor-primaria` (`#1b4332`) sobre o fundo `--cor-destaque`, garantindo uma taxa de contraste superior a 10:1.
  * **Por que foi alterado (Justificativa):** Para atender rigorosamente ao requisito de acessibilidade do projeto, que exige contraste mínimo de 4.5:1 entre texto e plano de fundo em todos os estados visuais da interface.