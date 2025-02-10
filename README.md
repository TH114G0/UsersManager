# UserManager API  

## 📌 Sobre o projeto  
O **UserManager** é uma API REST desenvolvida em **Java 17**, seguindo princípios de **boas práticas de programação** para um código limpo e escalável.  

A API permite **criar, editar, listar e excluir usuários**, garantindo segurança e organização dos dados. **Dados sensíveis não são retornados ou editáveis**, e a exclusão de um usuário apenas **inativa o perfil**, sem remover os dados do banco.  

## 🚀 Tecnologias utilizadas  
- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA**  
- **Flyway Migration**  
- **MySQL** (Gerenciado via **DBeaver**)  
- **Bean Validation**  
- **DTOs (Data Transfer Objects)**  
- **GlobalExceptionHandler**  

## 🏛️ Princípios e boas práticas  
O projeto foi desenvolvido com base em princípios que garantem um código **limpo, manutenível e escalável**:  

✔ **SOLID** – Código modular e de fácil manutenção.  
✔ **DRY (Don't Repeat Yourself)** – Redução da duplicação de código.  
✔ **KISS (Keep It Simple, Stupid)** – Código simples e fácil de entender.  
✔ **Injeção de Dependências** – Facilita a criação e o gerenciamento de objetos.  
✔ **Tratamento de Erros** – Respostas bem definidas via `GlobalExceptionHandler`.  
✔ **API REST** – Interface bem estruturada seguindo boas práticas de RESTful.  
✔ **Consultas otimizadas com Spring Data JPA** – Eficiência no acesso ao banco de dados.  

## ⚙️ Funcionalidades  
- **Criar usuário**: Cadastro de novos usuários, validando campos obrigatórios.  
- **Editar usuário**: Apenas campos específicos podem ser editados, garantindo a integridade dos dados.  
- **Listar usuários**: Retorna apenas informações seguras, ocultando dados sensíveis.  
- **Excluir usuário**: O perfil do usuário é marcado como **inativo**, sem excluir os dados do banco.  

## 📤 Endpoints da API  
| Método | Endpoint | Descrição |  
|--------|---------|-----------|  
| `POST` | `/users` | Cria um novo usuário |  
| `PUT` | `/users` | Edita um usuário (campos específicos) |  
| `GET` | `/users` | Lista todos os usuários ativos |  
| `DELETE` | `/users/{id}` | Inativa um usuário sem excluí-lo do banco |  

## ⚠️ Tratamento de erros  
Todos os endpoints possuem **tratamento de erros centralizado** via `GlobalExceptionHandler`, garantindo mensagens claras e padronizadas para cada tipo de exceção.  

## 🛠️ Configuração do Banco de Dados  
O projeto utiliza **MySQL** como banco de dados e a configuração está no arquivo **`application.yml`**.  

### 🔧 Exemplo de configuração (`application.yml`)  
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user_manager
    username: seu-usuario
    password: sua-senha
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: validate
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.MySQL8Dialect

  flyway:
    enabled: true
