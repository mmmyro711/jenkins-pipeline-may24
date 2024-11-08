pipeline {
    agent any 
    environment {
        Var1 = "building"
        Var2 = "testing"
        Var3 = "success"
    }
    stages {
        stage('build') {
            steps {
                echo " This is ${Var1}"
            }
        }
        stage('Test'){
            steps{
                echo "This is ${env.Var2}"
            }
        }
        stage('Echo BUILD_NUMBER') {
            steps {
                echo "Current build number: ${env.BUILD_NUMBER}"
            }
        }
        stage('Echo JOB_NAME') {
            steps {
                echo "Current build number: ${env.JOB_NAME}"
            }    
        }
    }
}