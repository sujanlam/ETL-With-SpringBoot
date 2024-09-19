pipeline{
    agent any
    tools{
        maven 'Maven_3_9_9'
    }
    stages {
        stage('Build Maven'){
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sujanlam/ETLSpringbootMongoPOI.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t sujan/etl-with-springboot .'
                }
            }
        }
        stage('Push Image to Docker Hub') {
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd'), string(credentialsId: 'dockerhubpwd', variable: '')]) {
                        sh 'docker login -u sujann42 -p{dockerhubpwd}'
                        sh 'docker push etl-with-springboot'
                    }
                }
            }
        }
    }
}