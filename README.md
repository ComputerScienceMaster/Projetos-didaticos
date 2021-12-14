# Diet Control

Seja bem vindo ao repositório do aplicativo "Diet Control". Esse projeto foi idealizado para ajudar pacientes que necessitam realizar o controle diário/semanal/mensal da sua dieta seguindo uma metodologia bastante específica de controle. O aplicativo poderá ser construído usando qualquer linguagem/tecnologia tanto para web ou mobile desde que siga todos os requisitos do projeto. 

O projeto inicialmente será desevolvido em duas fases principais: 
1- Proposta do MVP (mínimo produto viável) em que todos os requisitos mínimos devem ser satisfeitos
2- Versão 1.0 do aplicativo será lançada quando todo os requisitos mínimos e também os requisitos funcionais/não funcionais estiverem implementados e testados.

## Fase 01 - MVP

O primeiro projeto será o MVP do produto, ou seja, uma sistema deverá ser implementado para satisfazer os requisitos mínimos de funcionamento, são eles: 

### Requisitos mínimos

- RF01 - O sistema deve possuir uma funcionalidade de login e senha (mesmo que esse sistema seja projetado para funcionar com apenas 1 usuário)
- RF02 - O sistema permitir o registro diário de peso, "escapadas" e jejum
- RF03 - O balanço (Relatório) deve permitir mostrar os registros de apenas 1 dia ou agrupar esses registros por semana ou mensalmente
- RF04 - O balanço deverá mostrar a evolução de peso, saldo de escapadas/jejum dado um determinado periodo

O MVP do projeto será implementado usando as seguintes tecnologias:
1. HTML
2. CSS (básico)
3. PHP
4. JSON (para armazenar dados)


## FASE 02 - Versão 1.0

Essa fase deverá implementar as funcionalidades descritas na seçãode requisitos funcionais e também não funcionais, são eles:

### Requisitos funcionais

- RF01 - O sistema deve possuir a capacidade de armazenar os dados de diversos usuários (inclusive login e senha, nome, data de nascimento, email, telefone)
- RF02 - O sistema deverá armazenar os dados fisiológicos do usuário (altura, peso)
- RF03 - O sistema deverá ter uma área para modificação de dados do perfil do usuário 
- RF04 - O sistema deverá permitir o registro (e manipulação) de apontamentos que contém: data atual, hora, peso atual, número de escapadas (opcional de inserção de descrição), número de jejum (opcional a inserção de horário de jejum).
- RF05 - O Sistema deverá mostrar na tela inicial um resumo das atividades (agrupados por semana) com possibilidade de clicar e expandir para mostrar a semana toda (detalhado por dias)
- RF06 - O sistema deverá mostrar um "score" baseado no saldo das ultimas 4 semanas. O número de escapadas e o cálculo do ganho de peso deverá ser usado.


Para a segunda fase, o projeto deverá ser implementado usando as seguintes tecnologias:
1. HTML
2. CSS (responsivo, Opcional: uso de frameworks como o bootstrap)
3. Javascript (elementos interativos ou chamadas assíncronas)
4. Banco de dados relacional (MySQL)
5. PHP
