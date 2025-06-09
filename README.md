# 🚨 Projeto Alerta SP – Painel do Usuário (MVC)

![Java](https://img.shields.io/badge/-Java-orange?logo=java\&logoColor=white)
![Spring MVC](https://img.shields.io/badge/-Spring%20MVC-green?logo=spring\&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/-Thymeleaf-blue?logo=thymeleaf\&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/-RabbitMQ-ff6600?logo=rabbitmq\&logoColor=white)

## 👥 Equipe do Projeto

| Matrícula | Nome                            |
| --------- | ------------------------------- |
| 553568    | Sabrina da Motta Café           |
| 552692    | Luís Henrique Oliveira Da Silva |
| 554199    | Matheus Duarte Oliveira         |

## 📌 Links

Link Vídeo Apresentação Java: https://youtu.be/8_yusiZXgJ4

Link Vídeo Pitch: https://www.youtube.com/watch?v=x8Oygxk1--8

Fique a vontade para cadastrar um novo usuario e testar


## 📌 Descrição Geral

O **Alerta SP** é um sistema inteligente de monitoramento em tempo real, focado na prevenção e alerta sobre enchentes e desastres naturais. Este projeto utiliza tecnologia IoT, integrando sensores em áreas críticas para fornecer notificações rápidas e precisas.

## 🚀 Papel do Java no Projeto

A linguagem **Java** é responsável pelo backend da aplicação do usuário, utilizando o framework **Spring MVC**:

* ✅ Controla a navegação e renderização das páginas.
* ✅ Processa formulários (login, cadastro, edição).
* ✅ Comunicação com o banco de dados via JPA/Hibernate.
* ✅ Segurança robusta com autenticação via OAuth2 (GitHub).
* ✅ Gestão das regras de negócio (alertas personalizados, favoritos, históricos).

## 🛠️ Funcionalidades do Painel Usuário (`/usuario/**`)

* 👤 **Login e Cadastro**

    * Criação e acesso seguro às contas de usuário

* 📱 **Dashboard Personalizado**

    * Visualização de alertas recebidos em tempo real

* 🌟 **Favoritos**

    * Marcar e acompanhar córregos preferidos

* 📅 **Histórico de Alertas**

    * Consulta de alertas anteriores e eventos registrados

* 🛡️ **Atualização de Dados Pessoais**

    * Atualizar e-mail, telefone e senha

## 🔑 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.5.0**
* **Spring Security** com OAuth2
* **Thymeleaf** para templates HTML dinâmicos
* **RabbitMQ** para mensageria em tempo real
* **MySQL** como banco de dados

## 🚧 Pré-requisitos

* Java JDK 17
* Maven 3.x
* MySQL (Banco de dados)
* RabbitMQ

## 🖥️ Como Executar o Projeto

1. Clone o repositório:

   ```bash
   git clone <link_do_repositório>
   ```

2. Configure o banco de dados no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/alerta_sp
   spring.datasource.username=root
   spring.datasource.password=sua_senha

   # Porta específica para o Painel do Usuário
   server.port=8081
   ```

3. Execute o projeto via Maven:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse o sistema:

   ```
   http://localhost:8081/usuario
   ```


