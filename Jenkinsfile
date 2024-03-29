pipeline {
    agent any

    tools {
            maven '3.9.2'
        }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the source code from GitHub...'
                git 'https://github.com/renegaat/StockAI.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building stockai repo...'
                sh 'mvn clean package -DskipTests'
            }
        }

       stage('Test') {
                steps {
                    echo 'Running unit tests...'
                    sh 'mvn test'
                }
            }

        stage('Container Deploy') {
                    environment {
                        DOCKER_REGISTRY = 'renegaat'
                        IMAGE_NAME = 'stockairepo'
                        IMAGE_TAG = 'latest'
                    }

                    steps {
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                            sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                        }
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -f application/app-stockairepo/Dockerfile -t $DOCKER_REGISTRY/$IMAGE_NAME:$IMAGE_TAG .'
                        sh 'docker push $DOCKER_REGISTRY/$IMAGE_NAME:$IMAGE_TAG'
                    }
                }
    }
}
