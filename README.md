# Trabalho de Estruturas de Dados

Este projeto implementa um sistema acadêmico para gerenciar a chamada pública de contratação de docentes em uma faculdade. O sistema possui interface gráfica em **JavaFX**, persistência em arquivos `.csv` e utiliza **estruturas de dados clássicas** implementadas manualmente.

---

## 🚀 Como executar

1. **Use o comando para compilar:**
   ```bash
   mvn clean javafx:run
   
---

## 📚 Funcionalidades

- CRUD completo para:
  - Cursos
  - Disciplinas
  - Professores
  - Inscrições
  
- Consultas:
  - Listagem de cursos, disciplinas e professores utilizando fila
  - Consulta de inscritos em uma disciplina, ordenados por pontuação (QuickSort)
  - Consulta de disciplinas de todos os cursos com processos abertos (usando HashTable)
- Remoção em cascata de inscrições ao excluir uma disciplina
- Persistência automática em arquivos `.csv`

- Estruturas de dados implementadas:
  - Lista encadeada (`LinkedList`)
  - Fila (`Queue`)
  - Lista ordenada (`OrderedList` com QuickSort)
  - Tabela hash (`HashTable`)

---

## 🛠️ Tecnologias

- Java 17+
- JavaFX
- Maven (build, execução e dependências)
- OpenCSV (leitura/escrita de `.csv`)

---

## 📁 Estrutura do Projeto
```
│
├── pom.xml
├── README.md
├── cursos.csv
├── disciplinas.csv
├── professores.csv
├── inscricoes.csv
└── src/
    └── main/
        ├── java/com/faculdade/
        │   ├── model/         # Entidades do sistema
        │   ├── repository/    # Acesso a arquivos CSV
        │   ├── service/       # Regras de negócio
        │   ├── structures/    # Estruturas de dados manuais
        │   └── ui/            # Interface gráfica JavaFX
        └── resources/         # Recursos adicionais

