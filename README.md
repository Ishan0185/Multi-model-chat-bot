#  Multi-Model Chat Client (Spring Boot + Spring AI)

A Spring Boot application that integrates both **Ollama (local LLM)** and **OpenAI (cloud LLM)** using [Spring AI](https://docs.spring.io/spring-ai/reference/). This project enables seamless switching between models via REST endpoints, ideal for experimentation, benchmarking, or hybrid deployments.

---

##  Features

- Dual LLM support: Ollama (local) + OpenAI (cloud)
- Built with Java 17, Spring Boot 3.5.9 and Spring AI 1.1.2
- REST API endpoints for model interaction
- Ollama runs inside WSL Ubuntu 24.04 (no systemd)
- Models/configs stored off C: drive for system cleanliness

---

## ️ Setup Instructions

### Import Ubuntu 24.04 to D:
    wsl --import Ubuntu D:\WSL\Ubuntu D:\WSL\Images\ubuntu-24.04-server-cloudimg-amd64-root.tar.xz

### Launch and configure user
    wsl -d Ubuntu
    sudo adduser <your_user_name>
    sudo usermod -aG sudo <your_user_name>

### Set default user
    sudo nano /etc/wsl.conf

    Add:
    [user]
    default=<your_user_name>

### Restart WSL
    wsl --shutdown
    wsl -d Ubuntu

### Inside Ubuntu
    sudo apt update && sudo apt upgrade -y
    curl -fsSL https://ollama.com/install.sh | sh

##  Install & Run Ollama

### Start Ollama manually
    ollama serve &

In a different terminal

    ollama run llama2

##  Spring Boot Configuration

### Full configuration is in:
    src/main/resources/application.properties

### Key settings:

- Ollama base URL: http://localhost:11434
- Ollama model: llama2
- OpenAI model: gpt-4o-mini
- API key injected via ${OPENAI_API_KEY}
- Server port: 8080

## Dependencies

### Full dependency management is in:
    pom.xml

### Key dependencies:
- spring-boot-starter-web
- spring-ai-starter-model-ollama
- spring-ai-starter-model-openai
- spring-boot-starter-test
- BOM: spring-ai-bom (version 1.1.2)

## REST Endpoints

    Endpoint                    Description
    /chat/ollama?prompt=...	    Chat with Ollama (local)
    /chat/openai?prompt=...	    Chat with OpenAI (cloud)

## Test

###  Run the app
    mvn spring-boot:run

### Example requests
    curl "http://localhost:8080/chat/ollama?prompt=Hello"
    curl "http://localhost:8080/chat/openai?prompt=Hello"

## Project Structure

    com.genAi.ChatClient
    ├── MultiModelChatClientApplication.java
    ├── config/
    │   └── ChatClientConfig.java
    ├── service/
    │   └── ChatService.java
    ├── controller/
    │   └── MultiModelController.java
    └── resources/
        └── application.properties

