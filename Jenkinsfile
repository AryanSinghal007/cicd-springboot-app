pipeline {
    agent any

    environment {
        SPRING_PORT = "9089"
    }

    tools {
        maven 'Maven 4'
        jdk 'Java 17'
    }

    stages {
        stage('Clone Code') {
            steps {
                echo '📦 Cloning repository...'
                git 'https://github.com/your-username/your-repo.git' // Replace this
            }
        }

        stage('Build App') {
            steps {
                echo '🔧 Building application...'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Run App') {
            steps {
                echo '🚀 Stopping existing app (if any) on port 9089...'
                sh 'fuser -k ${SPRING_PORT}/tcp || true'

                echo '🚀 Starting Spring Boot app on port 9089...'
                sh '''
                    nohup java -jar target/*.jar --server.port=${SPRING_PORT} > springboot.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Deployment Failed!'
        }
    }
}
