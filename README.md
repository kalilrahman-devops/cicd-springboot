# CI/CD Pipeline — Spring Boot App Deployment

End-to-end CI/CD pipeline for a Spring Boot REST API using Jenkins, Docker, Kubernetes, and AWS EC2.

## Pipeline Flow

GitHub → Jenkins → Maven → Docker → DockerHub → Kubernetes

## Pipeline Stages

| Stage | Tool | What it does |
|-------|------|-------------|
| Checkout | Git/GitHub | Pulls latest code from repository |
| Build | Maven | Compiles source code and packages JAR |
| Test | JUnit | Runs unit tests |
| Docker Build | Docker | Builds container image |
| Docker Push | DockerHub | Pushes image to DockerHub registry |
| Deploy | Kubernetes | Deploys 2 replicas with rolling update |
| Verify | kubectl | Confirms pods and services are running |

## How It Works

1. Developer pushes code to GitHub
2. GitHub webhook triggers Jenkins pipeline automatically
3. Jenkins builds and tests the application
4. Docker image is built and pushed to DockerHub
5. Kubernetes pulls the latest image and deploys it
6. Rolling update ensures zero downtime deployment

## Project Structure

- `src/` — Spring Boot application source code
- `k8s/deployment.yaml` — Kubernetes deployment (2 replicas)
- `k8s/service.yaml` — NodePort service on port 30080
- `Dockerfile` — Container image definition
- `Jenkinsfile` — Pipeline stages definition
- `pom.xml` — Maven build configuration


## Tech Stack

- Java 21 + Spring Boot 3.2
- Jenkins (CI/CD automation)
- Maven (build and test)
- Docker + DockerHub (containerisation)
- Kubernetes/Minikube (orchestration)
- AWS EC2 (hosting)
- GitHub Webhooks (auto-trigger)

## Result

App deployed and serving traffic on Kubernetes:
- Endpoint: http://minikube-ip:30080
- Response: "Hello from Kalil's DevOps Pipeline! - Build Triggered by GitHub Webhook"
- Replicas: 2 pods running
