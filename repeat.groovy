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
        stage('TestTerraform'){
            steps {
                sh 'terraform -v'
            }
        }
    }
}