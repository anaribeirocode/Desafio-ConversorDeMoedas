# Conversor de Moedas - Challenge ONE 🪙

## Descrição do Projeto
Este projeto é um conversor de moedas interativo via console, desenvolvido puramente em Java. Ele consome a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter taxas de câmbio dinâmicas e em tempo real, realizando cálculos de conversão precisos. O sistema foi desenvolvido como desafio prático da trilha de Java do **Programa ONE (Oracle Next Education)** em parceria com a Alura.

## ⚙️ Funcionalidades
- Menu interativo via linha de comando (Console).
- Suporte a 6 opções de conversão diretas e inversas envolvendo as moedas:
  - Dólar Americano (USD)
  - Real Brasileiro (BRL)
  - Peso Argentino (ARS)
  - Peso Colombiano (COP)
  - Peso Chileno (CLP)
- Arquitetura Orientada a Objetos, separando a lógica de interface (menu) da lógica de consumo de dados (API).
- Tratamento de respostas no formato JSON.

## 🛠️ Tecnologias Utilizadas
- **Java 21**: Linguagem base do projeto.
- **Biblioteca GSON (v2.13.1)**: Utilizada para a desserialização e manipulação do arquivo JSON recebido pela API.
- **Classes `HttpClient`, `HttpRequest` e `HttpResponse`**: Para a realização e gerenciamento das requisições web.
- **IntelliJ IDEA**: Ambiente de Desenvolvimento Integrado (IDE).
