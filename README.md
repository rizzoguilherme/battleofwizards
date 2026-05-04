# ⚡ Battle of Wizards

Um projeto simples feito em Java para praticar os conceitos de **Programação Orientada a Objetos (POO)**, como Classes, Atributos, Métodos, Getters & Setters e **Agregação**.

Desenvolvido como exercício do curso de POO do professor **Gustavo Guanabara**.

---

## 📖 O que o projeto faz?

O programa simula um duelo mágico entre dois bruxos. Cada bruxo tem seus próprios atributos (nome, feitiços, vida, XP) e, rodada por rodada, eles se atacam e se defendem até que um deles fique sem vida. No final, o vencedor é anunciado!

---

## 🗂️ Estrutura do projeto

O projeto é dividido em **3 arquivos principais**:

```
battleofwizards/
├── Wizards.java          → Define o que é um Bruxo
├── Duel.java             → Define como funciona um Duelo
└── BattleOfWizards.java  → Cria os bruxos e inicia a batalha
```

---

## 🧙 Classe `Wizards.java`

Essa classe representa um **Bruxo**. Ela guarda todas as informações de um personagem e define o que ele pode fazer.

**Atributos:**

| Atributo         | Tipo     | Descrição                                      |
|------------------|----------|------------------------------------------------|
| `name`           | String   | Nome do bruxo                                  |
| `spell`          | String   | Nome do feitiço ofensivo                       |
| `dano`           | int      | Dano causado pelo feitiço                      |
| `xp`             | int      | Experiência — aumenta o dano do feitiço        |
| `defensiveSpell` | String   | Nome do feitiço defensivo                      |
| `defesa`         | int      | Dano absorvido ao se defender                  |
| `cloak`          | int      | Pontos de vida do bruxo                        |

**Métodos principais:**

- `castOffensiveSpell()` — O bruxo lança seu feitiço de ataque e calcula o dano.
- `castDefensiveSpell()` — O bruxo lança seu feitiço de defesa e calcula a absorção.
- `danoRecebido(int danoOponente)` — Recebe o dano do oponente, desconta a defesa e reduz o HP.
- `bow()` — O bruxo se inclina antes do duelo começar.

> 💡 O dano é calculado com base no feitiço usado + um bônus aleatório por XP (entre 0.5 e 1 de dano por ponto de XP).

---

## ⚔️ Classe `Duel.java` — Agregação

Essa classe representa um **Duelo** entre dois bruxos. Ela usa a classe `Wizards` como atributo — isso é chamado de **Agregação** em POO: uma classe que "tem" objetos de outra classe dentro dela.

**Atributos:**

| Atributo      | Tipo    | Descrição                                  |
|---------------|---------|--------------------------------------------|
| `duelistOne`  | Wizards | Primeiro bruxo do duelo                    |
| `duelistTwo`  | Wizards | Segundo bruxo do duelo                     |
| `winner`      | Wizards | Bruxo vencedor ao final                    |
| `rounds`      | int     | Contador de rodadas                        |
| `start`       | int     | Sorteia quem ataca primeiro (1 ou 2)       |

**Como o duelo funciona (`duel()`):**

1. Os dois bruxos se inclinam (`bow()`).
2. É sorteado quem vai atacar primeiro.
3. A cada rodada:
   - O bruxo da vez lança o feitiço ofensivo.
   - O oponente lança o feitiço defensivo.
   - O oponente recebe o dano (descontando sua defesa).
   - Se alguém chegar a 0 de vida, o duelo acaba.
4. O vencedor é quem ainda tiver HP restante.

---

## 🚀 Classe `BattleOfWizards.java`

Essa é a classe principal — é aqui que o programa começa a rodar.

Ela cria dois bruxos e inicia o duelo:

```java
Wizards w[] = new Wizards[2];

w[0] = new Wizards("Harry", "Expelliarmus", 5, "Protego", 50);
w[1] = new Wizards("Draco", "Expelliarmus", 4, "Protego", 55);

Duel duel = new Duel();

duel.setDuelistOne(w[0]);
duel.setDuelistTwo(w[1]);

duel.duel();
```

| Bruxo    | XP | HP |
|----------|----|----|
| Harry    | 5  | 50 |
| Draco    | 4  | 55 |

---

## 🧠 Conceitos de POO utilizados

- **Classe** — cada arquivo `.java` representa uma classe com seus próprios dados e comportamentos.
- **Encapsulamento** — os atributos são `private` e acessados através de Getters e Setters.
- **Agregação** — a classe `Duel` utiliza objetos do tipo `Wizards` como parte de seus atributos.
- **Construtores** — os objetos são criados já com seus valores iniciais definidos.
- **Aleatoriedade** — uso da classe `Random` para deixar os duelos imprevisíveis.

---

## ▶️ Como executar

1. Certifique-se de ter o **Java JDK** instalado.
2. Compile os arquivos dentro da pasta do projeto:

```bash
javac battleofwizards/*.java
```

3. Execute a classe principal:

```bash
java battleofwizards.BattleOfWizards
```

---

## 📚 Referências

- Curso de POO em Java — [Prof. Gustavo Guanabara](https://www.cursoemvideo.com/)
