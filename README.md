🗡️ RPG Java Console

Um RPG de terminal desenvolvido em Java, com sistema completo de batalha por turnos, progressão de nível, inventário e persistência de dados em JSON.
O jogador pode escolher uma classe, enfrentar inimigos escaláveis, evoluir atributos, derrotar um boss final e salvar seu progresso.

---

## 🎮 Funcionalidades

- Escolha de classe: Guerreiro/Mago/Arqueiro/Orc
- Sistema de batalha por turnos
- Geração dinâmica de inimigos baseada no nível do jogador
- Sistema de XP e progressão de nível
- Evolução automática de atributos (vida e dano)
- Sistema de inventário
- Drop aleatório de itens
- Boss final (Dragão)
- Sistema de salvar e carregar jogo (persistência em JSON)
- Organização em camadas (model, service, util, persistence)

---

## 🛠 Tecnologias Utilizadas

- Java 17+
- Gson (serialização e persistência em JSON)
- Programação Orientada a Objetos
- IntelliJ IDEA

---

## 🧠 Conceitos Aplicados

- Herança (Personagem → Jogador)
- Polimorfismo
- Encapsulamento
- Enum com atributos personalizados
- Factory Pattern (InimigoFactory)
- Service Layer (separação de regras de negócio)
- Manipulação de arquivos
- Tratamento de exceções
- Organização modular do projeto

---

## 🏗 Arquitetura do Projeto

O projeto foi estruturado com separação clara de responsabilidades:

- model → Entidades do domínio (Personagem, Jogador, Inimigo)
- service → Regras de negócio (batalha, progressão, lógica do jogo)
- persistence → Salvamento e carregamento em JSON
- util → Funções auxiliares

Essa estrutura permite fácil manutenção e expansão do sistema.

---

## ▶ Como Executar

1. Clone o repositório: https://github.com/xavier-188/java-rpg-poo.git
2. Abra o projeto no IntelliJ ou VS Code
3. Execute a classe Main
4. Aproveite o jogo no terminal

---

🤖 Uso de Inteligência Artificial

Durante o desenvolvimento, utilizei IA como ferramenta de apoio para:

- Esclarecimento de dúvidas conceituais
- Discussões sobre arquitetura
- Sugestões de melhoria
- Organização do README

Todo o código foi compreendido, adaptado e implementado por mim como parte do processo de aprendizado.

---

## 🚀 Melhorias Futuras

- Sistema de habilidades especiais
- Sistema de raridade de itens
- Modo Arena
- Interface gráfica (JavaFX ou Swing)
- Sistema de missões

---

## 👨‍💻 Autor

Enzo Xavier  
Estudante de Engenharia de Software  
