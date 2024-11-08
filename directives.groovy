pipeline {
    agent any 
    environment {
        Var1 = "building"
    }
    stages {
        stage('build') {
            steps {
                echo " This is ${Var1}"
            }
        }
    }
}