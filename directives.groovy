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
            echo "This is ${env.Var2}"
        }
    }
}