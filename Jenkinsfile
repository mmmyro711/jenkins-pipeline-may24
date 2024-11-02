pipeline {
    agent any 
    stages {
        stage ('stage1'){
            steps {
                echo 'This is stage1' // or sh ' echo "This is stage1"'
            }
        }
        stage ('stage2'){
            steps {
                sh 'hostnamectl'
            }
        }
        stage ('stage3'){
            steps {
                sh 'curl ifconfig.me'
            }
        }
    }
}