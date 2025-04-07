# 🏨 Sistema de Gestão Hoteleira em Java

Este projeto é um sistema básico de gerenciamento de hotel desenvolvido em **Java** com foco em **Programação Orientada a Objetos (POO)**. O sistema permite o cadastro de hóspedes e quartos, a realização de reservas com adição de serviços extras e a geração de faturas.

---

## ✨ Funcionalidades

- Cadastro de hóspedes e quartos (simples e luxo)
- Realização de reservas com verificação de disponibilidade
- Adição de serviços extras por reserva
- Geração de faturas com cálculo de valor total
- Exibição de informações de hóspedes, quartos e reservas

---

## 🧱 Estrutura de Classes

- **Pessoa (abstrata)** → Classe base com nome, CPF e telefone  
- **Hospede** → Subclasse de Pessoa com e-mail
- **Quarto (abstrata)** → Representa um quarto genérico
  - **QuartoSimples** → Inclui tipo de cama
  - **QuartoLuxo** → Inclui cama, jacuzzi, varanda e café da manhã
- **Servico** → Serviço avulso ou incluído na reserva
- **Reserva** → Associa um hóspede a um quarto com um período e serviços
- **Fatura** → Agrupa reservas e serviços cobrados
- **Hotel** → Controla o cadastro e listagem de hóspedes, quartos e reservas

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Orientação a Objetos
- Collections API (`List`, `Optional`)
- PlantUML (para diagrama de classes)

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/HugoNicolau/Java-POO-Hotel.git
   ``` 
2. Compile o projeto:
    ```bash
    javac App.java
    ```
3. Execute a aplicação:
    ```bash
    java App
    ```
Obs: o método main da classe App cria dados de exemplo para simular o uso do sistema.

---

## 📄 Exemplo de Saída

```yaml
--- Fatura João ---
Reserva - Quarto Simples: 101, Capacidade: 2, Preço por Noite: R$150.0, Tipo de Cama: Casal - Total: R$...
Servico: Lavanderia - R$50.0
TOTAL: R$...

--- Fatura Maria ---
Reserva - Quarto Luxo: 201, Capacidade: 2, Preço por Noite: R$300.0, Tipo de Cama: King, Jacuzzi: Sim, Café da Manhã: Sim, Varanda: Sim - Total: R$...
TOTAL: R$...
```
---

## 📊 Diagrama UML

Você pode visualizar o diagrama completo de classes do projeto clicando no link abaixo:

<a href="https://www.plantuml.com/plantuml/dpng/dLN1Sjj63BtpAxQvL6qYJzAZ9gD9HuwdwYIfMdLo1vUGXUbobzq5FQcRVe-_e5_W7uieB2YIIdIm3wRu03o-zx2YtYI6o6tjYkzuZpKQ-qyPuctnlLa5lwFRDiBZm-F_cCmTfHOe5UalyWr4g8rraDBFp97Abd5jWz_IFPgNqvQRuFbOUVNJDwTFFQ-cFU-Hzw4QDXpKhJrZt875L91-F4Wk8zoXC_yMvl3tt8AphOFu4Lo8inyMfWfjwR3uh-ZyTTnee4mSWS5iCAK0XTnRbcTdD1FEVQXnOROSoTyAOflT661qk0j-tFRy5ld3ORRJC85NpUuhw9-PPLh2JrHINFjTY3NOWAbhk0jKTPv4yIyXDLYXIiOQo9tnl-tGANbIN41bllHWBNEGcHEbXAnYzXYhFcAvcDUVvtDjw7f_Ro5oC6XIMnwjO9fiGrjq6ssDCImCUHR0GWEMAgXm03OHRTY4-24Genw1qrQE70VPEY1BwOccbSsGhIjE-AunsKWMmZY9eVmjrOt3f2wOch226hJz4jMbi8UFUDT-2XVvvqr8gQLVmRRtzxGmPGWEmKkDl7KjhM27r_0U_1ucTPdz215yDQmzGRSS4epW7n_0eEU8vk-ZXLI85Jacm-Ic5JNSKMqntj7ZGv0qvDRsKLIgRA1BJuXkKYr6EQMzlOjlbCl-rftg6Zr3_uOgLDdLrUTbZtRDVs0wb40Cw9qQe6fmiFVorLdeTqXGIM-HSyc-WU6jvmZTkgw1yGHlWSPW4c5fOTvHujTPvr8SGaMMWeUOuLc-whlWgHcfpN4QYixdI_KunDJY47hsykhgnsUwzoxF6-0sQfnoesbQH-Xvya8dHg_cLSdK_Pgndcbnv9tg9b9DKHuqV3aBCXIf1FAUP7GYKZv_ynT7rwuQSp3BuVQr9W7bKfIOj9PJM-hEAaWS8MQwMRwgWN6JyCxaCchPmJt6JAqSB_AYNXnFcVm_3EKkfVOM7VIZv7d4woXnBoxDpcggwMib9PtKoZRPdd8JucfpS_hX-wtXRjDk4A_EwACE8_d7GyJgYARUBLrMETXvfZiloD0vhYczGL-rjVi2" target="_blank">🔗 Diagrama UML</a>

---

## 🚀 Possíveis Melhorias Futuras

- Persistência de dados em arquivos

- Interface gráfica com JavaFX ou Swing

- Testes automatizados com JUnit

- Interface via terminal para interação dinâmica

---

## 📚 Aprendizados

Este projeto foi desenvolvido para praticar:

- Conceitos de abstração, encapsulamento, herança e polimorfismo

- Utilização de interfaces e classes abstratas

- Organização e legibilidade de código orientado a objetos

---

## 📌 Autor
Desenvolvido por Hugo Nicolau como parte de estudos de Programação Orientada a Objetos com Java.