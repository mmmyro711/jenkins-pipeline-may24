pipeline {
    agent any
    stages {
        stage('Build'){
            steps {
                sh 'hostnamectl'
            }
        }
        stage('test'){
            steps {
                sh 'touch test.txt'
            }
        }
    }
}