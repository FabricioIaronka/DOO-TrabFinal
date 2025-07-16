# 📦 Sistema de Gerenciamento de Estoque e Vendas

Este é um sistema desktop desenvolvido em **Java**, utilizando o padrão **MVC**, com interface gráfica construída em **Swing** e estilizada com **FlatLaf**. O objetivo do sistema é gerenciar produtos, vendas e clientes em um ambiente de estoque, com controle de acesso por níveis de usuário.

---

## 🚀 Funcionalidades

- 🔐 Tela de login com autenticação de usuário e níveis de permissão (administrador, vendedor, gerente de estoque).
- 📦 Gerenciamento de produtos: cadastro, edição, exclusão e visualização.
- 🧾 Registro de vendas com múltiplos produtos e vínculo com clientes.
- 👥 Cadastro e consulta de clientes.
- 📊 Consulta de vendas por usuário e por cliente.
- 🎨 Interface moderna com FlatLaf.

---

## 🛠️ Tecnologias Utilizadas

- **Java 8+**
- **Swing** (interface gráfica)
- **FlatLaf** (tema moderno)
- **MySQL** (persistência dos dados)
- **JDBC** (acesso ao banco)
- **Apache Ant** (build system)

---

## 🧪 Banco de Dados

- O sistema utiliza um banco de dados **MySQL** chamado `gerenciador_estoque`.
- É necessário criar as tabelas com o script SQL incluído no projeto.
- Os dados são acessados via JDBC com as credenciais definidas na classe `util.Connection`.

> 💡 Certifique-se de que o servidor MySQL esteja rodando e configurado com o usuário e senha corretos antes de executar o sistema.

---

## 🖥️ Como Executar

### Pré-requisitos:

- Java JDK 8 ou superior
- MySQL Server
- Apache Ant
- IDE (recomendado: NetBeans)
- FlatLaf (adicionado como dependência no projeto)

### Passos:

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/FabricioIaronka/DOO-TrabFinal
   ```

2. **Importe o projeto na sua IDE** (NetBeans recomendado).

3. **Execute o script SQL** para criar o banco de dados:

   - O script pode estar em: `util.Connection/create_database.sql`

4. **Configure a conexão com o banco** na classe `util.Connection`:

   ```java
   String url = "jdbc:mysql://127.0.0.1:3306/gerenciador_estoque";
   String user = "root";
   String password = "sua_senha";
   ```

5. **Compile e execute com Ant** (ou direto pela IDE):

   ```bash
   ant run
   ```

6. **A tela inicial é a de login:**

   - Arquivo principal: `view.LoginTela.java`

---

## 🔒 Níveis de Acesso

| Tipo de Usuário     | Permissões |
|---------------------|------------|
| Administrador       | Acesso total |
| Vendedor            | Acesso ao estoque, vendas e clientes |
| Gerente de Estoque  | Gerencia produtos e acessa vendas |

---

## 📁 Estrutura do Projeto

```
src/
├── controller/
├── dao/
├── model/
├── exceptions/
├── util/
├── view/
└── Main.java
```

---

## 📄 Licença

Este projeto é de uso acadêmico e experimental. Sem garantia de produção.

---

## ✨ Créditos

Desenvolvido por Fabricio Iaronka e Cesar Machado.
